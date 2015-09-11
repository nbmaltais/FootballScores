package barqsoft.footballscores.api;

import android.app.IntentService;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.net.Uri;
import android.os.RemoteException;
import android.util.Log;
import android.support.v4.util.LongSparseArray;

import java.util.ArrayList;
import java.util.List;

import barqsoft.footballscores.APIKey;
import barqsoft.footballscores.Utils;
import barqsoft.footballscores.api.data.fixtures.Fixture;
import barqsoft.footballscores.api.data.fixtures.Fixtures;
import barqsoft.footballscores.api.data.soccerseasons.SoccerSeason;
import barqsoft.footballscores.api.data.team.Team;
import barqsoft.footballscores.api.data.teams.Teams;
import barqsoft.footballscores.provider.FootballScoresProvider;
import barqsoft.footballscores.provider.fixture.FixtureColumns;
import barqsoft.footballscores.provider.fixture.FixtureContentValues;
import barqsoft.footballscores.provider.soccerseason.SoccerseasonColumns;
import barqsoft.footballscores.provider.soccerseason.SoccerseasonContentValues;
import barqsoft.footballscores.provider.team.TeamColumns;
import barqsoft.footballscores.provider.team.TeamContentValues;
import barqsoft.footballscores.provider.team.TeamCursor;
import barqsoft.footballscores.provider.team.TeamSelection;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class ApiFetchService extends IntentService
{
    static final String TAG = ApiFetchService.class.getSimpleName();
    public static final String ACTION_UPDATE_DB = "barqsoft.footballscores.api.action.UPDATE_DB";
    public static final String ACTION_FETCH_SCORES = "barqsoft.footballscores.api.action.FETCH_SCORES";
    public static final String ACTION_UPDATE_SCORES = "barqsoft.footballscores.api.action.UPDATE_SCORES";
    public static final String ACTION_DATA_UPDATED = "barqsoft.footballscores.service.ACTION_DATA_UPDATED";
    private FootballData mService;
    private ContentResolver mContentResolver;

    final RequestInterceptor mRequestInterceptor = new RequestInterceptor() {
        @Override
        public void intercept(RequestFacade request) {
            request.addHeader("X-Auth-Token", APIKey.getKey(ApiFetchService.this));
        }
    };

    public static void fetchScores(Context ctx)
    {
        Intent intent = new Intent(ctx,ApiFetchService.class);
        intent.setAction(ACTION_FETCH_SCORES);
        ctx.startService(intent);
    }

    public static void updateScores(Context ctx)
    {
        Intent intent = new Intent(ctx,ApiFetchService.class);
        intent.setAction(ACTION_UPDATE_SCORES);
        ctx.startService(intent);
    }


    public ApiFetchService()
    {
        super("ApiFetchService");
    }


    static long getId(String href)
    {
        return Long.parseLong(Uri.parse(href).getLastPathSegment());
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://api.football-data.org")
                .setRequestInterceptor(mRequestInterceptor)
                .build();

        mService = restAdapter.create(FootballData.class);
        mContentResolver = getContentResolver();

    }

    @Override
    protected void onHandleIntent(Intent intent)
    {
        String action=intent.getAction();

        switch(action)
        {
            case ACTION_FETCH_SCORES:
                updateSoccerSeasonsIfNeeded();
                fetchFixtures();
                break;
            case ACTION_UPDATE_SCORES:
                updateFixtures();
                break;
            case ACTION_UPDATE_DB:
                updateSoccerSeasons();
                break;
        }


    }



    private void updateSoccerSeasonsIfNeeded()
    {
        if( Utils.needDbSync(this) )
        {
            updateSoccerSeasons();
        }
    }

    private void updateSoccerSeasons()
    {
        try
        {
            Log.d(TAG,"updateSoccerSeasons");

            mContentResolver.delete(TeamColumns.CONTENT_URI, null, null);
            mContentResolver.delete(SoccerseasonColumns.CONTENT_URI, null, null);

            Log.i(TAG, "fetchSoccerSeasons");
            List<SoccerSeason> soccerSeasons = mService.getSoccerSeasons();

            ArrayList<ContentProviderOperation> batch = new ArrayList<>();
            //HashMap<Long,Team> allTeams = new HashMap<>();
            LongSparseArray<Team> allTeams = new LongSparseArray<>();


            for (SoccerSeason season : soccerSeasons)
            {
                Log.d(TAG, "Soccer season caption = " + season.getCaption());

                long seasonId = getId(season.getLinks().getSelf().getHref());

                List<Team> teams = fetchTeams(seasonId);


                SoccerseasonContentValues seasonValues = new SoccerseasonContentValues();
                seasonValues.values().put(SoccerseasonColumns._ID, seasonId); // Set the same ID as the API
                seasonValues.putCaption(season.getCaption());
                seasonValues.putLastupdated(season.getLastUpdated());
                seasonValues.putLeague(season.getLeague());
                seasonValues.putYear(season.getYear());

                ContentProviderOperation op = ContentProviderOperation.newInsert(seasonValues.uri()).withValues(seasonValues.values()).build();
                batch.add(op);

                for (Team team : teams)
                {
                    long teamId = getId(team.getLinks().getSelf().getHref());

                    // Prevent duplicate ID. It can happen when a team is in champion league
                    if(allTeams.indexOfKey(teamId)<0)
                    {
                        allTeams.put(teamId, team);
                    }

                }
            }


            for(int i=0;i<allTeams.size();i++)
            {
                TeamContentValues teamValues = new TeamContentValues();

                long teamId = allTeams.keyAt(i);
                Team team = allTeams.valueAt(i);

                teamValues.values().put(TeamColumns._ID, teamId);
                teamValues.putCode(team.getCode());
                teamValues.putCreasturl(team.getCrestUrl());
                teamValues.putName(team.getName());
                teamValues.putShortname(team.getShortName());

                batch.add(ContentProviderOperation.newInsert(teamValues.uri()).withValues(teamValues.values()).build());
            }

            mContentResolver.applyBatch(FootballScoresProvider.AUTHORITY, batch);

            Utils.setDBUpdatedTimestamp(this);
        }
        catch (RemoteException e)
        {
            Log.e(TAG, "Error in updateSoccerSeasons", e);
        }
        catch (OperationApplicationException e)
        {
            Log.e(TAG, "Error in updateSoccerSeasons", e);
        }
        catch(RetrofitError e)
        {
            Log.e(TAG, "Error in updateSoccerSeasons", e);
        }

    }

    private List<Team> fetchTeams(long season)
    {
        Log.d(TAG,"fetchTeams, season = " + season);

        Teams teams = mService.getSoccerSeasonsTeams(season);

        for (Team team : teams.getTeams())
        {
            Log.v(TAG, "  Team name = " + team.getName());
        }

        return teams.getTeams();
    }

    List<Fixture> fetchScores()
    {
        Fixtures previousFixtures = mService.getFixtures("p2");
        Fixtures nextFixtures = mService.getFixtures("n3");

        List<Fixture> scores = previousFixtures.getFixtures();
        scores.addAll(nextFixtures.getFixtures());

        return scores;
    }

    private void updateFixtures()
    {
        try
        {
            Log.d(TAG,"updateFixtures");

            ArrayList<ContentProviderOperation> batch = new ArrayList<>();
            List<Fixture> scores = fetchScores();
            for (Fixture score : scores)
            {
                long id = getId(score.getLinks().getSelf().getHref());

                FixtureContentValues values = new FixtureContentValues();


                values.putGoalsawayteam(score.getResult().getGoalsAwayTeam());
                values.putGoalshometeam(score.getResult().getGoalsHomeTeam());
                values.putStatus(score.getStatus());


                batch.add(ContentProviderOperation.newUpdate(values.uri()).withValues(values.values())
                        .withSelection(FixtureColumns._ID + "=?", new String[]{Long.toString(id)})
                        .build());
            }


            mContentResolver.applyBatch(FootballScoresProvider.AUTHORITY, batch);

            updateWidget();

        }
        catch (RemoteException e)
        {
            Log.e(TAG, "Error in fetchFixtures", e);
        }
        catch (OperationApplicationException e)
        {
            Log.e(TAG, "Error in fetchFixtures", e);
        }
        catch(RetrofitError e)
        {
            Log.e(TAG, "Error in fetchFixtures", e);
        }
    }

    private void fetchFixtures()
    {
        try
        {
            Log.d(TAG,"fetchFixtures");

            ArrayList<ContentProviderOperation> batch = new ArrayList<>();

            // Delete current scores
            batch.add(ContentProviderOperation.newDelete(FixtureColumns.CONTENT_URI).build());

            List<Fixture> scores = fetchScores();

            final String proj[] = {TeamColumns._ID,TeamColumns.CREASTURL};
            final String selection = FixtureColumns._ID + "=?";

            // first pass
            for (Fixture score : scores)
            {
                long id = getId(score.getLinks().getSelf().getHref());
                long season_id = getId(score.getLinks().getSoccerseason().getHref());
                long awayTeam_id = getId(score.getLinks().getAwayTeam().getHref());
                long homeTeam_id = getId(score.getLinks().getHomeTeam().getHref());
                Utils.DateTime dateTime = Utils.extractDateTime(score.getDate());

                FixtureContentValues values = new FixtureContentValues();

                values.values().put(FixtureColumns._ID, id);
                values.putSeasonId(season_id);
                //values.putAwayteamId(awayTeam_id);
                //values.putHometeamId(homeTeam_id);

                values.putAwayteamname(score.getAwayTeamName());
                values.putHometeamname(score.getHomeTeamName());
                values.putDate(dateTime.date);
                values.putTime(dateTime.time);
                values.putGoalsawayteam(score.getResult().getGoalsAwayTeam());
                values.putGoalshometeam(score.getResult().getGoalsHomeTeam());
                values.putStatus(score.getStatus());
                values.putMatchday(score.getMatchday());

                TeamSelection sel = new TeamSelection();
                TeamCursor teamCursor = sel.id(homeTeam_id).or().id(awayTeam_id).query(mContentResolver,proj);

                for(int i=0;i<2;i++)
                {
                    teamCursor.moveToPosition(i);
                    if (teamCursor.getId() == awayTeam_id)
                        values.putAwayteamcresturl(teamCursor.getCreasturl());
                    else
                        values.putHometeamcresturl(teamCursor.getCreasturl());
                }

                teamCursor.close();

                batch.add(ContentProviderOperation.newInsert(values.uri()).withValues(values.values()).build());
            }


            mContentResolver.applyBatch(FootballScoresProvider.AUTHORITY, batch);

            updateWidget();

        }
        catch (RemoteException e)
        {
            Log.e(TAG, "Error in fetchFixtures", e);
        }
        catch (OperationApplicationException e)
        {
            Log.e(TAG, "Error in fetchFixtures", e);
        }
        catch(RetrofitError e)
        {
            Log.e(TAG, "Error in fetchFixtures", e);
        }
    }

    private void updateWidget()
    {
        Log.d(TAG,"updateWidget");
        Intent intent = new Intent();
        intent.setAction(ACTION_DATA_UPDATED);
        intent.setPackage(getPackageName()); // only send intent to our app
        sendBroadcast(intent);
    }
}

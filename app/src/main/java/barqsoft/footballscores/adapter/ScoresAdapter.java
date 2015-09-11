package barqsoft.footballscores.adapter;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import barqsoft.footballscores.R;
import barqsoft.footballscores.Utils;
import barqsoft.footballscores.provider.fixture.FixtureCursor;
import barqsoft.footballscores.svg.CrestImageLoader;

/**
 * Created by yehya khaled on 2/26/2015.
 */
public class ScoresAdapter extends CursorAdapter
{
    public static final int COL_HOME = 3;
    public static final int COL_AWAY = 4;
    public static final int COL_HOME_GOALS = 6;
    public static final int COL_AWAY_GOALS = 7;
    public static final int COL_DATE = 1;
    public static final int COL_LEAGUE = 5;
    public static final int COL_MATCHDAY = 9;
    public static final int COL_ID = 8;
    public static final int COL_MATCHTIME = 2;
    private long detail_match_id = 0;
    private String FOOTBALL_SCORES_HASHTAG = "#Football_Scores";
    public ScoresAdapter(Context context, Cursor cursor, int flags)
    {
        super(context,cursor,flags);
    }



    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent)
    {
        View mItem = LayoutInflater.from(context).inflate(R.layout.scores_list_item, parent, false);
        ViewHolder mHolder = new ViewHolder(mItem);
        mItem.setTag(mHolder);
        //Log.v(FetchScoreTask.LOG_TAG,"new View inflated");
        return mItem;
    }

    @Override
    public void bindView(View view, final Context context, Cursor cursor)
    {
        final ViewHolder mHolder = (ViewHolder) view.getTag();

        Context ctx = view.getContext();

        /*String homeTeam = mCursor.getString(COL_HOME);
        String awayTeam = mCursor.getString(COL_AWAY);
        String date = mCursor.getString(COL_MATCHTIME);
        int goalsHome = mCursor.getInt(COL_HOME_GOALS);
        int goalsAway =  mCursor.getInt(COL_AWAY_GOALS);
        String scores = Utils.getScores(goalsHome, goalsAway);
        double match_id = mCursor.getDouble(COL_ID);
        int homeCrestRedId = Utils.getTeamCrestByTeamName(mCursor.getString(COL_HOME));
        int awayCrestResId = Utils.getTeamCrestByTeamName(mCursor.getString(COL_AWAY));*/

        FixtureCursor scoresCursor = new FixtureCursor(cursor);
        String homeTeam = scoresCursor.getHometeamname();
        String awayTeam = scoresCursor.getAwayteamname();
        String time = scoresCursor.getTime();
        int goalsHome =scoresCursor.getGoalshometeam();
        int goalsAway =  scoresCursor.getGoalsawayteam();
        String status = scoresCursor.getStatus();
        String scores = Utils.getScores(goalsHome, goalsAway);
        long match_id = scoresCursor.getId();
        //int homeCrestRedId = Utils.getTeamCrestByTeamName(homeTeam);
        //int awayCrestResId = Utils.getTeamCrestByTeamName(awayTeam);
        int matchday = scoresCursor.getMatchday();
        String league = scoresCursor.getSoccerseasonCaption();
        String homeCrestUrl = scoresCursor.getHometeamcresturl();
        String awayCrestUrl = scoresCursor.getAwayteamcresturl();

        mHolder.home_name.setText(homeTeam);
        mHolder.home_name.setContentDescription(context.getString(R.string.a11y_home_team, homeTeam));

        mHolder.away_name.setText(awayTeam);
        mHolder.away_name.setContentDescription(context.getString(R.string.a11y_away_team, awayTeam));

        mHolder.date.setText(time);
        mHolder.away_name.setContentDescription(context.getString(R.string.a11y_matchtime, time));

        mHolder.score.setText(scores);
        mHolder.away_name.setContentDescription(context.getString(R.string.a11y_score, goalsHome, goalsAway));

        mHolder.match_id = match_id;

        // Content description for images would be redundant since the team name are sufficient.
        //mHolder.home_crest.setImageResource(homeCrestRedId);
        //mHolder.away_crest.setImageResource(awayCrestResId);

        if(homeCrestUrl!=null)
            CrestImageLoader.loadCrestIntoImageView(ctx, Uri.parse(homeCrestUrl), mHolder.home_crest);
        else
            Glide.with(view.getContext()).load(R.drawable.no_icon).into(mHolder.home_crest);

        if(awayCrestUrl!=null)
            CrestImageLoader.loadCrestIntoImageView(ctx, Uri.parse(awayCrestUrl), mHolder.away_crest);
        else
            Glide.with(view.getContext()).load(R.drawable.no_icon).into(mHolder.away_crest);

        //Log.v(FetchScoreTask.LOG_TAG,mHolder.home_name.getText() + " Vs. " + mHolder.away_name.getText() +" id " + String.valueOf(mHolder.match_id));
        //Log.v(FetchScoreTask.LOG_TAG,String.valueOf(detail_match_id));
        LayoutInflater vi = (LayoutInflater) context.getApplicationContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = vi.inflate(R.layout.detail_fragment, null);
        ViewGroup container = (ViewGroup) view.findViewById(R.id.details_fragment_container);
        if(mHolder.match_id == detail_match_id)
        {
            //Log.v(FetchScoreTask.LOG_TAG,"will insert extraView");

            container.addView(v, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT
                    , ViewGroup.LayoutParams.MATCH_PARENT));
            TextView matchDayView = (TextView) v.findViewById(R.id.matchday_textview);
            TextView leagueView = (TextView) v.findViewById(R.id.league_textview);
            TextView statusView = (TextView) v.findViewById(R.id.status_textview);

            //int matchday = cursor.getInt(COL_MATCHDAY);
            //int league = cursor.getInt(COL_LEAGUE);

            matchDayView.setText(Utils.getMatchDay(context, matchday));

            //leagueView.setText(Utils.getLeague(context, league));
            leagueView.setText(league);

            statusView.setText( context.getString(R.string.match_status,status) );

            Button share_button = (Button) v.findViewById(R.id.share_button);
            share_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    //add Share Action
                    context.startActivity(createShareForecastIntent(mHolder.home_name.getText()+" "
                    +mHolder.score.getText()+" "+mHolder.away_name.getText() + " "));
                }
            });
        }
        else
        {
            container.removeAllViews();
        }

    }
    public Intent createShareForecastIntent(String ShareText) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, ShareText + FOOTBALL_SCORES_HASHTAG);
        return shareIntent;
    }

    public void setDetailMatchId( long id )
    {
        detail_match_id=id;

        notifyDataSetChanged();
    }

}

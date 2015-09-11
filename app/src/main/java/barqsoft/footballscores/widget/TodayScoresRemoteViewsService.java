package barqsoft.footballscores.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Binder;
import android.os.Build;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import java.text.SimpleDateFormat;
import java.util.Date;

import barqsoft.footballscores.R;
import barqsoft.footballscores.Utils;
import barqsoft.footballscores.provider.fixture.FixtureCursor;
import barqsoft.footballscores.provider.fixture.FixtureSelection;

/**
 * Created by Nicolas on 2015-07-13.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class TodayScoresRemoteViewsService extends RemoteViewsService
{
    static final String LOG_TAG = TodayScoresRemoteViewsService.class.getSimpleName();

    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent)
    {
        return new TodayScoresRemoteViewsFactory(this);
    }

    static class TodayScoresRemoteViewsFactory implements RemoteViewsFactory
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
        private final Context mContext;
        private Cursor mCursor = null;

        TodayScoresRemoteViewsFactory(Context context)
        {
            mContext = context;
        }

        @Override
        public void onCreate()
        {

        }

        @Override
        public void onDataSetChanged()
        {
            if(mCursor!=null)
                mCursor.close();

            Log.d(LOG_TAG,"onDataSetChanged");
            // TODO: query DB for today match

            Date date = new Date(System.currentTimeMillis());
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            String[] args = new String[1];
            args[0] = format.format(date);


            final long identityToken = Binder.clearCallingIdentity();

            //Uri uri = DatabaseContract.scores_table.buildScoreWithDate();
            //mCursor = mContext.getContentResolver().query(uri,null,null,args,null);

            FixtureSelection sel = new FixtureSelection();
            sel.date(args[0]);

            mCursor = sel.query(mContext.getContentResolver());

            Binder.restoreCallingIdentity(identityToken);


        }

        @Override
        public void onDestroy()
        {
            if (mCursor != null)
            {
                mCursor.close();
                mCursor = null;
            }
        }

        @Override
        public int getCount()
        {
            if(mCursor==null)
                return 0;
            return mCursor.getCount();

           // return 2;

        }

        @Override
        public RemoteViews getViewAt(int position)
        {
           /* Log.d(LOG_TAG,"getViewAt position = " + position);
            RemoteViews views = new RemoteViews(mContext.getPackageName(), R.layout.scores_widget_item);
            String scores = Integer.toString(position);
            views.setTextViewText(R.id.widget_score_view, scores);

            return views;*/


            if (position == AdapterView.INVALID_POSITION ||  mCursor == null || !mCursor.moveToPosition(position))
            {
                return null;
            }

            Log.d(LOG_TAG,"getViewAt position = " + position);


            /*String homeTeam = mCursor.getString(COL_HOME);
            String awayTeam = mCursor.getString(COL_AWAY);
            String date = mCursor.getString(COL_MATCHTIME);
            String scores = Utils.getScores(mCursor.getInt(COL_HOME_GOALS), mCursor.getInt(COL_AWAY_GOALS));
            double match_id = mCursor.getDouble(COL_ID);
            int homeCrestRedId = Utils.getTeamCrestByTeamName(mCursor.getString(COL_HOME));
            int awayCrestResId = Utils.getTeamCrestByTeamName(mCursor.getString(COL_AWAY));*/

            FixtureCursor scoresCursor = new FixtureCursor(mCursor);
            String homeTeam = scoresCursor.getHometeamname();
            String awayTeam = scoresCursor.getAwayteamname();
            String date = scoresCursor.getTime();
            int goalsHome =scoresCursor.getGoalshometeam();
            int goalsAway =  scoresCursor.getGoalsawayteam();
            String scores = Utils.getScores(goalsHome, goalsAway);
            long match_id = scoresCursor.getId();
            //int homeCrestRedId = Utils.getTeamCrestByTeamName(homeTeam);
            //int awayCrestResId = Utils.getTeamCrestByTeamName(awayTeam);

            RemoteViews views = new RemoteViews(mContext.getPackageName(), R.layout.scores_widget_item);
            views.setTextViewText(R.id.home_name,homeTeam);
            views.setTextViewText(R.id.away_name,awayTeam);
            views.setTextViewText(R.id.score_textview,scores);
            views.setTextViewText(R.id.data_textview, date);
            //views.setImageViewResource(R.id.home_crest, homeCrestRedId);
            //views.setImageViewResource(R.id.away_crest, awayCrestResId);

            String awayteamcresturl = scoresCursor.getAwayteamcresturl();
            String hometeamcresturl = scoresCursor.getHometeamcresturl();

            // TODO: load image into remote views
            //CrestImageLoader.loadSvgIntoRemoteViews(mContext, Uri.parse(awayteamcresturl), views, awayCrestResId);


            return views;
        }

        @Override
        public RemoteViews getLoadingView()
        {
            return null;
        }

        @Override
        public int getViewTypeCount()
        {
            return 1;
        }

        @Override
        public long getItemId(int position)
        {
            return position;
        }

        @Override
        public boolean hasStableIds()
        {
            return false;
        }
    }
}

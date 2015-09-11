package barqsoft.footballscores;

import android.content.Context;
import android.preference.PreferenceManager;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by yehya khaled on 3/3/2015.
 */
public class Utils
{
    static final String LOG_TAG = Utils.class.getSimpleName();
    private static final String DB_TIMESTAMP = "DB_TIMESTAMP";
    private static final SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd");


    public static String getMatchDay(Context context, int match_day)
    {
        return context.getString(R.string.matchday,match_day);
    }
    public static String getMatchDay(Context context, int match_day,int league_num)
    {
        /*if(league_num == CHAMPIONS_LEAGUE)
        {
            if (match_day <= 6)
            {
                return context.getString(R.string.champ_league_mtachday);
            }
            else if(match_day == 7 || match_day == 8)
            {
                return context.getString(R.string.champ_league_knockout);
            }
            else if(match_day == 9 || match_day == 10)
            {
                return context.getString(R.string.champ_league_quarter_final);
            }
            else if(match_day == 11 || match_day == 12)
            {
                return context.getString(R.string.champ_league_semifinal);
            }
            else
            {
                return context.getString(R.string.champ_league_final);
            }
        }
        else*/
        {
            return context.getString(R.string.matchday,match_day);
        }
    }

    public static String getScores(int home_goals,int awaygoals)
    {
        if(home_goals < 0 || awaygoals < 0)
        {
            return " - ";
        }
        else
        {
            return String.valueOf(home_goals) + " - " + String.valueOf(awaygoals);
        }
    }



    public static boolean needDbSync(Context ctx)
    {
        long timestamp = PreferenceManager.getDefaultSharedPreferences(ctx).getLong(DB_TIMESTAMP,0);
        if(timestamp==0)
            return true;

        // TODO: we need to check if it is the start of a new season here
        return false;
    }

    public static void setDBUpdatedTimestamp(Context ctx)
    {
        PreferenceManager.getDefaultSharedPreferences(ctx).edit().putLong(DB_TIMESTAMP, System.currentTimeMillis()).commit();
    }

    public static String getCurrentDate()
    {
        long now = System.currentTimeMillis();
        Date dateNow = new Date(now);

        return mFormat.format(dateNow);

    }


    public static class DateTime
    {
        final public String date;
        final public String time;

        public DateTime(String date, String time)
        {
            this.date = date;
            this.time = time;
        }
    }

    static public DateTime extractDateTime(String datetime )
    {
        String time = datetime.substring(datetime.indexOf("T") + 1, datetime.indexOf("Z"));
        String date = datetime.substring(0,datetime.indexOf("T"));
        SimpleDateFormat match_date = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
        match_date.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            Date parseddate = match_date.parse(date+time);
            SimpleDateFormat new_date = new SimpleDateFormat("yyyy-MM-dd:HH:mm");
            new_date.setTimeZone(TimeZone.getDefault());
            date = new_date.format(parseddate);
            time = date.substring(date.indexOf(":") + 1);
            date = date.substring(0,date.indexOf(":"));

        }
        catch (Exception e)
        {
            Log.d(LOG_TAG, "error here!");
            Log.e(LOG_TAG,e.getMessage());
        }

        return new DateTime(date,time);
    }
}

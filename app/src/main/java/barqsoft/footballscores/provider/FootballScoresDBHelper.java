package barqsoft.footballscores.provider;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import barqsoft.footballscores.BuildConfig;
import barqsoft.footballscores.provider.fixture.FixtureColumns;
import barqsoft.footballscores.provider.soccerseason.SoccerseasonColumns;
import barqsoft.footballscores.provider.team.TeamColumns;

public class FootballScoresDBHelper extends SQLiteOpenHelper {
    private static final String TAG = FootballScoresDBHelper.class.getSimpleName();

    public static final String DATABASE_FILE_NAME = "FootballScores.db";
    private static final int DATABASE_VERSION = 1;
    private static FootballScoresDBHelper sInstance;
    private final Context mContext;
    private final FootballScoresDBHelperCallbacks mOpenHelperCallbacks;

    // @formatter:off
    public static final String SQL_CREATE_TABLE_FIXTURE = "CREATE TABLE IF NOT EXISTS "
            + FixtureColumns.TABLE_NAME + " ( "
            + FixtureColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + FixtureColumns.SEASON_ID + " INTEGER NOT NULL, "
            + FixtureColumns.DATE + " TEXT NOT NULL, "
            + FixtureColumns.TIME + " TEXT NOT NULL, "
            + FixtureColumns.STATUS + " TEXT NOT NULL, "
            + FixtureColumns.MATCHDAY + " INTEGER NOT NULL, "
            + FixtureColumns.GOALSHOMETEAM + " INTEGER NOT NULL, "
            + FixtureColumns.GOALSAWAYTEAM + " INTEGER NOT NULL, "
            + FixtureColumns.HOMETEAMNAME + " TEXT NOT NULL, "
            + FixtureColumns.AWAYTEAMNAME + " TEXT NOT NULL, "
            + FixtureColumns.HOMETEAMCRESTURL + " TEXT, "
            + FixtureColumns.AWAYTEAMCRESTURL + " TEXT "
            + ", CONSTRAINT fk_season_id FOREIGN KEY (" + FixtureColumns.SEASON_ID + ") REFERENCES soccerseason (_id) ON DELETE RESTRICT"
            + " );";

    public static final String SQL_CREATE_TABLE_SOCCERSEASON = "CREATE TABLE IF NOT EXISTS "
            + SoccerseasonColumns.TABLE_NAME + " ( "
            + SoccerseasonColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + SoccerseasonColumns.CAPTION + " TEXT NOT NULL, "
            + SoccerseasonColumns.LEAGUE + " TEXT NOT NULL, "
            + SoccerseasonColumns.LASTUPDATED + " TEXT NOT NULL, "
            + SoccerseasonColumns.YEAR + " TEXT NOT NULL "
            + " );";

    public static final String SQL_CREATE_TABLE_TEAM = "CREATE TABLE IF NOT EXISTS "
            + TeamColumns.TABLE_NAME + " ( "
            + TeamColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + TeamColumns.NAME + " TEXT NOT NULL, "
            + TeamColumns.CODE + " TEXT, "
            + TeamColumns.SHORTNAME + " TEXT, "
            + TeamColumns.CREASTURL + " TEXT NOT NULL "
            + " );";

    // @formatter:on

    public static FootballScoresDBHelper getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = newInstance(context.getApplicationContext());
        }
        return sInstance;
    }

    private static FootballScoresDBHelper newInstance(Context context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            return newInstancePreHoneycomb(context);
        }
        return newInstancePostHoneycomb(context);
    }


    /*
     * Pre Honeycomb.
     */
    private static FootballScoresDBHelper newInstancePreHoneycomb(Context context) {
        return new FootballScoresDBHelper(context);
    }

    private FootballScoresDBHelper(Context context) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION);
        mContext = context;
        mOpenHelperCallbacks = new FootballScoresDBHelperCallbacks();
    }


    /*
     * Post Honeycomb.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private static FootballScoresDBHelper newInstancePostHoneycomb(Context context) {
        return new FootballScoresDBHelper(context, new DefaultDatabaseErrorHandler());
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private FootballScoresDBHelper(Context context, DatabaseErrorHandler errorHandler) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION, errorHandler);
        mContext = context;
        mOpenHelperCallbacks = new FootballScoresDBHelperCallbacks();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        if (BuildConfig.DEBUG) Log.d(TAG, "onCreate");
        mOpenHelperCallbacks.onPreCreate(mContext, db);
        db.execSQL(SQL_CREATE_TABLE_FIXTURE);
        db.execSQL(SQL_CREATE_TABLE_SOCCERSEASON);
        db.execSQL(SQL_CREATE_TABLE_TEAM);
        mOpenHelperCallbacks.onPostCreate(mContext, db);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            setForeignKeyConstraintsEnabled(db);
        }
        mOpenHelperCallbacks.onOpen(mContext, db);
    }

    private void setForeignKeyConstraintsEnabled(SQLiteDatabase db) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            setForeignKeyConstraintsEnabledPreJellyBean(db);
        } else {
            setForeignKeyConstraintsEnabledPostJellyBean(db);
        }
    }

    private void setForeignKeyConstraintsEnabledPreJellyBean(SQLiteDatabase db) {
        db.execSQL("PRAGMA foreign_keys=ON;");
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void setForeignKeyConstraintsEnabledPostJellyBean(SQLiteDatabase db) {
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        mOpenHelperCallbacks.onUpgrade(mContext, db, oldVersion, newVersion);
    }
}

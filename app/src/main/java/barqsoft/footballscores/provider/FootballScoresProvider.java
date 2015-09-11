package barqsoft.footballscores.provider;

import java.util.Arrays;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;

import barqsoft.footballscores.BuildConfig;
import barqsoft.footballscores.provider.base.BaseContentProvider;
import barqsoft.footballscores.provider.fixture.FixtureColumns;
import barqsoft.footballscores.provider.soccerseason.SoccerseasonColumns;
import barqsoft.footballscores.provider.team.TeamColumns;

public class FootballScoresProvider extends BaseContentProvider {
    private static final String TAG = FootballScoresProvider.class.getSimpleName();

    private static final boolean DEBUG = BuildConfig.DEBUG;

    private static final String TYPE_CURSOR_ITEM = "vnd.android.cursor.item/";
    private static final String TYPE_CURSOR_DIR = "vnd.android.cursor.dir/";

    public static final String AUTHORITY = "barqsoft.footballscores.provider";
    public static final String CONTENT_URI_BASE = "content://" + AUTHORITY;

    private static final int URI_TYPE_FIXTURE = 0;
    private static final int URI_TYPE_FIXTURE_ID = 1;

    private static final int URI_TYPE_SOCCERSEASON = 2;
    private static final int URI_TYPE_SOCCERSEASON_ID = 3;

    private static final int URI_TYPE_TEAM = 4;
    private static final int URI_TYPE_TEAM_ID = 5;



    private static final UriMatcher URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        URI_MATCHER.addURI(AUTHORITY, FixtureColumns.TABLE_NAME, URI_TYPE_FIXTURE);
        URI_MATCHER.addURI(AUTHORITY, FixtureColumns.TABLE_NAME + "/#", URI_TYPE_FIXTURE_ID);
        URI_MATCHER.addURI(AUTHORITY, SoccerseasonColumns.TABLE_NAME, URI_TYPE_SOCCERSEASON);
        URI_MATCHER.addURI(AUTHORITY, SoccerseasonColumns.TABLE_NAME + "/#", URI_TYPE_SOCCERSEASON_ID);
        URI_MATCHER.addURI(AUTHORITY, TeamColumns.TABLE_NAME, URI_TYPE_TEAM);
        URI_MATCHER.addURI(AUTHORITY, TeamColumns.TABLE_NAME + "/#", URI_TYPE_TEAM_ID);
    }

    @Override
    protected SQLiteOpenHelper createSqLiteOpenHelper() {
        return FootballScoresDBHelper.getInstance(getContext());
    }

    @Override
    protected boolean hasDebug() {
        return DEBUG;
    }

    @Override
    public String getType(Uri uri) {
        int match = URI_MATCHER.match(uri);
        switch (match) {
            case URI_TYPE_FIXTURE:
                return TYPE_CURSOR_DIR + FixtureColumns.TABLE_NAME;
            case URI_TYPE_FIXTURE_ID:
                return TYPE_CURSOR_ITEM + FixtureColumns.TABLE_NAME;

            case URI_TYPE_SOCCERSEASON:
                return TYPE_CURSOR_DIR + SoccerseasonColumns.TABLE_NAME;
            case URI_TYPE_SOCCERSEASON_ID:
                return TYPE_CURSOR_ITEM + SoccerseasonColumns.TABLE_NAME;

            case URI_TYPE_TEAM:
                return TYPE_CURSOR_DIR + TeamColumns.TABLE_NAME;
            case URI_TYPE_TEAM_ID:
                return TYPE_CURSOR_ITEM + TeamColumns.TABLE_NAME;

        }
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        if (DEBUG) Log.d(TAG, "insert uri=" + uri + " values=" + values);
        return super.insert(uri, values);
    }

    @Override
    public int bulkInsert(Uri uri, ContentValues[] values) {
        if (DEBUG) Log.d(TAG, "bulkInsert uri=" + uri + " values.length=" + values.length);
        return super.bulkInsert(uri, values);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        if (DEBUG) Log.d(TAG, "update uri=" + uri + " values=" + values + " selection=" + selection + " selectionArgs=" + Arrays.toString(selectionArgs));
        return super.update(uri, values, selection, selectionArgs);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        if (DEBUG) Log.d(TAG, "delete uri=" + uri + " selection=" + selection + " selectionArgs=" + Arrays.toString(selectionArgs));
        return super.delete(uri, selection, selectionArgs);
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        if (DEBUG)
            Log.d(TAG, "query uri=" + uri + " selection=" + selection + " selectionArgs=" + Arrays.toString(selectionArgs) + " sortOrder=" + sortOrder
                    + " groupBy=" + uri.getQueryParameter(QUERY_GROUP_BY) + " having=" + uri.getQueryParameter(QUERY_HAVING) + " limit=" + uri.getQueryParameter(QUERY_LIMIT));
        return super.query(uri, projection, selection, selectionArgs, sortOrder);
    }

    @Override
    protected QueryParams getQueryParams(Uri uri, String selection, String[] projection) {
        QueryParams res = new QueryParams();
        String id = null;
        int matchedId = URI_MATCHER.match(uri);
        switch (matchedId) {
            case URI_TYPE_FIXTURE:
            case URI_TYPE_FIXTURE_ID:
                res.table = FixtureColumns.TABLE_NAME;
                res.idColumn = FixtureColumns._ID;
                res.tablesWithJoins = FixtureColumns.TABLE_NAME;
                if (SoccerseasonColumns.hasColumns(projection)) {
                    res.tablesWithJoins += " LEFT OUTER JOIN " + SoccerseasonColumns.TABLE_NAME + " AS " + FixtureColumns.PREFIX_SOCCERSEASON + " ON " + FixtureColumns.TABLE_NAME + "." + FixtureColumns.SEASON_ID + "=" + FixtureColumns.PREFIX_SOCCERSEASON + "." + SoccerseasonColumns._ID;
                }
                res.orderBy = FixtureColumns.DEFAULT_ORDER;
                break;

            case URI_TYPE_SOCCERSEASON:
            case URI_TYPE_SOCCERSEASON_ID:
                res.table = SoccerseasonColumns.TABLE_NAME;
                res.idColumn = SoccerseasonColumns._ID;
                res.tablesWithJoins = SoccerseasonColumns.TABLE_NAME;
                res.orderBy = SoccerseasonColumns.DEFAULT_ORDER;
                break;

            case URI_TYPE_TEAM:
            case URI_TYPE_TEAM_ID:
                res.table = TeamColumns.TABLE_NAME;
                res.idColumn = TeamColumns._ID;
                res.tablesWithJoins = TeamColumns.TABLE_NAME;
                res.orderBy = TeamColumns.DEFAULT_ORDER;
                break;

            default:
                throw new IllegalArgumentException("The uri '" + uri + "' is not supported by this ContentProvider");
        }

        switch (matchedId) {
            case URI_TYPE_FIXTURE_ID:
            case URI_TYPE_SOCCERSEASON_ID:
            case URI_TYPE_TEAM_ID:
                id = uri.getLastPathSegment();
        }
        if (id != null) {
            if (selection != null) {
                res.selection = res.table + "." + res.idColumn + "=" + id + " and (" + selection + ")";
            } else {
                res.selection = res.table + "." + res.idColumn + "=" + id;
            }
        } else {
            res.selection = selection;
        }
        return res;
    }
}

package barqsoft.footballscores.provider.fixture;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import barqsoft.footballscores.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code fixture} table.
 */
public class FixtureContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return FixtureColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable FixtureSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable FixtureSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public FixtureContentValues putSeasonId(long value) {
        mContentValues.put(FixtureColumns.SEASON_ID, value);
        return this;
    }


    public FixtureContentValues putDate(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("date must not be null");
        mContentValues.put(FixtureColumns.DATE, value);
        return this;
    }


    public FixtureContentValues putTime(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("time must not be null");
        mContentValues.put(FixtureColumns.TIME, value);
        return this;
    }


    public FixtureContentValues putStatus(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("status must not be null");
        mContentValues.put(FixtureColumns.STATUS, value);
        return this;
    }


    public FixtureContentValues putMatchday(int value) {
        mContentValues.put(FixtureColumns.MATCHDAY, value);
        return this;
    }


    public FixtureContentValues putGoalshometeam(int value) {
        mContentValues.put(FixtureColumns.GOALSHOMETEAM, value);
        return this;
    }


    public FixtureContentValues putGoalsawayteam(int value) {
        mContentValues.put(FixtureColumns.GOALSAWAYTEAM, value);
        return this;
    }


    public FixtureContentValues putHometeamname(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("hometeamname must not be null");
        mContentValues.put(FixtureColumns.HOMETEAMNAME, value);
        return this;
    }


    public FixtureContentValues putAwayteamname(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("awayteamname must not be null");
        mContentValues.put(FixtureColumns.AWAYTEAMNAME, value);
        return this;
    }


    public FixtureContentValues putHometeamcresturl(@Nullable String value) {
        mContentValues.put(FixtureColumns.HOMETEAMCRESTURL, value);
        return this;
    }

    public FixtureContentValues putHometeamcresturlNull() {
        mContentValues.putNull(FixtureColumns.HOMETEAMCRESTURL);
        return this;
    }

    public FixtureContentValues putAwayteamcresturl(@Nullable String value) {
        mContentValues.put(FixtureColumns.AWAYTEAMCRESTURL, value);
        return this;
    }

    public FixtureContentValues putAwayteamcresturlNull() {
        mContentValues.putNull(FixtureColumns.AWAYTEAMCRESTURL);
        return this;
    }
}

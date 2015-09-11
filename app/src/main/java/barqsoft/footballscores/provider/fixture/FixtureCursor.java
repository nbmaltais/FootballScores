package barqsoft.footballscores.provider.fixture;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import barqsoft.footballscores.provider.base.AbstractCursor;
import barqsoft.footballscores.provider.soccerseason.*;

/**
 * Cursor wrapper for the {@code fixture} table.
 */
public class FixtureCursor extends AbstractCursor implements FixtureModel {
    public FixtureCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(FixtureColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code season_id} value.
     */
    public long getSeasonId() {
        Long res = getLongOrNull(FixtureColumns.SEASON_ID);
        if (res == null)
            throw new NullPointerException("The value of 'season_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code caption} value.
     * Cannot be {@code null}.
     */
    @NonNull
    public String getSoccerseasonCaption() {
        String res = getStringOrNull(SoccerseasonColumns.CAPTION);
        if (res == null)
            throw new NullPointerException("The value of 'caption' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code league} value.
     * Cannot be {@code null}.
     */
    @NonNull
    public String getSoccerseasonLeague() {
        String res = getStringOrNull(SoccerseasonColumns.LEAGUE);
        if (res == null)
            throw new NullPointerException("The value of 'league' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code lastupdated} value.
     * Cannot be {@code null}.
     */
    @NonNull
    public String getSoccerseasonLastupdated() {
        String res = getStringOrNull(SoccerseasonColumns.LASTUPDATED);
        if (res == null)
            throw new NullPointerException("The value of 'lastupdated' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code year} value.
     * Cannot be {@code null}.
     */
    @NonNull
    public String getSoccerseasonYear() {
        String res = getStringOrNull(SoccerseasonColumns.YEAR);
        if (res == null)
            throw new NullPointerException("The value of 'year' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code date} value.
     * Cannot be {@code null}.
     */
    @NonNull
    public String getDate() {
        String res = getStringOrNull(FixtureColumns.DATE);
        if (res == null)
            throw new NullPointerException("The value of 'date' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code time} value.
     * Cannot be {@code null}.
     */
    @NonNull
    public String getTime() {
        String res = getStringOrNull(FixtureColumns.TIME);
        if (res == null)
            throw new NullPointerException("The value of 'time' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code status} value.
     * Cannot be {@code null}.
     */
    @NonNull
    public String getStatus() {
        String res = getStringOrNull(FixtureColumns.STATUS);
        if (res == null)
            throw new NullPointerException("The value of 'status' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code matchday} value.
     */
    public int getMatchday() {
        Integer res = getIntegerOrNull(FixtureColumns.MATCHDAY);
        if (res == null)
            throw new NullPointerException("The value of 'matchday' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code goalshometeam} value.
     */
    public int getGoalshometeam() {
        Integer res = getIntegerOrNull(FixtureColumns.GOALSHOMETEAM);
        if (res == null)
            throw new NullPointerException("The value of 'goalshometeam' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code goalsawayteam} value.
     */
    public int getGoalsawayteam() {
        Integer res = getIntegerOrNull(FixtureColumns.GOALSAWAYTEAM);
        if (res == null)
            throw new NullPointerException("The value of 'goalsawayteam' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code hometeamname} value.
     * Cannot be {@code null}.
     */
    @NonNull
    public String getHometeamname() {
        String res = getStringOrNull(FixtureColumns.HOMETEAMNAME);
        if (res == null)
            throw new NullPointerException("The value of 'hometeamname' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code awayteamname} value.
     * Cannot be {@code null}.
     */
    @NonNull
    public String getAwayteamname() {
        String res = getStringOrNull(FixtureColumns.AWAYTEAMNAME);
        if (res == null)
            throw new NullPointerException("The value of 'awayteamname' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code hometeamcresturl} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getHometeamcresturl() {
        String res = getStringOrNull(FixtureColumns.HOMETEAMCRESTURL);
        return res;
    }

    /**
     * Get the {@code awayteamcresturl} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getAwayteamcresturl() {
        String res = getStringOrNull(FixtureColumns.AWAYTEAMCRESTURL);
        return res;
    }
}

package barqsoft.footballscores.provider.soccerseason;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import barqsoft.footballscores.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code soccerseason} table.
 */
public class SoccerseasonCursor extends AbstractCursor implements SoccerseasonModel {
    public SoccerseasonCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(SoccerseasonColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code caption} value.
     * Cannot be {@code null}.
     */
    @NonNull
    public String getCaption() {
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
    public String getLeague() {
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
    public String getLastupdated() {
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
    public String getYear() {
        String res = getStringOrNull(SoccerseasonColumns.YEAR);
        if (res == null)
            throw new NullPointerException("The value of 'year' in the database was null, which is not allowed according to the model definition");
        return res;
    }
}

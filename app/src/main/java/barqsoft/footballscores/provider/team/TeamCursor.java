package barqsoft.footballscores.provider.team;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import barqsoft.footballscores.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code team} table.
 */
public class TeamCursor extends AbstractCursor implements TeamModel {
    public TeamCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(TeamColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code name} value.
     * Cannot be {@code null}.
     */
    @NonNull
    public String getName() {
        String res = getStringOrNull(TeamColumns.NAME);
        if (res == null)
            throw new NullPointerException("The value of 'name' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code code} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getCode() {
        String res = getStringOrNull(TeamColumns.CODE);
        return res;
    }

    /**
     * Get the {@code shortname} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getShortname() {
        String res = getStringOrNull(TeamColumns.SHORTNAME);
        return res;
    }

    /**
     * Get the {@code creasturl} value.
     * Cannot be {@code null}.
     */
    @NonNull
    public String getCreasturl() {
        String res = getStringOrNull(TeamColumns.CREASTURL);
        if (res == null)
            throw new NullPointerException("The value of 'creasturl' in the database was null, which is not allowed according to the model definition");
        return res;
    }
}

package barqsoft.footballscores.provider.team;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import barqsoft.footballscores.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code team} table.
 */
public class TeamContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return TeamColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable TeamSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable TeamSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public TeamContentValues putName(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("name must not be null");
        mContentValues.put(TeamColumns.NAME, value);
        return this;
    }


    public TeamContentValues putCode(@Nullable String value) {
        mContentValues.put(TeamColumns.CODE, value);
        return this;
    }

    public TeamContentValues putCodeNull() {
        mContentValues.putNull(TeamColumns.CODE);
        return this;
    }

    public TeamContentValues putShortname(@Nullable String value) {
        mContentValues.put(TeamColumns.SHORTNAME, value);
        return this;
    }

    public TeamContentValues putShortnameNull() {
        mContentValues.putNull(TeamColumns.SHORTNAME);
        return this;
    }

    public TeamContentValues putCreasturl(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("creasturl must not be null");
        mContentValues.put(TeamColumns.CREASTURL, value);
        return this;
    }

}

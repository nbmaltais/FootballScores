package barqsoft.footballscores.provider.soccerseason;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import barqsoft.footballscores.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code soccerseason} table.
 */
public class SoccerseasonContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return SoccerseasonColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable SoccerseasonSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable SoccerseasonSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public SoccerseasonContentValues putCaption(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("caption must not be null");
        mContentValues.put(SoccerseasonColumns.CAPTION, value);
        return this;
    }


    public SoccerseasonContentValues putLeague(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("league must not be null");
        mContentValues.put(SoccerseasonColumns.LEAGUE, value);
        return this;
    }


    public SoccerseasonContentValues putLastupdated(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("lastupdated must not be null");
        mContentValues.put(SoccerseasonColumns.LASTUPDATED, value);
        return this;
    }


    public SoccerseasonContentValues putYear(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("year must not be null");
        mContentValues.put(SoccerseasonColumns.YEAR, value);
        return this;
    }

}

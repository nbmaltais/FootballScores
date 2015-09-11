package barqsoft.footballscores.provider.soccerseason;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import barqsoft.footballscores.provider.base.AbstractSelection;

/**
 * Selection for the {@code soccerseason} table.
 */
public class SoccerseasonSelection extends AbstractSelection<SoccerseasonSelection> {
    @Override
    protected Uri baseUri() {
        return SoccerseasonColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code SoccerseasonCursor} object, which is positioned before the first entry, or null.
     */
    public SoccerseasonCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new SoccerseasonCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public SoccerseasonCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code SoccerseasonCursor} object, which is positioned before the first entry, or null.
     */
    public SoccerseasonCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new SoccerseasonCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public SoccerseasonCursor query(Context context) {
        return query(context, null);
    }


    public SoccerseasonSelection id(long... value) {
        addEquals("soccerseason." + SoccerseasonColumns._ID, toObjectArray(value));
        return this;
    }

    public SoccerseasonSelection idNot(long... value) {
        addNotEquals("soccerseason." + SoccerseasonColumns._ID, toObjectArray(value));
        return this;
    }

    public SoccerseasonSelection orderById(boolean desc) {
        orderBy("soccerseason." + SoccerseasonColumns._ID, desc);
        return this;
    }

    public SoccerseasonSelection orderById() {
        return orderById(false);
    }

    public SoccerseasonSelection caption(String... value) {
        addEquals(SoccerseasonColumns.CAPTION, value);
        return this;
    }

    public SoccerseasonSelection captionNot(String... value) {
        addNotEquals(SoccerseasonColumns.CAPTION, value);
        return this;
    }

    public SoccerseasonSelection captionLike(String... value) {
        addLike(SoccerseasonColumns.CAPTION, value);
        return this;
    }

    public SoccerseasonSelection captionContains(String... value) {
        addContains(SoccerseasonColumns.CAPTION, value);
        return this;
    }

    public SoccerseasonSelection captionStartsWith(String... value) {
        addStartsWith(SoccerseasonColumns.CAPTION, value);
        return this;
    }

    public SoccerseasonSelection captionEndsWith(String... value) {
        addEndsWith(SoccerseasonColumns.CAPTION, value);
        return this;
    }

    public SoccerseasonSelection orderByCaption(boolean desc) {
        orderBy(SoccerseasonColumns.CAPTION, desc);
        return this;
    }

    public SoccerseasonSelection orderByCaption() {
        orderBy(SoccerseasonColumns.CAPTION, false);
        return this;
    }

    public SoccerseasonSelection league(String... value) {
        addEquals(SoccerseasonColumns.LEAGUE, value);
        return this;
    }

    public SoccerseasonSelection leagueNot(String... value) {
        addNotEquals(SoccerseasonColumns.LEAGUE, value);
        return this;
    }

    public SoccerseasonSelection leagueLike(String... value) {
        addLike(SoccerseasonColumns.LEAGUE, value);
        return this;
    }

    public SoccerseasonSelection leagueContains(String... value) {
        addContains(SoccerseasonColumns.LEAGUE, value);
        return this;
    }

    public SoccerseasonSelection leagueStartsWith(String... value) {
        addStartsWith(SoccerseasonColumns.LEAGUE, value);
        return this;
    }

    public SoccerseasonSelection leagueEndsWith(String... value) {
        addEndsWith(SoccerseasonColumns.LEAGUE, value);
        return this;
    }

    public SoccerseasonSelection orderByLeague(boolean desc) {
        orderBy(SoccerseasonColumns.LEAGUE, desc);
        return this;
    }

    public SoccerseasonSelection orderByLeague() {
        orderBy(SoccerseasonColumns.LEAGUE, false);
        return this;
    }

    public SoccerseasonSelection lastupdated(String... value) {
        addEquals(SoccerseasonColumns.LASTUPDATED, value);
        return this;
    }

    public SoccerseasonSelection lastupdatedNot(String... value) {
        addNotEquals(SoccerseasonColumns.LASTUPDATED, value);
        return this;
    }

    public SoccerseasonSelection lastupdatedLike(String... value) {
        addLike(SoccerseasonColumns.LASTUPDATED, value);
        return this;
    }

    public SoccerseasonSelection lastupdatedContains(String... value) {
        addContains(SoccerseasonColumns.LASTUPDATED, value);
        return this;
    }

    public SoccerseasonSelection lastupdatedStartsWith(String... value) {
        addStartsWith(SoccerseasonColumns.LASTUPDATED, value);
        return this;
    }

    public SoccerseasonSelection lastupdatedEndsWith(String... value) {
        addEndsWith(SoccerseasonColumns.LASTUPDATED, value);
        return this;
    }

    public SoccerseasonSelection orderByLastupdated(boolean desc) {
        orderBy(SoccerseasonColumns.LASTUPDATED, desc);
        return this;
    }

    public SoccerseasonSelection orderByLastupdated() {
        orderBy(SoccerseasonColumns.LASTUPDATED, false);
        return this;
    }

    public SoccerseasonSelection year(String... value) {
        addEquals(SoccerseasonColumns.YEAR, value);
        return this;
    }

    public SoccerseasonSelection yearNot(String... value) {
        addNotEquals(SoccerseasonColumns.YEAR, value);
        return this;
    }

    public SoccerseasonSelection yearLike(String... value) {
        addLike(SoccerseasonColumns.YEAR, value);
        return this;
    }

    public SoccerseasonSelection yearContains(String... value) {
        addContains(SoccerseasonColumns.YEAR, value);
        return this;
    }

    public SoccerseasonSelection yearStartsWith(String... value) {
        addStartsWith(SoccerseasonColumns.YEAR, value);
        return this;
    }

    public SoccerseasonSelection yearEndsWith(String... value) {
        addEndsWith(SoccerseasonColumns.YEAR, value);
        return this;
    }

    public SoccerseasonSelection orderByYear(boolean desc) {
        orderBy(SoccerseasonColumns.YEAR, desc);
        return this;
    }

    public SoccerseasonSelection orderByYear() {
        orderBy(SoccerseasonColumns.YEAR, false);
        return this;
    }
}

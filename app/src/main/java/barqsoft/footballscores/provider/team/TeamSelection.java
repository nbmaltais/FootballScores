package barqsoft.footballscores.provider.team;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import barqsoft.footballscores.provider.base.AbstractSelection;

/**
 * Selection for the {@code team} table.
 */
public class TeamSelection extends AbstractSelection<TeamSelection> {
    @Override
    protected Uri baseUri() {
        return TeamColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code TeamCursor} object, which is positioned before the first entry, or null.
     */
    public TeamCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new TeamCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public TeamCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code TeamCursor} object, which is positioned before the first entry, or null.
     */
    public TeamCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new TeamCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public TeamCursor query(Context context) {
        return query(context, null);
    }


    public TeamSelection id(long... value) {
        addEquals("team." + TeamColumns._ID, toObjectArray(value));
        return this;
    }

    public TeamSelection idNot(long... value) {
        addNotEquals("team." + TeamColumns._ID, toObjectArray(value));
        return this;
    }

    public TeamSelection orderById(boolean desc) {
        orderBy("team." + TeamColumns._ID, desc);
        return this;
    }

    public TeamSelection orderById() {
        return orderById(false);
    }

    public TeamSelection name(String... value) {
        addEquals(TeamColumns.NAME, value);
        return this;
    }

    public TeamSelection nameNot(String... value) {
        addNotEquals(TeamColumns.NAME, value);
        return this;
    }

    public TeamSelection nameLike(String... value) {
        addLike(TeamColumns.NAME, value);
        return this;
    }

    public TeamSelection nameContains(String... value) {
        addContains(TeamColumns.NAME, value);
        return this;
    }

    public TeamSelection nameStartsWith(String... value) {
        addStartsWith(TeamColumns.NAME, value);
        return this;
    }

    public TeamSelection nameEndsWith(String... value) {
        addEndsWith(TeamColumns.NAME, value);
        return this;
    }

    public TeamSelection orderByName(boolean desc) {
        orderBy(TeamColumns.NAME, desc);
        return this;
    }

    public TeamSelection orderByName() {
        orderBy(TeamColumns.NAME, false);
        return this;
    }

    public TeamSelection code(String... value) {
        addEquals(TeamColumns.CODE, value);
        return this;
    }

    public TeamSelection codeNot(String... value) {
        addNotEquals(TeamColumns.CODE, value);
        return this;
    }

    public TeamSelection codeLike(String... value) {
        addLike(TeamColumns.CODE, value);
        return this;
    }

    public TeamSelection codeContains(String... value) {
        addContains(TeamColumns.CODE, value);
        return this;
    }

    public TeamSelection codeStartsWith(String... value) {
        addStartsWith(TeamColumns.CODE, value);
        return this;
    }

    public TeamSelection codeEndsWith(String... value) {
        addEndsWith(TeamColumns.CODE, value);
        return this;
    }

    public TeamSelection orderByCode(boolean desc) {
        orderBy(TeamColumns.CODE, desc);
        return this;
    }

    public TeamSelection orderByCode() {
        orderBy(TeamColumns.CODE, false);
        return this;
    }

    public TeamSelection shortname(String... value) {
        addEquals(TeamColumns.SHORTNAME, value);
        return this;
    }

    public TeamSelection shortnameNot(String... value) {
        addNotEquals(TeamColumns.SHORTNAME, value);
        return this;
    }

    public TeamSelection shortnameLike(String... value) {
        addLike(TeamColumns.SHORTNAME, value);
        return this;
    }

    public TeamSelection shortnameContains(String... value) {
        addContains(TeamColumns.SHORTNAME, value);
        return this;
    }

    public TeamSelection shortnameStartsWith(String... value) {
        addStartsWith(TeamColumns.SHORTNAME, value);
        return this;
    }

    public TeamSelection shortnameEndsWith(String... value) {
        addEndsWith(TeamColumns.SHORTNAME, value);
        return this;
    }

    public TeamSelection orderByShortname(boolean desc) {
        orderBy(TeamColumns.SHORTNAME, desc);
        return this;
    }

    public TeamSelection orderByShortname() {
        orderBy(TeamColumns.SHORTNAME, false);
        return this;
    }

    public TeamSelection creasturl(String... value) {
        addEquals(TeamColumns.CREASTURL, value);
        return this;
    }

    public TeamSelection creasturlNot(String... value) {
        addNotEquals(TeamColumns.CREASTURL, value);
        return this;
    }

    public TeamSelection creasturlLike(String... value) {
        addLike(TeamColumns.CREASTURL, value);
        return this;
    }

    public TeamSelection creasturlContains(String... value) {
        addContains(TeamColumns.CREASTURL, value);
        return this;
    }

    public TeamSelection creasturlStartsWith(String... value) {
        addStartsWith(TeamColumns.CREASTURL, value);
        return this;
    }

    public TeamSelection creasturlEndsWith(String... value) {
        addEndsWith(TeamColumns.CREASTURL, value);
        return this;
    }

    public TeamSelection orderByCreasturl(boolean desc) {
        orderBy(TeamColumns.CREASTURL, desc);
        return this;
    }

    public TeamSelection orderByCreasturl() {
        orderBy(TeamColumns.CREASTURL, false);
        return this;
    }
}

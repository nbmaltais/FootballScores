package barqsoft.footballscores.provider.fixture;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import barqsoft.footballscores.provider.base.AbstractSelection;
import barqsoft.footballscores.provider.soccerseason.*;

/**
 * Selection for the {@code fixture} table.
 */
public class FixtureSelection extends AbstractSelection<FixtureSelection> {
    @Override
    protected Uri baseUri() {
        return FixtureColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code FixtureCursor} object, which is positioned before the first entry, or null.
     */
    public FixtureCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new FixtureCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public FixtureCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code FixtureCursor} object, which is positioned before the first entry, or null.
     */
    public FixtureCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new FixtureCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public FixtureCursor query(Context context) {
        return query(context, null);
    }


    public FixtureSelection id(long... value) {
        addEquals("fixture." + FixtureColumns._ID, toObjectArray(value));
        return this;
    }

    public FixtureSelection idNot(long... value) {
        addNotEquals("fixture." + FixtureColumns._ID, toObjectArray(value));
        return this;
    }

    public FixtureSelection orderById(boolean desc) {
        orderBy("fixture." + FixtureColumns._ID, desc);
        return this;
    }

    public FixtureSelection orderById() {
        return orderById(false);
    }

    public FixtureSelection seasonId(long... value) {
        addEquals(FixtureColumns.SEASON_ID, toObjectArray(value));
        return this;
    }

    public FixtureSelection seasonIdNot(long... value) {
        addNotEquals(FixtureColumns.SEASON_ID, toObjectArray(value));
        return this;
    }

    public FixtureSelection seasonIdGt(long value) {
        addGreaterThan(FixtureColumns.SEASON_ID, value);
        return this;
    }

    public FixtureSelection seasonIdGtEq(long value) {
        addGreaterThanOrEquals(FixtureColumns.SEASON_ID, value);
        return this;
    }

    public FixtureSelection seasonIdLt(long value) {
        addLessThan(FixtureColumns.SEASON_ID, value);
        return this;
    }

    public FixtureSelection seasonIdLtEq(long value) {
        addLessThanOrEquals(FixtureColumns.SEASON_ID, value);
        return this;
    }

    public FixtureSelection orderBySeasonId(boolean desc) {
        orderBy(FixtureColumns.SEASON_ID, desc);
        return this;
    }

    public FixtureSelection orderBySeasonId() {
        orderBy(FixtureColumns.SEASON_ID, false);
        return this;
    }

    public FixtureSelection soccerseasonCaption(String... value) {
        addEquals(SoccerseasonColumns.CAPTION, value);
        return this;
    }

    public FixtureSelection soccerseasonCaptionNot(String... value) {
        addNotEquals(SoccerseasonColumns.CAPTION, value);
        return this;
    }

    public FixtureSelection soccerseasonCaptionLike(String... value) {
        addLike(SoccerseasonColumns.CAPTION, value);
        return this;
    }

    public FixtureSelection soccerseasonCaptionContains(String... value) {
        addContains(SoccerseasonColumns.CAPTION, value);
        return this;
    }

    public FixtureSelection soccerseasonCaptionStartsWith(String... value) {
        addStartsWith(SoccerseasonColumns.CAPTION, value);
        return this;
    }

    public FixtureSelection soccerseasonCaptionEndsWith(String... value) {
        addEndsWith(SoccerseasonColumns.CAPTION, value);
        return this;
    }

    public FixtureSelection orderBySoccerseasonCaption(boolean desc) {
        orderBy(SoccerseasonColumns.CAPTION, desc);
        return this;
    }

    public FixtureSelection orderBySoccerseasonCaption() {
        orderBy(SoccerseasonColumns.CAPTION, false);
        return this;
    }

    public FixtureSelection soccerseasonLeague(String... value) {
        addEquals(SoccerseasonColumns.LEAGUE, value);
        return this;
    }

    public FixtureSelection soccerseasonLeagueNot(String... value) {
        addNotEquals(SoccerseasonColumns.LEAGUE, value);
        return this;
    }

    public FixtureSelection soccerseasonLeagueLike(String... value) {
        addLike(SoccerseasonColumns.LEAGUE, value);
        return this;
    }

    public FixtureSelection soccerseasonLeagueContains(String... value) {
        addContains(SoccerseasonColumns.LEAGUE, value);
        return this;
    }

    public FixtureSelection soccerseasonLeagueStartsWith(String... value) {
        addStartsWith(SoccerseasonColumns.LEAGUE, value);
        return this;
    }

    public FixtureSelection soccerseasonLeagueEndsWith(String... value) {
        addEndsWith(SoccerseasonColumns.LEAGUE, value);
        return this;
    }

    public FixtureSelection orderBySoccerseasonLeague(boolean desc) {
        orderBy(SoccerseasonColumns.LEAGUE, desc);
        return this;
    }

    public FixtureSelection orderBySoccerseasonLeague() {
        orderBy(SoccerseasonColumns.LEAGUE, false);
        return this;
    }

    public FixtureSelection soccerseasonLastupdated(String... value) {
        addEquals(SoccerseasonColumns.LASTUPDATED, value);
        return this;
    }

    public FixtureSelection soccerseasonLastupdatedNot(String... value) {
        addNotEquals(SoccerseasonColumns.LASTUPDATED, value);
        return this;
    }

    public FixtureSelection soccerseasonLastupdatedLike(String... value) {
        addLike(SoccerseasonColumns.LASTUPDATED, value);
        return this;
    }

    public FixtureSelection soccerseasonLastupdatedContains(String... value) {
        addContains(SoccerseasonColumns.LASTUPDATED, value);
        return this;
    }

    public FixtureSelection soccerseasonLastupdatedStartsWith(String... value) {
        addStartsWith(SoccerseasonColumns.LASTUPDATED, value);
        return this;
    }

    public FixtureSelection soccerseasonLastupdatedEndsWith(String... value) {
        addEndsWith(SoccerseasonColumns.LASTUPDATED, value);
        return this;
    }

    public FixtureSelection orderBySoccerseasonLastupdated(boolean desc) {
        orderBy(SoccerseasonColumns.LASTUPDATED, desc);
        return this;
    }

    public FixtureSelection orderBySoccerseasonLastupdated() {
        orderBy(SoccerseasonColumns.LASTUPDATED, false);
        return this;
    }

    public FixtureSelection soccerseasonYear(String... value) {
        addEquals(SoccerseasonColumns.YEAR, value);
        return this;
    }

    public FixtureSelection soccerseasonYearNot(String... value) {
        addNotEquals(SoccerseasonColumns.YEAR, value);
        return this;
    }

    public FixtureSelection soccerseasonYearLike(String... value) {
        addLike(SoccerseasonColumns.YEAR, value);
        return this;
    }

    public FixtureSelection soccerseasonYearContains(String... value) {
        addContains(SoccerseasonColumns.YEAR, value);
        return this;
    }

    public FixtureSelection soccerseasonYearStartsWith(String... value) {
        addStartsWith(SoccerseasonColumns.YEAR, value);
        return this;
    }

    public FixtureSelection soccerseasonYearEndsWith(String... value) {
        addEndsWith(SoccerseasonColumns.YEAR, value);
        return this;
    }

    public FixtureSelection orderBySoccerseasonYear(boolean desc) {
        orderBy(SoccerseasonColumns.YEAR, desc);
        return this;
    }

    public FixtureSelection orderBySoccerseasonYear() {
        orderBy(SoccerseasonColumns.YEAR, false);
        return this;
    }

    public FixtureSelection date(String... value) {
        addEquals(FixtureColumns.DATE, value);
        return this;
    }

    public FixtureSelection dateNot(String... value) {
        addNotEquals(FixtureColumns.DATE, value);
        return this;
    }

    public FixtureSelection dateLike(String... value) {
        addLike(FixtureColumns.DATE, value);
        return this;
    }

    public FixtureSelection dateContains(String... value) {
        addContains(FixtureColumns.DATE, value);
        return this;
    }

    public FixtureSelection dateStartsWith(String... value) {
        addStartsWith(FixtureColumns.DATE, value);
        return this;
    }

    public FixtureSelection dateEndsWith(String... value) {
        addEndsWith(FixtureColumns.DATE, value);
        return this;
    }

    public FixtureSelection orderByDate(boolean desc) {
        orderBy(FixtureColumns.DATE, desc);
        return this;
    }

    public FixtureSelection orderByDate() {
        orderBy(FixtureColumns.DATE, false);
        return this;
    }

    public FixtureSelection time(String... value) {
        addEquals(FixtureColumns.TIME, value);
        return this;
    }

    public FixtureSelection timeNot(String... value) {
        addNotEquals(FixtureColumns.TIME, value);
        return this;
    }

    public FixtureSelection timeLike(String... value) {
        addLike(FixtureColumns.TIME, value);
        return this;
    }

    public FixtureSelection timeContains(String... value) {
        addContains(FixtureColumns.TIME, value);
        return this;
    }

    public FixtureSelection timeStartsWith(String... value) {
        addStartsWith(FixtureColumns.TIME, value);
        return this;
    }

    public FixtureSelection timeEndsWith(String... value) {
        addEndsWith(FixtureColumns.TIME, value);
        return this;
    }

    public FixtureSelection orderByTime(boolean desc) {
        orderBy(FixtureColumns.TIME, desc);
        return this;
    }

    public FixtureSelection orderByTime() {
        orderBy(FixtureColumns.TIME, false);
        return this;
    }

    public FixtureSelection status(String... value) {
        addEquals(FixtureColumns.STATUS, value);
        return this;
    }

    public FixtureSelection statusNot(String... value) {
        addNotEquals(FixtureColumns.STATUS, value);
        return this;
    }

    public FixtureSelection statusLike(String... value) {
        addLike(FixtureColumns.STATUS, value);
        return this;
    }

    public FixtureSelection statusContains(String... value) {
        addContains(FixtureColumns.STATUS, value);
        return this;
    }

    public FixtureSelection statusStartsWith(String... value) {
        addStartsWith(FixtureColumns.STATUS, value);
        return this;
    }

    public FixtureSelection statusEndsWith(String... value) {
        addEndsWith(FixtureColumns.STATUS, value);
        return this;
    }

    public FixtureSelection orderByStatus(boolean desc) {
        orderBy(FixtureColumns.STATUS, desc);
        return this;
    }

    public FixtureSelection orderByStatus() {
        orderBy(FixtureColumns.STATUS, false);
        return this;
    }

    public FixtureSelection matchday(int... value) {
        addEquals(FixtureColumns.MATCHDAY, toObjectArray(value));
        return this;
    }

    public FixtureSelection matchdayNot(int... value) {
        addNotEquals(FixtureColumns.MATCHDAY, toObjectArray(value));
        return this;
    }

    public FixtureSelection matchdayGt(int value) {
        addGreaterThan(FixtureColumns.MATCHDAY, value);
        return this;
    }

    public FixtureSelection matchdayGtEq(int value) {
        addGreaterThanOrEquals(FixtureColumns.MATCHDAY, value);
        return this;
    }

    public FixtureSelection matchdayLt(int value) {
        addLessThan(FixtureColumns.MATCHDAY, value);
        return this;
    }

    public FixtureSelection matchdayLtEq(int value) {
        addLessThanOrEquals(FixtureColumns.MATCHDAY, value);
        return this;
    }

    public FixtureSelection orderByMatchday(boolean desc) {
        orderBy(FixtureColumns.MATCHDAY, desc);
        return this;
    }

    public FixtureSelection orderByMatchday() {
        orderBy(FixtureColumns.MATCHDAY, false);
        return this;
    }

    public FixtureSelection goalshometeam(int... value) {
        addEquals(FixtureColumns.GOALSHOMETEAM, toObjectArray(value));
        return this;
    }

    public FixtureSelection goalshometeamNot(int... value) {
        addNotEquals(FixtureColumns.GOALSHOMETEAM, toObjectArray(value));
        return this;
    }

    public FixtureSelection goalshometeamGt(int value) {
        addGreaterThan(FixtureColumns.GOALSHOMETEAM, value);
        return this;
    }

    public FixtureSelection goalshometeamGtEq(int value) {
        addGreaterThanOrEquals(FixtureColumns.GOALSHOMETEAM, value);
        return this;
    }

    public FixtureSelection goalshometeamLt(int value) {
        addLessThan(FixtureColumns.GOALSHOMETEAM, value);
        return this;
    }

    public FixtureSelection goalshometeamLtEq(int value) {
        addLessThanOrEquals(FixtureColumns.GOALSHOMETEAM, value);
        return this;
    }

    public FixtureSelection orderByGoalshometeam(boolean desc) {
        orderBy(FixtureColumns.GOALSHOMETEAM, desc);
        return this;
    }

    public FixtureSelection orderByGoalshometeam() {
        orderBy(FixtureColumns.GOALSHOMETEAM, false);
        return this;
    }

    public FixtureSelection goalsawayteam(int... value) {
        addEquals(FixtureColumns.GOALSAWAYTEAM, toObjectArray(value));
        return this;
    }

    public FixtureSelection goalsawayteamNot(int... value) {
        addNotEquals(FixtureColumns.GOALSAWAYTEAM, toObjectArray(value));
        return this;
    }

    public FixtureSelection goalsawayteamGt(int value) {
        addGreaterThan(FixtureColumns.GOALSAWAYTEAM, value);
        return this;
    }

    public FixtureSelection goalsawayteamGtEq(int value) {
        addGreaterThanOrEquals(FixtureColumns.GOALSAWAYTEAM, value);
        return this;
    }

    public FixtureSelection goalsawayteamLt(int value) {
        addLessThan(FixtureColumns.GOALSAWAYTEAM, value);
        return this;
    }

    public FixtureSelection goalsawayteamLtEq(int value) {
        addLessThanOrEquals(FixtureColumns.GOALSAWAYTEAM, value);
        return this;
    }

    public FixtureSelection orderByGoalsawayteam(boolean desc) {
        orderBy(FixtureColumns.GOALSAWAYTEAM, desc);
        return this;
    }

    public FixtureSelection orderByGoalsawayteam() {
        orderBy(FixtureColumns.GOALSAWAYTEAM, false);
        return this;
    }

    public FixtureSelection hometeamname(String... value) {
        addEquals(FixtureColumns.HOMETEAMNAME, value);
        return this;
    }

    public FixtureSelection hometeamnameNot(String... value) {
        addNotEquals(FixtureColumns.HOMETEAMNAME, value);
        return this;
    }

    public FixtureSelection hometeamnameLike(String... value) {
        addLike(FixtureColumns.HOMETEAMNAME, value);
        return this;
    }

    public FixtureSelection hometeamnameContains(String... value) {
        addContains(FixtureColumns.HOMETEAMNAME, value);
        return this;
    }

    public FixtureSelection hometeamnameStartsWith(String... value) {
        addStartsWith(FixtureColumns.HOMETEAMNAME, value);
        return this;
    }

    public FixtureSelection hometeamnameEndsWith(String... value) {
        addEndsWith(FixtureColumns.HOMETEAMNAME, value);
        return this;
    }

    public FixtureSelection orderByHometeamname(boolean desc) {
        orderBy(FixtureColumns.HOMETEAMNAME, desc);
        return this;
    }

    public FixtureSelection orderByHometeamname() {
        orderBy(FixtureColumns.HOMETEAMNAME, false);
        return this;
    }

    public FixtureSelection awayteamname(String... value) {
        addEquals(FixtureColumns.AWAYTEAMNAME, value);
        return this;
    }

    public FixtureSelection awayteamnameNot(String... value) {
        addNotEquals(FixtureColumns.AWAYTEAMNAME, value);
        return this;
    }

    public FixtureSelection awayteamnameLike(String... value) {
        addLike(FixtureColumns.AWAYTEAMNAME, value);
        return this;
    }

    public FixtureSelection awayteamnameContains(String... value) {
        addContains(FixtureColumns.AWAYTEAMNAME, value);
        return this;
    }

    public FixtureSelection awayteamnameStartsWith(String... value) {
        addStartsWith(FixtureColumns.AWAYTEAMNAME, value);
        return this;
    }

    public FixtureSelection awayteamnameEndsWith(String... value) {
        addEndsWith(FixtureColumns.AWAYTEAMNAME, value);
        return this;
    }

    public FixtureSelection orderByAwayteamname(boolean desc) {
        orderBy(FixtureColumns.AWAYTEAMNAME, desc);
        return this;
    }

    public FixtureSelection orderByAwayteamname() {
        orderBy(FixtureColumns.AWAYTEAMNAME, false);
        return this;
    }

    public FixtureSelection hometeamcresturl(String... value) {
        addEquals(FixtureColumns.HOMETEAMCRESTURL, value);
        return this;
    }

    public FixtureSelection hometeamcresturlNot(String... value) {
        addNotEquals(FixtureColumns.HOMETEAMCRESTURL, value);
        return this;
    }

    public FixtureSelection hometeamcresturlLike(String... value) {
        addLike(FixtureColumns.HOMETEAMCRESTURL, value);
        return this;
    }

    public FixtureSelection hometeamcresturlContains(String... value) {
        addContains(FixtureColumns.HOMETEAMCRESTURL, value);
        return this;
    }

    public FixtureSelection hometeamcresturlStartsWith(String... value) {
        addStartsWith(FixtureColumns.HOMETEAMCRESTURL, value);
        return this;
    }

    public FixtureSelection hometeamcresturlEndsWith(String... value) {
        addEndsWith(FixtureColumns.HOMETEAMCRESTURL, value);
        return this;
    }

    public FixtureSelection orderByHometeamcresturl(boolean desc) {
        orderBy(FixtureColumns.HOMETEAMCRESTURL, desc);
        return this;
    }

    public FixtureSelection orderByHometeamcresturl() {
        orderBy(FixtureColumns.HOMETEAMCRESTURL, false);
        return this;
    }

    public FixtureSelection awayteamcresturl(String... value) {
        addEquals(FixtureColumns.AWAYTEAMCRESTURL, value);
        return this;
    }

    public FixtureSelection awayteamcresturlNot(String... value) {
        addNotEquals(FixtureColumns.AWAYTEAMCRESTURL, value);
        return this;
    }

    public FixtureSelection awayteamcresturlLike(String... value) {
        addLike(FixtureColumns.AWAYTEAMCRESTURL, value);
        return this;
    }

    public FixtureSelection awayteamcresturlContains(String... value) {
        addContains(FixtureColumns.AWAYTEAMCRESTURL, value);
        return this;
    }

    public FixtureSelection awayteamcresturlStartsWith(String... value) {
        addStartsWith(FixtureColumns.AWAYTEAMCRESTURL, value);
        return this;
    }

    public FixtureSelection awayteamcresturlEndsWith(String... value) {
        addEndsWith(FixtureColumns.AWAYTEAMCRESTURL, value);
        return this;
    }

    public FixtureSelection orderByAwayteamcresturl(boolean desc) {
        orderBy(FixtureColumns.AWAYTEAMCRESTURL, desc);
        return this;
    }

    public FixtureSelection orderByAwayteamcresturl() {
        orderBy(FixtureColumns.AWAYTEAMCRESTURL, false);
        return this;
    }
}

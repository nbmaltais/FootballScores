package barqsoft.footballscores.provider.fixture;

import android.net.Uri;
import android.provider.BaseColumns;

import barqsoft.footballscores.provider.FootballScoresProvider;
import barqsoft.footballscores.provider.fixture.FixtureColumns;
import barqsoft.footballscores.provider.soccerseason.SoccerseasonColumns;
import barqsoft.footballscores.provider.team.TeamColumns;

/**
 * Team in soccer season
 */
public class FixtureColumns implements BaseColumns {
    public static final String TABLE_NAME = "fixture";
    public static final Uri CONTENT_URI = Uri.parse(FootballScoresProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String SEASON_ID = "season_id";

    public static final String DATE = "date";

    public static final String TIME = "time";

    public static final String STATUS = "status";

    public static final String MATCHDAY = "matchDay";

    public static final String GOALSHOMETEAM = "goalsHomeTeam";

    public static final String GOALSAWAYTEAM = "goalsAwayTeam";

    public static final String HOMETEAMNAME = "homeTeamName";

    public static final String AWAYTEAMNAME = "awayTeamName";

    public static final String HOMETEAMCRESTURL = "homeTeamCrestUrl";

    public static final String AWAYTEAMCRESTURL = "awayTeamCrestUrl";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            SEASON_ID,
            DATE,
            TIME,
            STATUS,
            MATCHDAY,
            GOALSHOMETEAM,
            GOALSAWAYTEAM,
            HOMETEAMNAME,
            AWAYTEAMNAME,
            HOMETEAMCRESTURL,
            AWAYTEAMCRESTURL
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(SEASON_ID) || c.contains("." + SEASON_ID)) return true;
            if (c.equals(DATE) || c.contains("." + DATE)) return true;
            if (c.equals(TIME) || c.contains("." + TIME)) return true;
            if (c.equals(STATUS) || c.contains("." + STATUS)) return true;
            if (c.equals(MATCHDAY) || c.contains("." + MATCHDAY)) return true;
            if (c.equals(GOALSHOMETEAM) || c.contains("." + GOALSHOMETEAM)) return true;
            if (c.equals(GOALSAWAYTEAM) || c.contains("." + GOALSAWAYTEAM)) return true;
            if (c.equals(HOMETEAMNAME) || c.contains("." + HOMETEAMNAME)) return true;
            if (c.equals(AWAYTEAMNAME) || c.contains("." + AWAYTEAMNAME)) return true;
            if (c.equals(HOMETEAMCRESTURL) || c.contains("." + HOMETEAMCRESTURL)) return true;
            if (c.equals(AWAYTEAMCRESTURL) || c.contains("." + AWAYTEAMCRESTURL)) return true;
        }
        return false;
    }

    public static final String PREFIX_SOCCERSEASON = TABLE_NAME + "__" + SoccerseasonColumns.TABLE_NAME;
}

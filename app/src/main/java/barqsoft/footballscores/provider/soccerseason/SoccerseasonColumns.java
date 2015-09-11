package barqsoft.footballscores.provider.soccerseason;

import android.net.Uri;
import android.provider.BaseColumns;

import barqsoft.footballscores.provider.FootballScoresProvider;
import barqsoft.footballscores.provider.fixture.FixtureColumns;
import barqsoft.footballscores.provider.soccerseason.SoccerseasonColumns;
import barqsoft.footballscores.provider.team.TeamColumns;

/**
 * Soccer seasons
 */
public class SoccerseasonColumns implements BaseColumns {
    public static final String TABLE_NAME = "soccerseason";
    public static final Uri CONTENT_URI = Uri.parse(FootballScoresProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String CAPTION = "caption";

    public static final String LEAGUE = "league";

    public static final String LASTUPDATED = "lastUpdated";

    public static final String YEAR = "year";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            CAPTION,
            LEAGUE,
            LASTUPDATED,
            YEAR
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(CAPTION) || c.contains("." + CAPTION)) return true;
            if (c.equals(LEAGUE) || c.contains("." + LEAGUE)) return true;
            if (c.equals(LASTUPDATED) || c.contains("." + LASTUPDATED)) return true;
            if (c.equals(YEAR) || c.contains("." + YEAR)) return true;
        }
        return false;
    }

}

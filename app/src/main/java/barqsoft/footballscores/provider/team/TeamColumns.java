package barqsoft.footballscores.provider.team;

import android.net.Uri;
import android.provider.BaseColumns;

import barqsoft.footballscores.provider.FootballScoresProvider;
import barqsoft.footballscores.provider.fixture.FixtureColumns;
import barqsoft.footballscores.provider.soccerseason.SoccerseasonColumns;
import barqsoft.footballscores.provider.team.TeamColumns;

/**
 * Team in soccer season
 */
public class TeamColumns implements BaseColumns {
    public static final String TABLE_NAME = "team";
    public static final Uri CONTENT_URI = Uri.parse(FootballScoresProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String NAME = "name";

    public static final String CODE = "code";

    public static final String SHORTNAME = "shortName";

    public static final String CREASTURL = "creastUrl";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            NAME,
            CODE,
            SHORTNAME,
            CREASTURL
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(NAME) || c.contains("." + NAME)) return true;
            if (c.equals(CODE) || c.contains("." + CODE)) return true;
            if (c.equals(SHORTNAME) || c.contains("." + SHORTNAME)) return true;
            if (c.equals(CREASTURL) || c.contains("." + CREASTURL)) return true;
        }
        return false;
    }

}

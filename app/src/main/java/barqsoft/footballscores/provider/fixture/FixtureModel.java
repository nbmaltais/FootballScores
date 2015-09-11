package barqsoft.footballscores.provider.fixture;

import barqsoft.footballscores.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Team in soccer season
 */
public interface FixtureModel extends BaseModel {

    /**
     * Get the {@code season_id} value.
     */
    long getSeasonId();

    /**
     * Get the {@code date} value.
     * Cannot be {@code null}.
     */
    @NonNull
    String getDate();

    /**
     * Get the {@code time} value.
     * Cannot be {@code null}.
     */
    @NonNull
    String getTime();

    /**
     * Get the {@code status} value.
     * Cannot be {@code null}.
     */
    @NonNull
    String getStatus();

    /**
     * Get the {@code matchday} value.
     */
    int getMatchday();

    /**
     * Get the {@code goalshometeam} value.
     */
    int getGoalshometeam();

    /**
     * Get the {@code goalsawayteam} value.
     */
    int getGoalsawayteam();

    /**
     * Get the {@code hometeamname} value.
     * Cannot be {@code null}.
     */
    @NonNull
    String getHometeamname();

    /**
     * Get the {@code awayteamname} value.
     * Cannot be {@code null}.
     */
    @NonNull
    String getAwayteamname();

    /**
     * Get the {@code hometeamcresturl} value.
     * Can be {@code null}.
     */
    @Nullable
    String getHometeamcresturl();

    /**
     * Get the {@code awayteamcresturl} value.
     * Can be {@code null}.
     */
    @Nullable
    String getAwayteamcresturl();
}

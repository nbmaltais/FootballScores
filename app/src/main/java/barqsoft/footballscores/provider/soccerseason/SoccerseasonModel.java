package barqsoft.footballscores.provider.soccerseason;

import barqsoft.footballscores.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Soccer seasons
 */
public interface SoccerseasonModel extends BaseModel {

    /**
     * Get the {@code caption} value.
     * Cannot be {@code null}.
     */
    @NonNull
    String getCaption();

    /**
     * Get the {@code league} value.
     * Cannot be {@code null}.
     */
    @NonNull
    String getLeague();

    /**
     * Get the {@code lastupdated} value.
     * Cannot be {@code null}.
     */
    @NonNull
    String getLastupdated();

    /**
     * Get the {@code year} value.
     * Cannot be {@code null}.
     */
    @NonNull
    String getYear();
}

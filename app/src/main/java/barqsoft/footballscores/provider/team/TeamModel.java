package barqsoft.footballscores.provider.team;

import barqsoft.footballscores.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Team in soccer season
 */
public interface TeamModel extends BaseModel {

    /**
     * Get the {@code name} value.
     * Cannot be {@code null}.
     */
    @NonNull
    String getName();

    /**
     * Get the {@code code} value.
     * Can be {@code null}.
     */
    @Nullable
    String getCode();

    /**
     * Get the {@code shortname} value.
     * Can be {@code null}.
     */
    @Nullable
    String getShortname();

    /**
     * Get the {@code creasturl} value.
     * Cannot be {@code null}.
     */
    @NonNull
    String getCreasturl();
}

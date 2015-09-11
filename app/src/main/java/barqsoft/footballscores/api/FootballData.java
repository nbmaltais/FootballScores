package barqsoft.footballscores.api;

import java.util.List;

import barqsoft.footballscores.api.data.fixtures.Fixtures;
import barqsoft.footballscores.api.data.soccerseasons.SoccerSeason;
import barqsoft.footballscores.api.data.teams.Teams;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by Nicolas on 2015-08-24.
 */
public interface FootballData
{
    @GET("/alpha/fixtures")
    Fixtures getFixtures(@Query("timeFrame") String timeFrame);

    @GET("/alpha/soccerseasons")
    List<SoccerSeason> getSoccerSeasons();

    @GET("/alpha/soccerseasons/{id}/teams")
    Teams getSoccerSeasonsTeams(@Path("id") long id);
}

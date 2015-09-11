package barqsoft.footballscores.api.data.fixtures;

//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

import barqsoft.footballscores.api.data.Link;

//@Generated("org.jsonschema2pojo")
public class Links {

    @Expose
    private Link self;
    @Expose
    private Link soccerseason;
    @Expose
    private Link homeTeam;
    @Expose
    private Link awayTeam;

    /**
     *
     * @return
     * The self
     */
    public Link getSelf() {
        return self;
    }

    /**
     *
     * @param self
     * The self
     */
    public void setSelf(Link self) {
        this.self = self;
    }

    /**
     *
     * @return
     * The soccerseason
     */
    public Link getSoccerseason() {
        return soccerseason;
    }

    /**
     *
     * @param soccerseason
     * The soccerseason
     */
    public void setSoccerseason(Link soccerseason) {
        this.soccerseason = soccerseason;
    }

    /**
     *
     * @return
     * The homeTeam
     */
    public Link getHomeTeam() {
        return homeTeam;
    }

    /**
     *
     * @param homeTeam
     * The homeTeam
     */
    public void setHomeTeam(Link homeTeam) {
        this.homeTeam = homeTeam;
    }

    /**
     *
     * @return
     * The awayTeam
     */
    public Link getAwayTeam() {
        return awayTeam;
    }

    /**
     *
     * @param awayTeam
     * The awayTeam
     */
    public void setAwayTeam(Link awayTeam) {
        this.awayTeam = awayTeam;
    }

}
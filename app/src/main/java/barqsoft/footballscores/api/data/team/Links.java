package barqsoft.footballscores.api.data.team;

import com.google.gson.annotations.Expose;

import barqsoft.footballscores.api.data.Link;

//import javax.annotation.Generated;

//@Generated("org.jsonschema2pojo")
public class Links {

    @Expose
    private Link self;
    @Expose
    private Link fixtures;
    @Expose
    private Link players;

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
     * The fixtures
     */
    public Link getFixtures() {
        return fixtures;
    }

    /**
     *
     * @param fixtures
     * The fixtures
     */
    public void setFixtures(Link fixtures) {
        this.fixtures = fixtures;
    }

    /**
     *
     * @return
     * The players
     */
    public Link getPlayers() {
        return players;
    }

    /**
     *
     * @param players
     * The players
     */
    public void setPlayers(Link players) {
        this.players = players;
    }

}
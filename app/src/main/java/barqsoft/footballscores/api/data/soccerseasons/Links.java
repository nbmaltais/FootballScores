package barqsoft.footballscores.api.data.soccerseasons;

import com.google.gson.annotations.Expose;

import barqsoft.footballscores.api.data.Link;

//import javax.annotation.Generated;

//@Generated("org.jsonschema2pojo")
public class Links {

    @Expose
    private Link self;
    @Expose
    private Link teams;
    @Expose
    private Link fixtures;
    @Expose
    private Link leagueTable;

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
     * The teams
     */
    public Link getTeams() {
        return teams;
    }

    /**
     *
     * @param teams
     * The teams
     */
    public void setTeams(Link teams) {
        this.teams = teams;
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
     * The leagueTable
     */
    public Link getLeagueTable() {
        return leagueTable;
    }

    /**
     *
     * @param leagueTable
     * The leagueTable
     */
    public void setLeagueTable(Link leagueTable) {
        this.leagueTable = leagueTable;
    }

}
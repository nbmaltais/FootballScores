package barqsoft.footballscores.api.data.teams;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import barqsoft.footballscores.api.data.team.Team;

//@Generated("org.jsonschema2pojo")
public class Teams {

    @SerializedName("_links")
    @Expose
    private List<TeamsLink> Links = new ArrayList<TeamsLink>();
    @Expose
    private Integer count;
    @Expose
    private List<Team> teams = new ArrayList<Team>();

    /**
     *
     * @return
     * The Links
     */
    public List<TeamsLink> getLinks() {
        return Links;
    }

    /**
     *
     * @param Links
     * The _links
     */
    public void setLinks(List<TeamsLink> Links) {
        this.Links = Links;
    }

    /**
     *
     * @return
     * The count
     */
    public Integer getCount() {
        return count;
    }

    /**
     *
     * @param count
     * The count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     *
     * @return
     * The teams
     */
    public List<Team> getTeams() {
        return teams;
    }

    /**
     *
     * @param teams
     * The teams
     */
    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

}
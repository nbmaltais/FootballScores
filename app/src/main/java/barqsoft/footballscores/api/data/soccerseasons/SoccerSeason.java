package barqsoft.footballscores.api.data.soccerseasons;
//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("org.jsonschema2pojo")
public class SoccerSeason
{

    @SerializedName("_links")
    @Expose
    private Links Links;
    @Expose
    private String caption;
    @Expose
    private String league;
    @Expose
    private String year;
    @Expose
    private Integer numberOfTeams;
    @Expose
    private Integer numberOfGames;
    @Expose
    private String lastUpdated;

    /**
     *
     * @return
     * The Links
     */
    public Links getLinks() {
        return Links;
    }

    /**
     *
     * @param l
     * The _links
     */
    public void setLinks(Links l) {
        this.Links = l;
    }

    /**
     *
     * @return
     * The caption
     */
    public String getCaption() {
        return caption;
    }

    /**
     *
     * @param caption
     * The caption
     */
    public void setCaption(String caption) {
        this.caption = caption;
    }

    /**
     *
     * @return
     * The league
     */
    public String getLeague() {
        return league;
    }

    /**
     *
     * @param league
     * The league
     */
    public void setLeague(String league) {
        this.league = league;
    }

    /**
     *
     * @return
     * The year
     */
    public String getYear() {
        return year;
    }

    /**
     *
     * @param year
     * The year
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     *
     * @return
     * The numberOfTeams
     */
    public Integer getNumberOfTeams() {
        return numberOfTeams;
    }

    /**
     *
     * @param numberOfTeams
     * The numberOfTeams
     */
    public void setNumberOfTeams(Integer numberOfTeams) {
        this.numberOfTeams = numberOfTeams;
    }

    /**
     *
     * @return
     * The numberOfGames
     */
    public Integer getNumberOfGames() {
        return numberOfGames;
    }

    /**
     *
     * @param numberOfGames
     * The numberOfGames
     */
    public void setNumberOfGames(Integer numberOfGames) {
        this.numberOfGames = numberOfGames;
    }

    /**
     *
     * @return
     * The lastUpdated
     */
    public String getLastUpdated() {
        return lastUpdated;
    }

    /**
     *
     * @param lastUpdated
     * The lastUpdated
     */
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

}
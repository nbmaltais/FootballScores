package barqsoft.footballscores.api.data.fixtures;

//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("org.jsonschema2pojo")
public class Fixture {

    @SerializedName("_links")
    @Expose
    private barqsoft.footballscores.api.data.fixtures.Links Links;
    @Expose
    private String date;
    @Expose
    private String status;
    @Expose
    private Integer matchday;
    @Expose
    private String homeTeamName;
    @Expose
    private String awayTeamName;
    @Expose
    private Result result;

    /**
     *
     * @return
     * The Links
     */
    public barqsoft.footballscores.api.data.fixtures.Links getLinks() {
        return Links;
    }

    /**
     *
     * @param Links
     * The _links
     */
    public void setLinks(barqsoft.footballscores.api.data.fixtures.Links Links) {
        this.Links = Links;
    }

    /**
     *
     * @return
     * The date
     */
    public String getDate() {
        return date;
    }

    /**
     *
     * @param date
     * The date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     *
     * @return
     * The status
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     * The matchday
     */
    public Integer getMatchday() {
        return matchday;
    }

    /**
     *
     * @param matchday
     * The matchday
     */
    public void setMatchday(Integer matchday) {
        this.matchday = matchday;
    }

    /**
     *
     * @return
     * The homeTeamName
     */
    public String getHomeTeamName() {
        return homeTeamName;
    }

    /**
     *
     * @param homeTeamName
     * The homeTeamName
     */
    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    /**
     *
     * @return
     * The awayTeamName
     */
    public String getAwayTeamName() {
        return awayTeamName;
    }

    /**
     *
     * @param awayTeamName
     * The awayTeamName
     */
    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }

    /**
     *
     * @return
     * The result
     */
    public Result getResult() {
        return result;
    }

    /**
     *
     * @param result
     * The result
     */
    public void setResult(Result result) {
        this.result = result;
    }

}
package barqsoft.footballscores.api.data.team;

//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("org.jsonschema2pojo")
public class Team {

    @SerializedName("_links")
    @Expose
    private barqsoft.footballscores.api.data.team.Links Links;
    @Expose
    private String name;
    @Expose
    private String code;
    @Expose
    private String shortName;
    @Expose
    private String squadMarketValue;
    @Expose
    private String crestUrl;

    /**
     *
     * @return
     * The Links
     */
    public barqsoft.footballscores.api.data.team.Links getLinks() {
        return Links;
    }

    /**
     *
     * @param Links
     * The _links
     */
    public void setLinks(barqsoft.footballscores.api.data.team.Links Links) {
        this.Links = Links;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The code
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @param code
     * The code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     *
     * @return
     * The shortName
     */
    public String getShortName() {
        return shortName;
    }

    /**
     *
     * @param shortName
     * The shortName
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /**
     *
     * @return
     * The squadMarketValue
     */
    public String getSquadMarketValue() {
        return squadMarketValue;
    }

    /**
     *
     * @param squadMarketValue
     * The squadMarketValue
     */
    public void setSquadMarketValue(String squadMarketValue) {
        this.squadMarketValue = squadMarketValue;
    }

    /**
     *
     * @return
     * The crestUrl
     */
    public String getCrestUrl() {
        return crestUrl;
    }

    /**
     *
     * @param crestUrl
     * The crestUrl
     */
    public void setCrestUrl(String crestUrl) {
        this.crestUrl = crestUrl;
    }

}
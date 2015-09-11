package barqsoft.footballscores.api.data.teams;

//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

//@Generated("org.jsonschema2pojo")
public class TeamsLink {

    @Expose
    private String self;
    @Expose
    private String soccerseason;

    /**
     *
     * @return
     * The self
     */
    public String getSelf() {
        return self;
    }

    /**
     *
     * @param self
     * The self
     */
    public void setSelf(String self) {
        this.self = self;
    }

    /**
     *
     * @return
     * The soccerseason
     */
    public String getSoccerseason() {
        return soccerseason;
    }

    /**
     *
     * @param soccerseason
     * The soccerseason
     */
    public void setSoccerseason(String soccerseason) {
        this.soccerseason = soccerseason;
    }

}
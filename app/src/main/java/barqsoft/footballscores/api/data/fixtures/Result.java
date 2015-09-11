package barqsoft.footballscores.api.data.fixtures;

import com.google.gson.annotations.Expose;

//@Generated("org.jsonschema2pojo")
public class Result {

    @Expose
    private Integer goalsHomeTeam;
    @Expose
    private Integer goalsAwayTeam;

    /**
     *
     * @return
     * The goalsHomeTeam
     */
    public Integer getGoalsHomeTeam() {
        return goalsHomeTeam;
    }

    /**
     *
     * @param goalsHomeTeam
     * The goalsHomeTeam
     */
    public void setGoalsHomeTeam(Integer goalsHomeTeam) {
        this.goalsHomeTeam = goalsHomeTeam;
    }

    /**
     *
     * @return
     * The goalsAwayTeam
     */
    public Integer getGoalsAwayTeam() {
        return goalsAwayTeam;
    }

    /**
     *
     * @param goalsAwayTeam
     * The goalsAwayTeam
     */
    public void setGoalsAwayTeam(Integer goalsAwayTeam) {
        this.goalsAwayTeam = goalsAwayTeam;
    }

}
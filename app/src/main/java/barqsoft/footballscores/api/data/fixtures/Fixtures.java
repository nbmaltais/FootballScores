package barqsoft.footballscores.api.data.fixtures;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

//import javax.annotation.Generated;

//@Generated("org.jsonschema2pojo")
public class Fixtures {

    @Expose
    private String timeFrameStart;
    @Expose
    private String timeFrameEnd;
    @Expose
    private Integer count;
    @Expose
    private List<Fixture> fixtures = new ArrayList<Fixture>();

    /**
     *
     * @return
     * The timeFrameStart
     */
    public String getTimeFrameStart() {
        return timeFrameStart;
    }

    /**
     *
     * @param timeFrameStart
     * The timeFrameStart
     */
    public void setTimeFrameStart(String timeFrameStart) {
        this.timeFrameStart = timeFrameStart;
    }

    /**
     *
     * @return
     * The timeFrameEnd
     */
    public String getTimeFrameEnd() {
        return timeFrameEnd;
    }

    /**
     *
     * @param timeFrameEnd
     * The timeFrameEnd
     */
    public void setTimeFrameEnd(String timeFrameEnd) {
        this.timeFrameEnd = timeFrameEnd;
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
     * The fixtures
     */
    public List<Fixture> getFixtures() {
        return fixtures;
    }

    /**
     *
     * @param fixtures
     * The fixtures
     */
    public void setFixtures(List<Fixture> fixtures) {
        this.fixtures = fixtures;
    }

}
/**
 * Author: Tanisha Payne
 * CRN: 20690
 * Program 4: Dispatch
 *
 */

public class Station {

    private final int MAX_REQUESTS_PER_DAY = 3;
    private String name;
    private int requests_on_day = 0;

    public Station(String name) {
        this.name = name;
    }

    public void resetStation() {
        requests_on_day = 0;
    }

    public void performRequest() {
        requests_on_day++;
    }

    public boolean isFullForToday() {
        return requests_on_day >= MAX_REQUESTS_PER_DAY;
    }

    //compares the station name in ArrayList
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Station)) return false;
        Station station = (Station) o;
        if (this.name.equals(station.name)) {
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }
}

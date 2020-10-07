/**
 * Author: Tanisha Payne
 * CRN: 20690
 * Program 4: Dispatch
 *
 */

import java.util.ArrayList;

public class Dispatch implements Comparable <Dispatch> {


    private Emergency emergency;
    private EmergencyPriority priority;
    private Station station;
    private String name;
    private int id;
    private String problem;
    private ArrayList<Station> stations;

    //Identifies all emergency requests
    public Dispatch(int id, String problem, ArrayList<Station> stations) {
        this.id = id;
        this.stations = stations;
        if (problem.contains("flat tire") || problem.contains("car broke")
                || problem.contains("car won't start") || problem.contains("car is stalled")
                || problem.contains("vehicle is dead") || problem.contains("vehicle is stuck")) {
            emergency = Emergency.VEHICLE;
            priority = EmergencyPriority.LOW;
        } else if (problem.contains("car accident")) {
            emergency = Emergency.VEHICLE;
            priority = EmergencyPriority.HIGH;
        } else if (problem.contains("power is out") || problem.contains("air conditioning stopped")
                || problem.contains("pipes are leaking") || problem.contains("broke a window")
                || problem.contains("roof is leaking") || problem.contains("door lock broke")) {
            emergency = Emergency.FACILITY;
            priority = EmergencyPriority.LOW;
        } else if (problem.contains("breathing") || problem.contains("seizure")) {
            emergency = Emergency.MEDICAL;
            priority = EmergencyPriority.HIGH;
        } else if (problem.contains("passed out") || problem.contains("high fever")
                || problem.contains("fell and broke something")
                || problem.contains("accident with a knife")) {
            emergency = Emergency.MEDICAL;
            priority = EmergencyPriority.MEDIUM;
        } else if (problem.contains("gigantic hole in the dome") || problem.contains("marsquake")
                || problem.contains("dome is falling down") || problem.contains("been struck by a meteorite")) {
            emergency = Emergency.ENVIRONMENT;
            priority = EmergencyPriority.HIGH;
        } else {
            System.out.println("Could not figure out ID for:" + problem);
        }

        determineLocation(problem);
    }


    private void determineLocation(String problem) {
        String station = null;
        if (problem.contains("Kansas") ) {
            station = "Kansas";
        } else if (problem.contains("Bon Jovi")) {
            station = "Bon Jovi";
        } else if(problem.contains("Journey")) {
            station = "Journey";
        } else if (problem.contains("Alabama")) {
            station = "Alabama";
        } else if (problem.contains("Boston")) {
            station = "Boston";
        } else if (problem.contains("Chicago")) {
            station = "Chicago";
        } else if (problem.contains("Survivor")) {
            station = "Survivor";
        } else {
            System.out.print("Does do not have the station included");
        }

        if (station != null && !stations.contains(new Station(station))) {
            this.station = new Station(station);
            stations.add(this.station);
        } else {
            int index = this.stations.indexOf(new Station(station));
            this.station = this.stations.get(index);
        }

    }

    //Sort according to Priority
    @Override
    public int compareTo(Dispatch o) {
        //Dispatch otherDispatch = (Dispatch) o;
        if (this.priority == o.priority) {
            if (this.id < o.id) {
                return -1;
            } else {
                return 1;
            }
        } else {
            if (this.priority == EmergencyPriority.HIGH) {
                return -1;
            } else if (this.priority == EmergencyPriority.LOW) {
                return 1;
            } else { // medium case
                if (o.priority == EmergencyPriority.HIGH) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
    }

    public boolean processRequest() {
        if (!this.station.isFullForToday()) {
            this.station.performRequest();
            System.out.println("Dispatching " + this.priority + " " + this.emergency + " responder to " + station.getName());
            return true;
        } else {
            return false;
        }
    }
}

/**
 * Author: Tanisha Payne
 * CRN: 20690
 * Program 4: Dispatch
 * Sources:
 *      https://www.geeksforgeeks.org/split-string-java-examples/
 *      https://www.javamex.com/tutorials/collections/sorting_comparable_compareto.shtml
 *
 * The Dispatch program simulates an emergency response system. The program
 * receives a certain number of requests per simulated day and generates
 * dispatch messages for the requests, in priority order.
 *
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Reader {


    public static final int REQUESTS_PER_DAY = 20;

    public static void main(String args [] )
    {
        if (args.length != 1) {
            System.out.println("You didn't provide an input file name.");
        }

        ArrayList<Dispatch> dispatches = new ArrayList<Dispatch>();
        ArrayList<Station> stations = new ArrayList<Station>();

        Scanner scanner = null;
        try {
             scanner = new Scanner(new File(args[0]));
        }
        catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        int day = 1;

        while (scanner.hasNextLine() || dispatches.size() > 0)
        {
            System.out.println("\n======= Processing requests for day "+day+"\n" +
                    "======= "+ dispatches.size() + " requests carried over from previous day");
            int i = 0;

            // get dispatches, only takes 20 per day
            while (scanner.hasNextLine() && i < REQUESTS_PER_DAY) {
                String request = scanner.nextLine();
                String[] array = request.split(":");
                int idRequest = Integer.parseInt(array[0]);
                dispatches.add(new Dispatch(idRequest, array[1], stations));
                i++;
            }

            //Sorts according to Priority and
            Collections.sort(dispatches);
            //reset iterator
            i = 0;
            // process requests until the stations are full
            while (i < dispatches.size()) {
                if (dispatches.get(i).processRequest())
                {
                    dispatches.remove(i);
                }
                else {
                    i++;
                }
            }
            clearAllStations(stations);
            day++;
        }
    }

    public static void clearAllStations(ArrayList<Station> stations) {
        for (int i = 0; i < stations.size(); i++) {
            stations.get(i).resetStation();
        }
    }



}

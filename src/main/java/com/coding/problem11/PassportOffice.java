package com.coding.problem11;

import java.util.*;

/**
 * You are waiting in line at the passport renewal desk and they server everyone in alphabetical order.
 * <p>
 * Given that they process each person in 10 minutes and there are in total n persons at the office
 * how long does it take for you to fill in your new passport request?
 * <p>
 * Input: your name, number of available desks, the n-1 names of the other persons
 * Output: number of minutes you will need to wait to finish your request
 */
public class PassportOffice {

    public static int processingTime = 10;

    public long checkTime(String myName, int availableAgents, List<String> others) {
        List<String> allMembers = new ArrayList(others);
        allMembers.add(myName);
        Collections.sort(allMembers);

        List<List<String>> queues = new ArrayList<>();
        for (int i = 0; i < availableAgents; i++) {
            queues.add(new ArrayList<>());
        }

        int queueIndex = 0;
        int myPosition = 0;
        for (String name : allMembers) {
            queues.get(queueIndex).add(name);
            if (name.equals(myName)) {
                myPosition = queues.get(queueIndex).size();
            }
            queueIndex++;
            if (queueIndex == availableAgents) {
                queueIndex = 0;
            }
        }

        return myPosition * processingTime;
    }
}

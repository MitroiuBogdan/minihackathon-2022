package com.coding.problem6;

import java.util.Map;

/**
 * Implement method timeElapseForMaps which could receive like param :
 * - Hashtable
 * - Collections.synchronizedMap
 * - ConcurrentHashMap
 * <p>
 * for running a micro-benchmark for get and put performance and compare that to Hashtable, Collections.synchronizedMap, ConcurrentHashMap
 * 500,000 times in 10 threads.
 * <p>
 * The return will be a long in nanoseconds, and it will be a difference from startTime and actual System time when all the executions of the threads
 * are finished.
 */
public class MapPerformance {

    public static int THREAD_NUMBER = 10;
    public static int ITERATIONS = 500000;

    long timeElapseForMaps(Map<String, Object> mapInput) throws InterruptedException {
        long initialTime = System.nanoTime();
        testPerformance(mapInput);
        long finalTime = System.nanoTime();
        return finalTime - initialTime;
    }

    public void testPerformance(Map<String, Object> mapInput) {

        for (int i = 0; i < THREAD_NUMBER; i++) {
            Thread readThread = new Thread(() -> {
                for (int j = 0; j < ITERATIONS; j++) {
                    mapInput.put(String.valueOf(j), "Something");
                }
            });
            readThread.start();
        }

        for (int i = 0; i < THREAD_NUMBER; i++) {
            Thread writeThread = new Thread(() -> {
                for (int j = 0; j < ITERATIONS; j++) {
                    mapInput.get(String.valueOf(j));
                }
            });
            writeThread.start();
        }
    }

}



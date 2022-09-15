package com.coding.problem10;


import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * 1. 	Create a LoadBalancer class that has a method to register backend instances
 * Each backend instance address should be unique, it should not be possible to register the same address two times
 * Load balancer should accept up to 5 backend instances
 * LoadBalancerCustomException to be thrown if there are more than five instances to be added
 * The code should be production ready
 * <p>
 * 2. 	Implement a get() method which should return one backend-instance choosing between the registered ones randomly.
 */
public class LoadBalancer {

    final int maxCapacity = 5;
    Map<String, BackendInstance> ipInput = new ConcurrentHashMap<>(maxCapacity);

    public void register(BackendInstance input) {
        Random random = new Random();
        Set<String> ipAddresses = extractValues(ipInput);

        if (ipAddresses.contains(input.getAddress())) {
            throw new SameInstanceException("");
        }

        if (ipInput.size() >= maxCapacity) {
            throw new MaximumInstancesException("");
        }
        ipInput.put(String.valueOf(random.nextInt()), input);
    }

    public BackendInstance get() {
        return ipInput.entrySet()
                .stream()
                .findFirst()
                .map(Map.Entry::getValue)
                .orElse(null);
    }

    public Set<String> extractValues(Map<String, BackendInstance> ipInput) {
        return ipInput.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .map(BackendInstance::getAddress)
                .collect(Collectors.toSet());
    }
}





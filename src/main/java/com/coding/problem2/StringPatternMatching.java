package com.coding.problem2;

/**
 * Using Java 17:
 * Pattern matching for Objects:
 * return 1 for String and 0 for other object
 */
public class StringPatternMatching {

    public int solutionPattern(Object obj) {
        if (obj instanceof String) {
            return 1;
        } else {
            return 0;
        }
    }
}

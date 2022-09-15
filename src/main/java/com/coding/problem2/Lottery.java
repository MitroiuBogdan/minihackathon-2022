package com.coding.problem2;

import java.util.random.RandomGenerator;
import java.util.stream.IntStream;

/**
 * You have been assigned with the upgrade of the Romanian Lottery's system that handles the extraction of winning
 * numbers for the famous 6/49 game.
 * Requirements:
 * The systems are a bit special, so you must generate these numbers using an algorithm that operates on exactly 192 bits.
 * Also, as functional programming and Java 17 are on the rise in the Romanian Lottery, you will need to return the winning numbers in a Stream
 */
public class Lottery {

    private final String RANDOM_NUMBER_GENERATION_ALGORITHM = "L64X128MixRandom";
    private final int LOWER_BOUND = 1;
    private final int UPPER_BOUND = 49;
    private final int NO_OF_RANDOM_NUMBERS_GENERATED = 6;

    public IntStream feelingLucky() {
        RandomGenerator generator = RandomGenerator.of(RANDOM_NUMBER_GENERATION_ALGORITHM);
        return generator.ints(NO_OF_RANDOM_NUMBERS_GENERATED, LOWER_BOUND,  UPPER_BOUND);

    }
}

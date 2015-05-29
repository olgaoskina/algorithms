package generators;

import java.util.Random;

/**
 * Created by olgaoskina
 * 29 May 2015
 */
public class IntegerRandomGenerator implements IGenerator<Integer> {

    @Override
    public Integer[] generateTestArray(int size) {
        return generateTestArray(size, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public Integer[] generateTestArray(int size, int min, int max) {
        return new Random()
                .ints(min, max)
                .limit(size)
                .boxed()
                .toArray(Integer[]::new);
    }
}

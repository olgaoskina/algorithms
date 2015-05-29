package generators;

import java.util.stream.IntStream;

/**
 * Created by olgaoskina
 * 29 May 2015
 */
public class IntegerSortedGenerator implements IGenerator<Integer> {
    @Override
    public Integer[] generateTestArray(int size) {
        return IntStream
                .range(0, size)
                .boxed()
                .toArray(Integer[]::new);
    }
}

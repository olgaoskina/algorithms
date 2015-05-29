package generators;

import java.util.stream.IntStream;

/**
 * Created by olgaoskina
 * 29 May 2015
 */
public class IntegerInvertSortedGenerator implements IGenerator<Integer> {
    @Override
    public Integer[] generateTestArray(int size) {
        return IntStream
                .range(0, size)
                .map(i -> size - i)
                .boxed()
                .toArray(Integer[]::new);
    }
}

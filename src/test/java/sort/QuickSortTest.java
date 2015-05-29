package sort;

import generators.IGenerator;
import generators.IntegerInvertSortedGenerator;
import generators.IntegerRandomGenerator;
import generators.IntegerSortedGenerator;
import org.junit.Test;
import utils.ArrayUtils;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuickSortTest {

    private final int SIZE = 10;

    @Test
    @SuppressWarnings("unchecked")
    public void testSort() throws Exception {
        IGenerator<Integer>[] generators = new IGenerator[]{
                new IntegerRandomGenerator(),
                new IntegerInvertSortedGenerator(),
                new IntegerSortedGenerator()
        };
        final QuickSort<Integer> quickSort = new QuickSort<>();

        Stream<Integer[]> stream = Arrays
                .stream(generators)
                .map(g -> g.generateTestArray(SIZE))
                .map(quickSort::sort)
                .filter(ArrayUtils::isNotSorted);

        assert stream.count() != 0 :
                "These arrays were not sorted: \n" +
                        stream.map(Arrays::toString).collect(Collectors.joining("\n"));
        System.out.println("All arrays were sorted");
    }
}
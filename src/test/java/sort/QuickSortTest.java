package sort;

import generators.IGenerator;
import generators.IntegerInvertSortedGenerator;
import generators.IntegerRandomGenerator;
import generators.IntegerSortedGenerator;
import org.junit.Test;
import utils.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;
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
                .map(array -> quickSort.sort(array, Comparator.<Integer>naturalOrder()));

        assert stream.allMatch(ArrayUtils::isSorted) : "Not all arrays were sorted: \n";
        System.out.println("All arrays were sorted");
    }
}
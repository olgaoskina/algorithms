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

public class MergeSortTest {
    private final int SIZE = 10;

    @Test
    @SuppressWarnings("unchecked")
    public void testSort() throws Exception {
        IGenerator<Integer>[] generators = new IGenerator[]{
                new IntegerRandomGenerator(),
                new IntegerInvertSortedGenerator(),
                new IntegerSortedGenerator()
        };
        final MergeSort<Integer> mergeSort = new MergeSort<>();

        Stream<Integer[]> stream =Arrays
                .stream(generators)
                .map(g -> g.generateTestArray(SIZE))
                .map(array -> mergeSort.sort(array, Comparator.<Integer>naturalOrder())) ;

        assert stream.allMatch(ArrayUtils::isSorted) : "Not all arrays were sorted: \n";
        System.out.println("All arrays were sorted");
    }
}
package sort;

import utils.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by olgaoskina
 * 29 May 2015
 */
public class QuickSort<Type> implements ISort<Type> {

    @Override
    public Type[] sort(Type[] array, Comparator<Type> comparator) {
        if (array == null || array.length <= 1) {
            return array;
        }

        Type[] a = Arrays.copyOf(array, array.length);
        qsort(a, 0, a.length - 1, comparator);
        return a;
    }

    private void qsort(Type[] array, int begin, int end, Comparator<Type> comparator) {
        int l = begin;
        int r = end;
        int m = (begin + end) / 2;
        while (l < r) {
            while (comparator.compare(array[l], array[m]) < 0) l++;
            while (comparator.compare(array[r], array[m]) > 0) r--;

            if (l < r) {
                ArrayUtils.swap(array, l, r);
            }
            l++;
            r--;
        }
        if (l < m) {
            qsort(array, l, m, comparator);
        }
        if (r > m) {
            qsort(array, m + 1, r, comparator);
        }
    }
}

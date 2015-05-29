package sort;

import utils.ArrayUtils;

import java.util.Arrays;

/**
 * Created by olgaoskina
 * 29 May 2015
 */
public class QuickSort<Type extends Comparable<Type>> implements ISort<Type> {

    @Override
    public Type[] sort(Type[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }

        Type[] a = Arrays.copyOf(array, array.length);
        qsort(a, 0, a.length - 1);
        return a;
    }

    private void qsort(Type[] array, int begin, int end) {
        int l = begin;
        int r = end;
        int m = (begin + end) / 2;
        while (l < r) {
            while (array[l].compareTo(array[m]) < 0) l++;
            while (array[r].compareTo(array[m]) > 0) r--;

            if (l < r) {
                ArrayUtils.swap(array, l, r);
            }
            l++;
            r--;
        }
        if (l < m) {
            qsort(array, l, m);
        }
        if (r > m) {
            qsort(array, m + 1, r);
        }
    }
}

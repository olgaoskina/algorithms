package utils;

/**
 * Created by olgaoskina
 * 29 May 2015
 */
public class ArrayUtils {
    public static <Type extends Comparable<Type>> boolean isSorted(Type[] array) {
        boolean sorted = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].compareTo(array[i + 1]) > 0) {
                sorted = false;
                break;
            }
        }
        return sorted;
    }

    public static <Type extends Comparable<Type>> boolean isNotSorted(Type[] array) {
        return !isSorted(array);
    }

    public static <Type> void swap(Type[] array, int a, int b) {
        Type tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}

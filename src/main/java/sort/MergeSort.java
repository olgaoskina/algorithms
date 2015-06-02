package sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by olgaoskina
 * 29 May 2015
 */
public class MergeSort<Type> implements ISort<Type> {

    @Override
    public Type[] sort(Type[] array, Comparator<Type> comparator) {
        if (array == null || array.length <= 1) {
            return array;
        }

        Type[] a = Arrays.copyOf(array, array.length);
        mergeSort0(a, comparator);
        return a;
    }

    @SuppressWarnings("unchecked")
    private void mergeSort0(Type[] array, Comparator<Type> comparator) {
        if (array.length == 1) {
            return;
        }
        int m = array.length / 2;

        Type[] leftArray = (Type[]) new Object[m];
        Type[] rightArray = (Type[]) new Object[array.length - m];

        System.arraycopy(array, 0, leftArray, 0, m);
        System.arraycopy(array, m, rightArray, 0, rightArray.length);

        mergeSort0(leftArray, comparator);
        mergeSort0(rightArray, comparator);
        System.arraycopy(merge(leftArray, rightArray, comparator), 0, array, 0, array.length);
    }

    @SuppressWarnings("unchecked")
    private Type[] merge(Type[] leftArray, Type[] rightArray, Comparator<Type> comparator) {
        final int leftLength = leftArray.length;
        final int rightLength = rightArray.length;
        final int resLength = rightLength + leftLength;

        Type[] resArray = (Type[]) new Object[leftLength + rightLength];

        int leftPos = 0;
        int rightPos = 0;
        int resPos = 0;

        while (resPos < resLength) {
            if (leftPos == leftLength) {
                System.arraycopy(rightArray, rightPos, resArray, resPos, rightLength - rightPos);
                resPos = resLength;
            } else if (rightPos == rightLength) {
                System.arraycopy(leftArray, leftPos, resArray, resPos, leftLength - leftPos);
                resPos = resLength;
            } else if (comparator.compare(leftArray[leftPos], rightArray[rightPos]) < 0) {
                resArray[resPos++] = leftArray[leftPos++];
            } else {
                resArray[resPos++] = rightArray[rightPos++];
            }
        }
        return resArray;
    }
}

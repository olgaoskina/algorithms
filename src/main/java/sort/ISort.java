package sort;

import java.util.Comparator;

/**
 * Created by olgaoskina
 * 29 May 2015
 */
public interface ISort<Type> {
    Type[] sort(Type[] array, Comparator<Type> comparator);
}

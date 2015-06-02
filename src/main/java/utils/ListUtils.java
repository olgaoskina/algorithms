package utils;

import list.SinglyLinkedList;

/**
 * Created by olgaoskina
 * 03 June 2015
 */
public class ListUtils {

    @SafeVarargs
    public static <Type> SinglyLinkedList<Type> newSinglyLinkedList(Type... args) {
        SinglyLinkedList<Type> list = new SinglyLinkedList<>(null, args[args.length - 1]);
        for (int i = args.length - 2; i >= 0; i--) {
            list = new SinglyLinkedList<>(list, args[i]);
        }
        return list;
    }
}

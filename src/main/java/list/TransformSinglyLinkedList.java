package list;

/**
 * Created by olgaoskina
 * 03 June 2015
 */
public class TransformSinglyLinkedList {

    public static <Type> SinglyLinkedList<Type> reverse(SinglyLinkedList<Type> list) {
        if (list == null || list.getNext() == null) {
            return list;
        }
        SinglyLinkedList<Type> prev = list.getNext();
        SinglyLinkedList<Type> curr = prev.getNext();
        list.setNext(null);
        prev.setNext(list);
        while (curr != null) {
            SinglyLinkedList<Type> next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

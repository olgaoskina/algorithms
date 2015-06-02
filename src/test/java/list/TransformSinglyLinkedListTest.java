package list;

import generators.IntegerInvertSortedGenerator;
import org.junit.Test;
import utils.ListUtils;

import static list.TransformSinglyLinkedList.reverse;

public class TransformSinglyLinkedListTest {
    private final int SIZE = 100;

    @Test
    public void testReverse() throws Exception {
        final IntegerInvertSortedGenerator generator = new IntegerInvertSortedGenerator();

        final SinglyLinkedList<Integer> intList = ListUtils.newSinglyLinkedList(generator.generateTestArray(SIZE));
        assert intList.equals(reverse(reverse(intList))) : "Reverse singly linked list doesn't work";

        final SinglyLinkedList<Integer> intList2 = ListUtils.newSinglyLinkedList(1);
        assert reverse(intList2).equals(reverse(intList2)) : "Reverse singly linked list doesn't work";

        System.out.println("Reverse singly linked list work correctry");
    }
}
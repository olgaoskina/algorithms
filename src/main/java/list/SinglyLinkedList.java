package list;

/**
 * Created by olgaoskina
 * 03 June 2015
 */
public class SinglyLinkedList<Type> {
    private SinglyLinkedList<Type> next;
    private Type value;

    public SinglyLinkedList(SinglyLinkedList<Type> next, Type value) {
        this.next = next;
        this.value = value;
    }

    public SinglyLinkedList<Type> getNext() {
        return next;
    }

    public Type getValue() {
        return value;
    }

    public void setNext(SinglyLinkedList<Type> next) {
        this.next = next;
    }

    public void setValue(Type value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return next == null ? value.toString() : value.toString() + " -> " + next.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (getClass() == obj.getClass()) {
            SinglyLinkedList list = (SinglyLinkedList) obj;
            return next == null ? value.equals(list.getValue()) : value.equals(list.value) && next.equals(list.getNext());
        } else {
            return false;
        }
    }
}

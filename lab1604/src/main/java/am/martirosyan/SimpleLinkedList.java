package am.martirosyan;

public class SimpleLinkedList {
    Elem head;
    int size = 0;

    public void append(Elem elem) {
        if (head == null) {
            head = elem;
        } else {
            Elem current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = elem;
        }
        size++;
    }

    public void append(int index, Elem elem) {
        if (index < 0)
            throw new RuntimeException("Index should be more than 0");
        if (index > size)
            throw new RuntimeException("Index should be menshe than size");

        Elem current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        Elem prev = current;
        Elem next = current.next;

        prev.next = elem;
        elem.next = next;
    }
}

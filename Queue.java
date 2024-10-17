public class Queue<T> {
    private Node<T> first, last;

    public boolean isEmpty() {
        return (first == null);
    }

    public void enqueue(T item) {
        Node<T> oldLast = last;
        last = new Node<>();
        last.item = item;
        last.next = null;
        if (isEmpty())
            first = last;
        else
            oldLast.next = last;
    }

    public T dequeue() {
        T item = first.item;
        first = first.next;
        // if (isEmpty())
        //     first = last;
        return item;
    }
    
    public T peek() {
        return first.item;
    }
}

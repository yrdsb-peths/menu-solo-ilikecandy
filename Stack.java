public class Stack<T> {
    private Node<T> first;

    public boolean isEmpty() {
        return first == null;
    }

    public void push(T item) {
        Node<T> second = first;
        first = new Node<>();
        first.item = item;
        first.next = second;
    }

    public T pop() {
        T item = first.item;
        first = first.next;
        return item;
    }

    public T peek() {
        return first.item;
    }
}

public interface Stack<E> {
    int size();
    void push(E e);
    E top();
    E pop();
    boolean isEmpty();
}

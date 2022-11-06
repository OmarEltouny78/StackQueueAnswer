
public class LinkedStack<E>implements Stack<E> {
    private SinglyLinkedLIst<E>list=new SinglyLinkedLIst<E>();

    public LinkedStack() {
    }

    @Override
    public int size() {
        return list.getSize();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E top() {
        return list.first( );
    }

    @Override
    public E pop() {
        return list.removeFirst( );
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
public class LinkedQueue<E> implements Queue<E>{
    private SinglyLinkedLIst<E>list=new SinglyLinkedLIst<E>();

    public LinkedQueue() {
    }

    @Override
    public int size() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void enqueue(E o) {
        list.addLast(o);
    }

    @Override
    public E first() {
        return list.first();
    }

    @Override
    public E dequeue() {
        return list.removeFirst();
    }
}


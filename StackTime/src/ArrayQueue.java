public class ArrayQueue<E>implements Queue<E> {
    private E[]data;
    private int f=0;
    private int sz=0;
    private int CAPCITY=1000;
    public ArrayQueue(int capcity) {
        data = (E[ ])new Object[capcity];
    }


    @Override
    public int size() {
        return sz;
    }

    @Override
    public boolean isEmpty() {
        return sz==0;
    }

    @Override
    public void enqueue(E e) throws IllegalStateException {
        if(sz==data.length) throw new IllegalStateException("Queue is full");
        int avail=(f+sz)%data.length;
        data[avail]=e;
        sz++;
    }

    @Override
    public E first() {
        if(isEmpty())
            return null;
        return data[f];
    }

    @Override
    public E dequeue() {
        if(isEmpty())
            return null;
        E answer=data[f];
        data[f]=null;
        f=(f+1)%data.length;
        sz--;
        return answer;
    }
}

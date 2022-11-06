public class ArrayStack<E> implements Stack<E>{
    private int CAPCITY=1000;
    private E[]data;
    private int t=-1;


    public ArrayStack(int CAPCITY) {
        data= (E[]) new Object[CAPCITY];
    }

    @Override
    public int size() {
        return t+1;
    }

    @Override
    public void push(E e) throws IllegalStateException {
        if(size()==data.length)throw new IllegalStateException( "Stack is Full" );
        data[++t]=e;
    }

    @Override
    public E top() {
        if (isEmpty()) return null;
        return data[t];
    }

    @Override
    public E pop() {
        E answer=data[t];
        data[t]=null;
        t--;
        return answer;
    }

    @Override
    public boolean isEmpty() {
        return t==-1;
    }

}

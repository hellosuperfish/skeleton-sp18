import java.util.Deque;

public class ArrayDeque<T> {
    private int DequeSize;
    private T[] items;
    private double UseFactor = 0.25;


    public ArrayDeque() {
        items = (T[]) new Object[8];
        DequeSize = 0;
    }



    public void addFirst(T item) {
        if (DequeSize == items.length){
            resize(DequeSize * 2);
        }
        items[-1] = item;
        DequeSize += 1;
    }

    private void resize(int capacity){
        T[] longerItems = (T[])new Object[capacity];
        System.arraycopy(items, 0, longerItems, 0, DequeSize);
        items = longerItems;
    }

    public void addLast(T item) {
        if (DequeSize == items.length){
            resize(DequeSize * 2);
        }
        items[DequeSize] = item;
        DequeSize += 1;
    }

    public boolean isEmpty() {
        if(DequeSize == 0){
            return true;
        }
        return false;
    }

    public int size() {
        return DequeSize;
    }

    public void printDeque() {
        for(int i = 0; i < DequeSize; i++){
            System.out.println(items[i]);
        }
    }

    public T removeFirst() {
        T removed = items[0];
        items[0] = null;
        DequeSize -= 1;
        if(DequeSize / items.length <= UseFactor){
            resize(items.length / 2);
        }
        return removed;
    }

    public T removeLast() {
        T removed = items[DequeSize-1];
        items[DequeSize-1] = null;
        DequeSize -= 1;
        if(DequeSize / items.length <= UseFactor){
            resize(items.length / 2);
        }
        return removed;
    }

    public T get(int index) {
        return items[index];
    }


}
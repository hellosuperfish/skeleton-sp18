import java.util.Deque;

public class ArrayDeque<T> {
    private int DequeSize;
    private T[] items;
    private int INITIAL_CAPACITY = 8;
    private int nextFirst;
    private int nextLast;
    private double UseFactor = 0.25;


    public ArrayDeque() {
        items = (T[]) new Object[INITIAL_CAPACITY];
        DequeSize = 0;

        nextFirst = 0;
        nextLast = 0;

    }

    //function to resize the array, and during each resize, the oder of the array is rearranged to
    //leaner, meaning that the first is always in the beginning.
    private void resize(int capacity){
        T[] newItems = (T[])new Object[capacity];
        int firstLength = items.length - nextFirst;
        System.arraycopy(items, nextFirst + 1, newItems, 0, firstLength);
        System.arraycopy(items, 0, newItems, firstLength -1, nextLast);
        items = newItems;
        nextFirst = capacity - 1;
        nextLast = DequeSize;
    }

    // function to get the index before this index, useful in addFirst function to update nextFirst
    private int minusOne(int index){
        if (index == 0){
            return items.length - 1;
        }
        return index - 1;
    }

    public void addFirst(T item) {
        if (DequeSize == items.length){
            resize(DequeSize * 2);
        }
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        DequeSize += 1;
    }

    public void addLast(T item) {
        if (DequeSize == items.length){
            resize(DequeSize * 2);
        }
        items[nextLast] = item;
        nextLast += 1;
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
        T removed = items[nextFirst + 1];
        items[nextFirst + 1] = null;
        nextFirst += 1
        DequeSize -= 1;
        if(DequeSize / items.length <= UseFactor){
            resize(items.length / 2);
        }
        return removed;
    }

    public T removeLast() {
        T removed = items[nextLast - 1];
        items[nextLast - 1] = null;
        nextLast -= 1;
        DequeSize -= 1;
        if(DequeSize / items.length <= UseFactor){
            resize(items.length / 2);
        }
        return removed;
    }

    public T get(int index) {
        int firstLength = items.length - nextFirst;
        if (index < firstLength){
            return items[nextFirst + index];
        }
        return items[index-firstLength];
    }


}
public class ArrayDeque<T> {
    private int dequeSize;
    private T[] items;
    private int INITIAL_CAPACITY = 8;
    private int nextFirst;
    private int nextLast;
    private double useFactor = 0.25;


    public ArrayDeque() {
        items = (T[]) new Object[INITIAL_CAPACITY];
        dequeSize = 0;

        nextFirst = 0;
        nextLast = 0;

    }

    //function to resize the array, and during each resize, the oder of the array is rearranged to
    //leaner, meaning that the first is always in the beginning.
    private void resize(int capacity) {
        T[] newItems = (T[]) new Object[capacity];
        int firstLength = items.length - nextFirst - 1;
        System.arraycopy(items, nextFirst + 1, newItems, 0, firstLength);
        System.arraycopy(items, 0, newItems, firstLength, nextLast);
        items = newItems;
        nextFirst = capacity - 1;
        nextLast = dequeSize;
    }

    // function to get the index before this index, useful in addFirst function to update nextFirst
    private int minusOne(int index) {
        if (index == 0) {
            return items.length - 1;
        }
        return index - 1;
    }

    private int plusOne(int index) {
        if (index == items.length - 1) {
            return 0;
        }
        return index + 1;
    }

    public void addFirst(T item) {
        if (dequeSize == items.length) {
            resize(items.length * 2);
        }

        if (dequeSize == 0) {
            nextLast += 1;
        }
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);

        dequeSize += 1;
    }

    public void addLast(T item) {
        if (dequeSize == items.length) {
            resize(dequeSize * 2);
        }
        if (dequeSize == 0) {
            nextFirst = minusOne(0);
        }
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        dequeSize += 1;
    }

    public boolean isEmpty() {
        if (dequeSize == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return dequeSize;
    }

    public void printDeque() {
        for (int i = 0; i < dequeSize; i++) {
            System.out.println(items[i]);
        }
    }

    public T removeFirst() {
        T removed = items[plusOne(nextFirst)];
        items[plusOne(nextFirst)] = null;
        nextFirst = plusOne(nextFirst);
        dequeSize -= 1;
        if ((double) dequeSize / items.length <= useFactor && items.length >= 16) {
            resize(items.length / 2);
        }
        return removed;
    }

    public T removeLast() {
        T removed = items[minusOne(nextLast)];
        items[minusOne(nextLast)] = null;
        nextLast = minusOne(nextLast);
        dequeSize -= 1;
        if ((double) dequeSize / items.length <= useFactor && items.length >= 16) {
            resize(items.length / 2);
        }
        return removed;
    }

    public T get(int index) {
        int firstLength = items.length - nextFirst - 1;
        if (index < firstLength) {
            return items[nextFirst + index + 1];
        }
        return items[index - firstLength];
    }


}

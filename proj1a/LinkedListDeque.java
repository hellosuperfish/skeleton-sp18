public class LinkedListDeque<T> {

    //Node class that has a item T, and two pointers point to previous node and next node
    private class ItemNode {
        T item;
        ItemNode prev;
        ItemNode next;

        ItemNode(T i, ItemNode p, ItemNode n) {
            this.item = i;
            this.prev = p;
            this.next = n;
        }
    }

    private ItemNode sentinel;
    private int dequeSize = 0;


    //constructor for empty list
    public LinkedListDeque() {
        sentinel = new ItemNode((T) null, sentinel, sentinel);
        dequeSize = 0;
    }

    //constructor for list of one item
    public LinkedListDeque(T item) {
        sentinel = new ItemNode((T) null, sentinel, sentinel);
        sentinel.next = new ItemNode(item, sentinel, sentinel);
        sentinel.prev = sentinel.next;
        dequeSize = 1;
    }

    public void addFirst(T item) {
        if (sentinel.next == null) {
            sentinel.next = new ItemNode(item, sentinel, sentinel);

        } else {
            sentinel.next = new ItemNode(item, sentinel, sentinel.next);
        }
        sentinel.next.next.prev = sentinel.next;
        dequeSize += 1;
    }

    public void addLast(T item) {
        if (sentinel.prev == null) {
            sentinel.prev = new ItemNode(item, sentinel, sentinel);

        } else {
            sentinel.prev = new ItemNode(item, sentinel.prev, sentinel);
        }
        sentinel.prev.prev.next = sentinel.prev;
        dequeSize += 1;
    }

    public boolean isEmpty() {
        return (dequeSize == 0);
    }

    public int size() {
        return dequeSize;
    }

    public void printDeque() {
        ItemNode p = sentinel.next;
        for (int i = 0; i < dequeSize; i++) {
            System.out.println(p.item);
            p = p.next;
        }
    }

    public T removeFirst() {
        if (dequeSize == 0) {
            return null;
        }
        T removed = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        dequeSize -= 1;
        return removed;
    }

    public T removeLast() {
        if (dequeSize == 0) {
            return null;
        }
        T removed = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        dequeSize -= 1;
        return removed;
    }

    public T get(int index) {
        ItemNode p = sentinel.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.item;
    }

    public T getRecursive(int index, ItemNode p) {
        if (index == 0) {
            return p.item;
        }
        return getRecursive(index - 1, p.next);
    }

    public T getRecursive(int index) {
        if (dequeSize == 0) {
            System.out.println("list is empty");
        } else if (index >= dequeSize) {
            System.out.println("Index out of bound");
        }
        return getRecursive(index, sentinel.next);
    }


}

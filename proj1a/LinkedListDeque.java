import java.util.Deque;

public class LinkedListDeque<T> {

    //Node class that has a item T, and two pointers point to previous node and next node
    private class itemNode {
        public T item;
        public itemNode prev;
        public itemNode next;

        public itemNode(T i, itemNode p, itemNode n){
            this.item = i;
            this.prev = p;
            this.next = n;
        }
    }

    private itemNode sentinel;
    private int DequeSize = 0;


    //constructor for empty list
    public LinkedListDeque(){
        sentinel = new itemNode((T)null, sentinel, sentinel);
        DequeSize = 0;
    }

    //constructor for list of one item
    public LinkedListDeque(T item){
        sentinel = new itemNode((T)null, sentinel, sentinel);
        sentinel.next = new itemNode(item, sentinel, sentinel);
        sentinel.prev = sentinel.next;
        DequeSize = 1;
    }

    public void addFirst(T item){
       if(sentinel.next == null){
           sentinel.next = new itemNode(item, sentinel, sentinel);
           sentinel.next.next.prev = sentinel.next;
           DequeSize += 1;
       }else {
           sentinel.next = new itemNode(item, sentinel, sentinel.next);
           sentinel.next.next.prev = sentinel.next;
           DequeSize += 1;
       }
    }

    public void addLast(T item){
        if(sentinel.prev == null) {
            sentinel.prev = new itemNode(item, sentinel, sentinel);
            sentinel.prev.prev.next = sentinel.prev;
            DequeSize += 1;
        }else {
            sentinel.prev = new itemNode(item, sentinel.prev, sentinel);
            sentinel.prev.prev.next = sentinel.prev;
            DequeSize += 1;
        }
    }

    public boolean isEmpty(){
        return (DequeSize == 0);
    }

    public int size(){
        return DequeSize;
    }

    public void printDeque(){
        itemNode p = sentinel.next;
        for(int i = 0; i < DequeSize; i++){
            System.out.println(p.item);
            p = p.next;
        }
    }

    public T removeFirst(){
        T removed = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        DequeSize -= 1;
        return removed;
    }

    public T removeLast(){
        T removed = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        DequeSize -= 1;
        return removed;
    }

    public T get(int index){
        itemNode p = sentinel.next;
        for(int i = 0; i < index; i++){
            p = p.next;
        }
        return p.item;
    }

    public T getRecursive(int index, itemNode p){
        if(index == 0){
            return p.item;
        }
        return getRecursive(index - 1, p.next);
    }

    public T getRecursive(int index){
        if(DequeSize == 0){
            System.out.println("list is empty");
        }
        else if (index >= DequeSize){
            System.out.println("Index out of bound");
        }
        return getRecursive(index, sentinel.next);
    }


}

public class ArrayDequeTest {
    private static void testAdd() {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.addFirst(3);
        ad.addLast(4);
        ad.addFirst(2);
        ad.addLast(5);
        ad.addFirst(1);
        ad.addLast(6);
        ad.addFirst(0);
        ad.addLast(7);
        System.out.println("size is " + ad.size());
        System.out.println("The 0th item is " + ad.get(0) + ", the 7th item is " + ad.get(7));

        ad.addLast(8);
        System.out.println("size is " + ad.size());

        int a = ad.removeFirst();
        int b = ad.removeLast();
        System.out.println("remove first " + a);
        System.out.println("remove last " + b);
        System.out.println("The 0th item is " + ad.get(0) + ", the 7th item is " + ad.get(7));
        ad.removeFirst();
        ad.removeFirst();
        ad.removeFirst();
        ad.removeFirst();
        ad.removeLast();
        ad.removeLast();
        ad.removeLast();
        System.out.println("size is " + ad.size());
        ad.removeLast();
        System.out.println("size is " + ad.size());
    }

    private static void testRemove() {
        ArrayDeque<Integer> AD = new ArrayDeque<>();
        AD.addFirst(0);
        AD.addLast(1);
        AD.addFirst(2);
        AD.removeFirst();
        AD.removeLast();
        AD.removeLast();
        AD.addLast(6);
        AD.get(0);
        AD.removeLast();
        AD.addLast(9);
        AD.removeFirst();
        AD.addLast(11);
        AD.addFirst(12);
        AD.addFirst(13);
        AD.removeLast();
        AD.removeFirst();
        AD.removeLast();
    }

    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        //testAdd();
        testRemove();
    }
}

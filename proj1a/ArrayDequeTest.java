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
        ArrayDeque<Integer> A = new ArrayDeque<>();
        A.removeFirst();
        A.addFirst(2);
        A.addLast(3);
        A.addFirst(4);
        A.removeFirst();
        A.removeFirst();
        A.addLast(7);
        A.addLast(8);
        A.addFirst(9);
        A.get(1);
        A.addFirst(11);
        A.addLast(12);
        A.get(5);
        A.get(4);
        A.addLast(15);
        A.addLast(16);
        A.removeFirst();
        A.addLast(18);
        A.addFirst(19);
        A.removeFirst();
        A.removeFirst();

    }

    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        //testAdd();
        testRemove();
    }
}

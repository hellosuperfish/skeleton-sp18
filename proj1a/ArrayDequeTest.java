public class ArrayDequeTest {
    private static void testAdd(){
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.addFirst(3);
        ad.addLast(4);
        ad.addFirst(2);
        ad.addLast(5);
        ad.addFirst(1);
        ad.addLast(6);
        ad.addFirst(0);
        ad.addLast(7);
        System.out.println("size is "+ad.size());
        System.out.println("The 0th item is "+ad.get(0)+", the 7th item is "+ ad.get(7));

        ad.addLast(8);
        System.out.println("size is "+ad.size());
    }

    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        testAdd();
    }
}

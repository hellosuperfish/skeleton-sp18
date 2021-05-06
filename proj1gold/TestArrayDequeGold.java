import org.junit.Test;

import java.lang.reflect.Array;

import static org.junit.Assert.*;

public class TestArrayDequeGold {

    @Test
    public void testArrayDeque(){
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<Integer>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();

        for (int i = 0; i < 10; i++){
            boolean randomBoolean = StdRandom.bernoulli();

            if (randomBoolean) {
                sad.addFirst(i);
                ads.addFirst(i);
            } else {
                sad.addLast(i);
                ads.addLast(i);
            }
        }

        assertEquals(10, sad.size());
        assertEquals(10, sad.size());

        for (int i = 0; i < 10; i++){
            boolean randomBoolean = StdRandom.bernoulli();

            if (randomBoolean) {
                int sf = sad.removeFirst();
                int af = ads.removeFirst();
                assertEquals("remove first has did not work this time", sf, af);
            } else {
                int sl = sad.removeLast();
                int al = ads.removeLast();
                assertEquals("remove last has did not work this time", sl, al);
            }
        } */
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<Integer>();
        ArrayDequeSolution<Integer> ads1 = new ArrayDequeSolution<>();

        sad1.addFirst(5);
        ads1.addFirst(5);
        sad1.addLast(10);
        ads1.addLast(10);
        sad1.addFirst(3);
        ads1.addFirst(3);
        sad1.addLast(15);
        ads1.addLast(15);
        int a = sad1.removeLast();
        int b = sad1.removeFirst();

        assertEquals("student remove last expects 15, but got " + a, 15, a);
        assertEquals("student remove first expects 3, but got " + b, 3, b);

    }
}

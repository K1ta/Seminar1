package seminar1;

import seminar1.collections.CyclicArrayDeque;

public class Main {

    public static void main(String[] args) {
        CyclicArrayDeque<Integer> dec = new CyclicArrayDeque<>();
        for (int i = 0; i < 25; i++) {
            if (i % 2 == 0) {
                dec.pushFront(i);
            } else {
                dec.pushBack(i);
            }
        }
        for (int i = 0; i < 25; i++) {
            if (i % 2 == 0) {
                System.out.println(dec.popBack());
            } else {
                System.out.println(dec.popFront());
            }
        }
    }
}

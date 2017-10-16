package seminar1;

import seminar1.collections.CyclicArrayDeque;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        CyclicArrayDeque<Integer> dec = new CyclicArrayDeque<>();
        for(int i = 0; i < 30; i++)
        {
            if(i % 2 == 0)
            {
                dec.pushFront(i);
            }
            else
            {
                dec.pushBack(i);
            }
        }
        for(int i = 0; i < 30; i++)
        {
            if(i % 2 == 0)
            {
                System.out.println(dec.popFront());
            }
            else
            {
                System.out.println(dec.popBack());
            }
        }
    }
}

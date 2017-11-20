package seminar1;

import seminar1.iterators.MergingPeekingIncreasingIterator;
import seminar1.iterators.PeekingIncreasingIterator;

public class Main {

    public static void main(String[] args) {
        PeekingIncreasingIterator it1 = new PeekingIncreasingIterator(1, 7, 7);
        PeekingIncreasingIterator it2 = new PeekingIncreasingIterator(3, 7, 30);
        PeekingIncreasingIterator it3 = new PeekingIncreasingIterator(2, 4, 10);
        MergingPeekingIncreasingIterator it = new MergingPeekingIncreasingIterator(it1, it2, it3);
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}

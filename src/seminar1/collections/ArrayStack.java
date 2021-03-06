package seminar1.collections;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayStack<Item> implements IStack<Item> {

    private static final int DEFAULT_CAPACITY = 10;

    private Item[] elementData;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayStack() {
        this.elementData = (Item[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void push(Item item) {
        elementData[size] = item;
        size++;
        if (size == elementData.length) {
            grow();
        }
    }

    @Override
    public Item pop() {
        if (size == 0) {
            return null;
        }
        Item item = elementData[size - 1];
        elementData[size - 1] = null;
        size--;
        if (elementData.length / size >= 4) {
            shrink();
        }
        return item;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void grow() {
        /**
         * TODO: implement it
         * Если массив заполнился,
         * то увеличить его размер в полтора раз
         */
        int newCapacity = (int) (size * 1.5f);
        if (newCapacity < 0) {
            throw new IllegalStateException("Sorry, ArrayStack too big");
        }
        changeCapacity(newCapacity);
    }

    private void shrink() {
        /**
         * TODO: implement it
         * Если количество элементов в четыре раза меньше,
         * то уменьшить его размер в два раза
         */
        int newCapacity = size >> 1;
        changeCapacity(newCapacity);
    }

    private void changeCapacity(int newCapacity) {
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayStackIterator();
    }

    private class ArrayStackIterator implements Iterator<Item> {

        private int currentPosition = size;

        @Override
        public boolean hasNext() {
            return currentPosition != 0;
        }

        @Override
        public Item next() {
            return elementData[--currentPosition];
        }

    }

}

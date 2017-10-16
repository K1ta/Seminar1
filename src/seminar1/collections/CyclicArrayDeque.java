package seminar1.collections;

import java.util.Iterator;

//недоделано
public class CyclicArrayDeque<Item> implements IDeque<Item> {

    private static final int DEFAULT_CAPACITY = 10;

    private Item[] elementData;
    private int size;
    private int head;
    private int tail;

    public CyclicArrayDeque() {
        elementData = (Item[]) new Object[DEFAULT_CAPACITY];
        size = 0;
        head = elementData.length - 1;
        tail = 0;
    }

    @Override
    public void pushFront(Item item) {
        elementData[tail] = item;
        size++;
        tail = (tail + 1) % elementData.length;
        if (tail == head) {
            grow();
        }
    }

    @Override
    public void pushBack(Item item) {
        elementData[head] = item;
        size++;
        //head = (head - 1) % elementData.length;
        head = (head - 1 < 0) ? elementData.length - 1 : head - 1;
        if (tail == head) {
            grow();
        }
    }

    @Override
    public Item popFront() {
        if (size == 0) {
            return null;
        }
        tail = (tail - 1 >= 0) ? tail - 1 : elementData.length - 1;
        Item item = elementData[tail];
        if (item != null) {
            elementData[tail] = null;
            size--;
            //tail = (tail - 1 >= 0) ? tail - 1 : elementData.length - 1;
            if (elementData.length >= 4 * size) {
                shrink();
            }
            return item;
        }
        return null;
    }

    @Override
    public Item popBack() {
        if (size == 0) {
            return null;
        }
        head = (head + 1) % elementData.length;
        Item item = elementData[head];
        if (item != null) {
            elementData[head] = null;
            size--;
            //head = (head + 1) % elementData.length;
            if (elementData.length >= 4 * size) {
                shrink();
            }
            return item;
        }
        return null;
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
        int newCapacity = (int) (elementData.length * 1.5f);
        Item a[] = (Item[]) new Object[newCapacity];
        int length = elementData.length - head;
        System.arraycopy(elementData, 0, a, 0, tail + 1);
        System.arraycopy(elementData, head, a, newCapacity - length, length);
        elementData = a;
        head = newCapacity - length;
    }

    private void shrink() {
        /**
         * TODO: implement it
         * Если количество элементов в четыре раза меньше,
         * то уменьшить его размер в два раза
         */
        int newCapacity = elementData.length >> 1;
        Item a[] = (Item[]) new Object[newCapacity];
        int length = elementData.length - head;
        System.arraycopy(elementData, 0, a, 0, tail + 1);
        System.arraycopy(elementData, head, a, newCapacity - length, length);
        elementData = a;
        head = newCapacity - length + 1;
    }

    @Override
    public Iterator<Item> iterator() {
        /* TODO: implement it */
        return null;
    }
}

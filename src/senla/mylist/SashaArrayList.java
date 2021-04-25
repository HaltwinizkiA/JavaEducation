package senla.mylist;

import java.util.*;
import java.util.function.Consumer;

public class SashaArrayList<E> implements Mylist<E>, Iterable<E> {
    private int capacity = 4;
    private E[] array;

    public SashaArrayList() {
        array = (E[]) new Object[capacity];
    }


    public SashaArrayList(int capacity) {
        this.capacity = capacity;
        array = (E[]) new Object[capacity];

    }

    @Override
    public String toString() {
        return "SashaArrayList{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    public boolean checkRange(int index) {
        return index <= capacity;
    }

    @Override
    public void arrDelNull() {
        int getLengt = 0;
        for (E el : array) {
            if (el == null) {
                continue;
            }
            getLengt++;

        }
        E[] cache = (E[]) new Object[getLengt];
        for (int i = 0; i < cache.length; i++) {
            cache[i] = array[i];
        }
        array = cache;


    }

    @Override
    public void add(int index, E obj) {
        E[] cache = (E[]) new Object[array.length + 1];

        for (int i = 0; i < array.length; i++) {
            if (i < index) {
                cache[i] = array[i];
            }
            if (i == index) {
                cache[i] = obj;
            }
            if (i > index) {
                cache[i] = array[i - 1];
            }

        }
        array = cache;


    }

    @Override
    public void addRange() {
        E[] cache = (E[]) new Object[array.length + capacity];
        for (int i = 0; i < array.length; i++) {
            cache[i] = array[i];


        }
        array = cache;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> col) {

        boolean chek = false;

        if ((array.length - index) < col.toArray().length) {
            addRange();
        }
        for (E e : col) {
            array[index++] = e;
            chek = true;
        }
        arrDelNull();
        return chek;


    }

    @Override
    public E get(int index) {
        if (index > array.length) {
            System.out.println("invalid index");
            return null;
        } else {
            return array[index];
        }
    }

    @Override
    public int indexOf(Object obj) {
        int check = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(obj)) {
                check = i;
                break;
            }
        }
        return check;
    }

    @Override
    public int LastIndexOf(Object obj) {
        int check = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                continue;
            }
            if (array[i].equals(obj)) {
                check = i;

            }
        }
        return check;
    }

    @Override
    public E set(int index, E obj) {
        E oldvalue = array[index];
        array[index] = obj;
        return oldvalue;
    }

    @Override
    public E remove(int index) {
        E old = array[index];
        array[index] = null;
        E[] cache = (E[]) new Object[array.length];

        for (int i = 0, j = 0; i < cache.length & j < array.length; i++, j++) {

            if (array[i] == null) {
                j++;
                if (j >= array.length) {
                    break;
                }
            }
            cache[i] = array[j];

        }
        array = cache;
        arrDelNull();
        return old;
    }


    @Override
    public ListIterator<E> listIterator() {
        ListIterator<E> listIterator=array;

        return listIterator;
    }

    @Override
    public Mylist<E> of(Object... e) {
        Mylist<E> lis = new SashaArrayList<E>();
        int i = 0;
        for (Object el : e) {
            lis.add(i, (E) el);
            i++;
        }

        lis.arrDelNull();
        return lis;
    }


    @Override
    public void sort(Comparator<? super E> comp) {


    }

    @Override
    public Mylist<E> subList(int start, int end) {
        arrDelNull();
        Mylist<E> cache = new SashaArrayList<E>(end - start);
        for (int i = start, j = 0; i < end; i++, j++) {
            cache.add(j, array[i]);

        }
        cache.arrDelNull();
        return cache;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super E> action) {

    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }
}

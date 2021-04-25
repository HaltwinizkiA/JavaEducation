package senla.mylist;

import java.util.Collection;
import java.util.Comparator;
import java.util.ListIterator;

public interface Mylist<E> {
    void add(int index,E obj);//+
    boolean addAll(int index, Collection<?extends E>cool);//+
    E get(int index);//+
    int indexOf(Object obj);//+
    int LastIndexOf(Object obj);//+
    ListIterator<E>listIterator();//
    public <E> Mylist<E> of(Object[] e);//+
    E remove(int index);//+
    E set(int index,E obj);//+
    void sort(Comparator<?super E> comp);//
    Mylist<E> subList(int start,int end);//+
    public void arrDelNull();//+
    public void addRange();//+
}

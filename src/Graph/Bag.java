package Graph;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by abhishek.ar on 14/07/17.
 */
public class Bag<Item> implements Iterable<Item> {

    private Node<Item> first;
    private int size;

    class Node<Item>{
        Item item;
        Node next;
    }

    public Bag(){
        first = null;
        size = 0;
    }

    public void add(Item item){
        Node<Item> oldFirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldFirst;
        ++size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

    private class ListIterator<Item> implements Iterator<Item> {

        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            this.current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}

package Heap;


import java.util.Comparator;

/**
 * Created by abhishek.ar on 24/07/17.
 */

//MinHeap implemented with 0 index as starting index
public class MinHeap<T> {

    private T[] pq;
    private int heapSize;
    private Comparator<T> comparator;

    public MinHeap(int n) {
        this.heapSize = 0;
        this.pq = (T[])new Object[n];
    }

    public MinHeap(){
        this(1);
    }

    public MinHeap(int n, Comparator<T> comparator) {
        this.heapSize = 0;
        this.pq = (T[])new Object[n];
        this.comparator = comparator;
    }

    public void insert(T key){

        if (heapSize == pq.length-1)
            resize(2*pq.length);

        pq[heapSize++] = key;
        swim(heapSize-1);
    }

    private void resize(int n) {
        T temp [] = (T[])new Object[n];
        for(int i=0; i < heapSize; ++i)
            temp[i] = pq[i];
        pq = temp;
    }

    private void swim(int k) {
        while(k > 0 && more(k/2, k)){
            exch(k,k/2);
            k=k/2;
        }
    }

    private void exch(int i, int j) {
        T temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private boolean more(int i, int j) {
        if (comparator == null){
            return ((Comparable<T>)pq[i]).compareTo(pq[j]) > 0;
        } else {
            return comparator.compare(pq[i], pq[j]) > 0;
        }
    }

    public T min(){
        return pq[0];
    }

    public T delMin(){
        T min = pq[0];
        exch(0, --heapSize);
        sink(0);
        pq[heapSize] = null;
        return min;
    }

    private void sink(int k) {
        while(2*k +1 < heapSize){
            int j = 2*k +1;
            if (j < heapSize && j +1 < heapSize && more(j, j+1))
                ++j;
            if (!more(k, j))
                break;
            exch(k,j);
            k=j;
        }
    }

    public boolean isEmpty(){
        return heapSize ==0;
    }

    public int size(){
        return heapSize;
    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap(6);
        heap.insert(5);
        heap.insert(8);
        heap.insert(9);
        heap.insert(4);
        heap.insert(6);
        heap.insert(3);
        heap.insert(2);
        while (!heap.isEmpty()) {
            System.out.println(heap.delMin());
        }
    }
}

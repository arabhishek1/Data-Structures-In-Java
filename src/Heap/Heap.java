package Heap;

/**
 * Created by abhishek.ar on 22/07/17.
 */
public class Heap {

    private int[] pq;
    private int heapSize;

    public Heap(int n) {
        pq = new int[n + 1];
        heapSize = 0;
    }

    public void insert(int key){
        if (heapSize == pq.length -1)
            resize(2*pq.length);

        pq[++heapSize] = key;
        swim(heapSize);
    }

    private void resize(int n) {
        int [] temp = new int[n];
        for(int i=1; i <=heapSize ; ++i){
            temp[i] = pq[i];
        }
        pq = temp;
    }

    private void swim(int k) {
        while(k > 1 && less(k/2, k)){
            exch(k, k/2);
            k = k/2;
        }
    }

    private void exch(int a, int b) {
        int temp = pq[a];
        pq[a] = pq[b];
        pq[b] = temp;
    }

    private boolean less(int i, int j) {
        return pq[i] < pq[j];
    }

    public int max(){
        return pq[1];
    }

    public int delMax(){
        int max = pq[1];
        exch(1, heapSize--);
        sink(1);
        return max;
    }

    private void sink(int k) {
        while(2*k <= heapSize){
            int j= 2*k;
            if (j < heapSize && less(j, j+1))
                ++j;
            if (!less(k, j))
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
        Heap heap = new Heap(6);
        heap.insert(5);
        heap.insert(8);
        heap.insert(9);
        heap.insert(4);
        heap.insert(6);
        heap.insert(3);
        heap.insert(2);
        while(!heap.isEmpty()){
            System.out.println(heap.delMax());
            System.out.println(heap.max());
        }
    }
}

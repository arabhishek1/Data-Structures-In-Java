package Heap;

/**
 * Created by abhishek.ar on 25/07/17.
 *Given an input stream of n integers the task is to insert integers to stream and print the median of the new stream
 formed by each insertion of x to the stream.

 Example

 Flow in stream : 5, 15, 1, 3
 5 goes to stream --> median 5 (5)
 15 goes to stream --> median 10 (5, 15)
 1 goes to stream --> median 5 (5, 15, 1)
 3 goes to stream --> median 4 (5, 15, 1, 3)

 */
public class MedianInStream {

    public static int getMedian(int [] arr){
        int median =0;
        Heap lHeap = new Heap();
        MinHeap<Integer> rHeap = new MinHeap<Integer>();
        for(int i=0; i < arr.length; ++i){
            median = getMedianUtil(arr[i], median, lHeap, rHeap);
            System.out.println(median);
        }
        return median;
    }

    private static int getMedianUtil(int element, int median, Heap lHeap, MinHeap rHeap) {
        if (lHeap.size() == rHeap.size()){
            if (element < median){
                lHeap.insert(element);
                median = lHeap.max();
            } else {
                rHeap.insert(element);
                median = (int) rHeap.min();
            }
        } else  if (lHeap.size() > rHeap.size()){
            if (element < median){
                rHeap.insert(lHeap.delMax());
                lHeap.insert(element);
            } else {
                rHeap.insert(element);
            }
            median = (lHeap.max() + (Integer) rHeap.min())/2;
        } else {
            if (element < median){
                lHeap.insert(element);
            } else {
                lHeap.insert((Integer) rHeap.delMin());
                rHeap.insert(element);
            }
            median = (lHeap.max() + (Integer) rHeap.min())/2;
        }
        return median;
    }

    public static void main(String[] args) {
        int A[] = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};
        getMedian(A);
    }

}

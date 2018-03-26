package Amazon.FullPrograms;

import Heap.MinHeap;

/**
 * Created by abhishek.ar on 26/03/18.
 There are given n ropes of different lengths, we need to connect these ropes into one rope.
 The cost to connect two ropes is equal to sum of their lengths. We need to connect the ropes with minimum cost.

 Input:
 1
 4
 4 3 2 6

 Output:
 29

 Explanation:

 For example if we are given 4 ropes of lengths 4, 3, 2 and 6. We can connect the ropes in following ways.
 1) First connect ropes of lengths 2 and 3. Now we have three ropes of lengths 4, 6 and 5.
 2) Now connect ropes of lengths 4 and 5. Now we have two ropes of lengths 6 and 9.
 3) Finally connect the two ropes and all ropes have connected.
 */
public class MinCostRopes {

    public static int minCostRope(int arr[]){
        MinHeap<Integer> heap = new MinHeap();
        for(int i=0 ; i< arr.length; ++i)
            heap.insert(arr[i]);

        int sum = 0;
        while(heap.size() > 1){
            int nextElement = heap.delMin() + heap.delMin();
            sum += nextElement;
            heap.insert(nextElement);
        }
        return sum;
    }

    public static void main(String[] args) {
        int arr[] = {4,3,2,6};
        System.out.println(minCostRope(arr));
    }
}

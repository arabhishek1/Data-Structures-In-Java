package Heap;

import java.util.Comparator;

/**
 * Created by abhishek.ar on 26/07/17.
 Kth element in Matrix (Function Program)

 Given an n x n matrix, where every row and column is sorted in non-decreasing order.
 Find the kth smallest element in the given 2D array.Your task is to complete the function kthSmallest which
 takes two arguments the first is a matrix (mat) and sec argument is the order of the matrix (n) and the function
 returns the kth smallest element in the matrix.

 For example, consider the following 2D array.
 10, 20, 30, 40
 15, 25, 35, 45
 24, 29, 37, 48
 32, 33, 39, 50
 The 3rd smallest element is 20 and 7th smallest element is 30
 */

class HeapNode{
    int element;
    int row;
    int col;

    public HeapNode(int element, int row, int col) {
        this.element = element;
        this.row = row;
        this.col = col;
    }
}

class MatrixComparator implements Comparator<HeapNode> {
    @Override
    public int compare(HeapNode o1, HeapNode o2){
        if (o1.element == o2.element)
            return 0;
        else  if (o1.element > o2.element)
            return 1;
        else
            return -1;
    }
}

public class KthElementInSortedMatrix {

    public static int kthElementInMatrx(int arr[][], int k){
        if (k >0) {
            MinHeap<HeapNode> minHeap = new MinHeap<HeapNode>(arr.length, new MatrixComparator());
            for (int i = 0; i < arr[0].length; ++i) {
                minHeap.insert(new HeapNode(arr[0][i], 0, i));
            }

            HeapNode root = null;
            for(int i=0; i < k; ++i){
                root = minHeap.delMin();
                int element = root.row < arr.length ? arr[root.row + 1][root.col] : Integer.MAX_VALUE;
                minHeap.insert(new HeapNode(element, root.row +1 , root.col));
            }
            return root.element;
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[][] = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {24, 29, 37, 48},
                {32, 33, 39, 50}
        };
        System.out.println(kthElementInMatrx(arr, 3));
    }
}

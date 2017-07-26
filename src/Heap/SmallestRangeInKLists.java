package Heap;

import java.util.Comparator;

/**
 * Created by abhishek.ar on 26/07/17.
 Given K sorted lists of integers of size N each, find the smallest range that includes at least one element from each of the K lists. If more than one such range's are found, print the first such range found.

 Input:
 K = 3
 A[] : [4, 7, 9, 12, 15]
 B[] : [0, 8, 10, 14, 20]
 C[] : [6, 12, 16, 30, 50]

 Output:
 The smallest range is [6 8]
 Explanation: Smallest range is formed by number 7
 from first list, 8 from second list and 6 from third list.
 */
class SmallestRangeNode{
    int element;
    int listIndex;
    int nextEleIndex;

    public SmallestRangeNode(int element, int listIndex, int nextEleIndex) {
        this.element = element;
        this.listIndex = listIndex;
        this.nextEleIndex = nextEleIndex;
    }
}

class SmallRangeNodeComparator implements Comparator<SmallestRangeNode> {


    @Override
    public int compare(SmallestRangeNode o1, SmallestRangeNode o2) {
        if (o1.element == o2.element)
            return 0;
        else if (o1.element > o2.element)
            return 1;
        else
            return -1;
    }
}

public class SmallestRangeInKLists {

    public static void smallestRangeInKLists(int arr[][]){
        MinHeap<SmallestRangeNode> minHeap = new MinHeap<SmallestRangeNode>(arr.length, new SmallRangeNodeComparator());
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, range = Integer.MAX_VALUE, start=0, end=0;
        for(int i=0; i < arr.length; ++i){
            int element = arr[i][0];
            if (element > max)
                max = element;
            minHeap.insert(new SmallestRangeNode(element, i, 1));

        }

        while(true){
            SmallestRangeNode minNode = minHeap.delMin();

            min = minNode.element; //min signifies minimum element in heap, not min element passed till now

            if (range > max - min) {
                range = max - min;
                start = min;
                end = max;
            }

            if (minNode.nextEleIndex < arr[minNode.listIndex].length) {
                minHeap.insert(new SmallestRangeNode(arr[minNode.listIndex][minNode.nextEleIndex],
                        minNode.listIndex, minNode.nextEleIndex + 1));
                if (arr[minNode.listIndex][minNode.nextEleIndex] > max)
                    max = arr[minNode.listIndex][minNode.nextEleIndex];
            }
            else
                break;
        }

        System.out.println("The smallest range is [" + start + " " +end + "]") ;

    }

    public static void main(String[] args) {
     int arr[][] = {
             {4, 7, 9, 12, 15},
             {0, 8, 10, 14, 20},
             {6, 12, 16, 30, 50}};
     smallestRangeInKLists(arr);

    }
}

package Heap;

/**
 * Created by abhishek.ar on 26/07/17.
 Given k sorted arrays of size n each, merge them and print the sorted output
 Input:
 k = 3, n =  4

 arr[][] = { {1, 3, 5, 7},
            {2, 4, 6, 8},
            {0, 9, 10, 11}} ;

 Output: 0 1 2 3 4 5 6 7 8 9 10 11
 */
public class MergeKSortedLists {

    public static int[] mergeKSortedLists(int arr[][]){
        int result[] = new int[arr.length*arr[0].length];

        MinHeap<SmallestRangeNode> minHeap = new MinHeap<SmallestRangeNode>(arr.length, new SmallRangeNodeComparator());
        for(int i=0; i < arr.length; ++i){
            minHeap.insert(new SmallestRangeNode(arr[i][0], i, 1));
        }

        for(int i=0; i <result.length; ++i){
            SmallestRangeNode node = minHeap.delMin();
            result[i] = node.element;

            if (node.nextEleIndex < arr[node.listIndex].length){
                minHeap.insert(new SmallestRangeNode(arr[node.listIndex][node.nextEleIndex], node.listIndex, 1+node.nextEleIndex));
            }

        }

        return result;
    }

    public static void main(String[] args) {
        int  arr[][] = { {1, 3, 5, 7},
                {2, 4, 6, 8},
                {0, 9, 10, 11}} ;
        int result [] = mergeKSortedLists(arr);
        for(int i=0; i < result.length; ++i)
            System.out.print(result[i] + " ");
    }
}

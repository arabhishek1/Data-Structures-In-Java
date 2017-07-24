package Heap;

import java.util.Comparator;

/**
 * Created by abhishek.ar on 24/07/17.
 Given An array of Alphabets and their frequency. Your task is to print all the given alphabets Huffman Encoding.
 Note: If two elements have same frequency, then the element which if at first will be taken on left
 of Binary Tree and other one to right.
 */

class HuffManNode{
    char key;
    int frequency;
    HuffManNode left;
    HuffManNode right;

    public HuffManNode(char key, int frequency) {
        this.frequency = frequency;
        this.key = key;
        this.left = null;
        this.right = null;
    }
}

class HuffManComparator implements Comparator<HuffManNode>{

    @Override
    public int compare(HuffManNode o1, HuffManNode o2) {
        if (o1.frequency == o2.frequency)
            return 0;
        else if (o1.frequency > o2. frequency)
            return 1;
        else
            return -1;
    }
}

public class HuffmanCoding {

    public HuffmanCoding(char data[], int [] frquency, int size) {
        HuffManComparator comparator = new HuffManComparator();
        MinHeap<HuffManNode> minHeap = new MinHeap<HuffManNode>(size, comparator);
        for(int i=0; i < size ; ++i)
            minHeap.insert(new HuffManNode(data[i], frquency[i]));
        HuffManNode root = buildHuffmanTree(minHeap);
        int arr[] = new int[size];
        printCodes(root,arr,0);
    }

    private void printCodes(HuffManNode root, int[] arr, int top) {
        if (root.left != null){
            arr[top] =0;
            printCodes(root.left, arr, top+1);
        }

        if (root.right != null){
            arr[top] =1;
            printCodes(root.right, arr, top+1);
        }

        if (root.right == null && root.left == null){
            System.out.print(root.key + " : ");
            for(int i=0; i < top; ++i)
                System.out.print(arr[i]);
            System.out.println();
        }
    }

    private HuffManNode buildHuffmanTree(MinHeap<HuffManNode> minHeap) {
        while(minHeap.size() != 1){
            HuffManNode left = minHeap.delMin();
            HuffManNode right = minHeap.delMin();

            HuffManNode node = new HuffManNode('$', left.frequency+ right.frequency);
            node.left = left;
            node.right = right;
            minHeap.insert(node);
        }
        return minHeap.delMin();
    }

    public static void main(String[] args) {
        char arr[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        int freq[] = {5, 9, 12, 13, 16, 45, 12};
        HuffmanCoding huffmanCoding = new HuffmanCoding(arr, freq, arr.length);
    }
}

package Heap;

/**
 * Created by abhishek.ar on 23/07/17.
 */
public class HeapSort {

    public static void sink(int arr[], int k, int n){
        //In a normal PQ, L = 2*k && R = 2*k +1 but since we are using the normal array where index starts from 0,
        // The formaula for L and R changes to , L= 2*k +1 and R = 2*k +2
        int j = 2*k+1;
        while(j < n){
            if (j < n && j+1 < n && less(arr,j,j+1)){
                ++j;
            }
            if (!less(arr,k, j))
                break;
            exch(arr, k,j);
            k=j;
        }
    }

    private static boolean less(int[] arr, int i, int j) {
        return arr[i] < arr[j];
    }

    private static void exch(int arr[], int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void heapSort(int arr[]){
        //build the heap
        for(int j=arr.length/2-1; j >= 0; --j){
            sink(arr, j, arr.length);
        }

        //move the max element to end of array and maintain the order of heap till he end.
        for(int j=arr.length-1; j>=0;  --j){
            exch(arr, 0, j);
            sink(arr, 0, j);// sink will happen from 0 to j-1 as j is the max length.
        }

        for(int i=0; i < arr.length; ++i)
            System.out.println(arr[i]);
    }

    public static void main(String[] args) {
        int arr[] = {5,8,9,4,2,3,1};
        heapSort(arr);
    }
}

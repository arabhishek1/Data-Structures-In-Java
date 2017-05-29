package Amazon.FullPrograms;

/**
 * Created by abhishek.ar on 27/05/17.
 Given 2 sorted arrays A and B of size N each. Print sum of middle elements of the array obtained
 after merging the given arrays(deviation of median problem).

 */
public class SumOfMiddleElements {

    /*
    * Use merge procedure of merge sort. Keep track of count while comparing elements of two arrays.
    * If count becomes n(For 2n elements), we have reached the median. Take the average of the elements
    * at indexes n-1 and n in the merged array. See the below implementation.
    */
    public static int getMedian(int arr1[], int arr2[]){
        int median1 = -1, median2 = -1, i=0,j=0, count;
        for(count =0; count <= arr1.length; ++count ){
            if (i == arr1.length){
                median1 = median2;
                median2 = arr2[0];
                break;
            }
            else if (j == arr1.length){
                median1 = median2;
                median2 = arr1[0];
                break;
            }
            if (arr1[i] < arr2[j]){
                median1 = median2;
                median2 = arr1[i];
                ++i;
            } else {
                median1 = median2;
                median2 = arr2[j];
                ++j;
            }
        }
        return median1 + median2;
    }

    //need to fix this, array boundaries are not proper, logic is correct
    public static int getMedianOptimized(int arr1[], int arr2[],int start1 , int end1, int start2, int end2){
        int median1 = getMedian(arr1, start1, end1);
        int median2 = getMedian(arr2, start2, end2);

        if (end1 <= 0 && end2 <=0)
            return -1;
        if (end1 == 1 && end2 == 1)
            return (arr1[0] + arr2[0]);

        if (end2 == 2 && end1 == 2)
            return (Math.max(arr1[0], arr2[0]) + Math.min(arr1[1], arr2[1])) ;
        if(median1 == median2)
            return median1+median2;
        if (median1 > median2){
            if (end1%2 == 0){
                return getMedianOptimized(arr1, arr2, start1, end1/2-1 ,end2/2+1, end2);
            }
            return getMedianOptimized(arr1, arr2, start1, end1/2, end2/2+1, end2);
        } else {
            if (end2%2 == 0){
                return getMedianOptimized(arr1, arr2, end1/2-1, end1, start2, end2/2-1);
            }
            return getMedianOptimized(arr1, arr2, end1/2+1, end1, start2, end2/2+1);
        }


    }

    private static int getMedian(int[] arr1, int start,int end) {
        if ((end-start)%2 == 0)
            return (arr1[(start+end)/2] + arr1[(start+end)/2 -1])/2;
        else
            return arr1[(start+end)/2];
    }

    public static void main(String [] args){
        int arr1[] = {1, 12, 15, 26, 38};
        int arr2[] = {2, 13, 17, 30, 45};
        System.out.println(getMedian(arr1, arr2));
        System.out.println(getMedianOptimized(arr1, arr2, 0, arr1.length, 0, arr2.length));
    }
}

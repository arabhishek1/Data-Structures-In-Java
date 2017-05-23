package Amazon.FullPrograms;

/**
 * Created by abhishek.ar on 23/05/17.
 */
public class KadaneAlgorithm {

    public static int largestContiguousSubArrayWithKadaneAlgorithm(int arr[]){
        int currSum = 0;
        int finalSum = Integer.MIN_VALUE;
        for(int i=0; i < arr.length; ++i){
            currSum += arr[i];
            if (currSum > finalSum){
                finalSum = currSum;
            } else if (currSum < 0){
                currSum = 0;
            }
        }
        return finalSum;
    }

    public static void main(String [] args){
        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(largestContiguousSubArrayWithKadaneAlgorithm(arr));
    }
}


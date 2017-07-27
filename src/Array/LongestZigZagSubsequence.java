package Array;

/**
 * Created by abhishek.ar on 27/07/17.

 The longest Zig-Zag subsequence problem is to find the length of the longest subsequence of given sequence
 such that all elements of this are alternating. If a sequence {x1, x2, .. xn} is alternating sequence then its
 element satisfy one of the following relation:
 */
public class LongestZigZagSubsequence {

    public static int longestZigZagSequenceRec(int arr[], int end, boolean flag){
        if (end <= 0)
            return 0;
        if (end ==1)
            return 1;
        if (end ==2)
            return 2;
        int curr = arr[end -2];
        int next = arr[end -1];
        int prev = arr[end -3];

        if (flag && curr > next && curr > prev)
            return 1 + longestZigZagSequenceRec(arr, end-1, !flag);
        else  if (!flag && curr < next && curr < prev)
            return 1 + longestZigZagSequenceRec(arr, end -1, !flag);
        else
            return longestZigZagSequenceRec(arr, end -1, flag);
    }

    public static int longestZigZag(int arr[]){
        if (arr.length > 2){
            int count=2; //as arr of length 2 is always zigzag by defintion.
            boolean flag = getFlagIter(arr);
            for(int i=1; i < arr.length-1; ++i){
                int curr = arr[i];
                int prev = arr[i-1];
                int next = arr[i +1];


                if (flag && curr > next && curr > prev){
                    ++count;
                    flag = !flag;
                } else if (!flag && curr < next && curr < prev){
                    ++count;
                    flag = !flag;
                } else {

                }
            }
            return count;
        } else
            return arr.length;
    }

    private static boolean getFlagIter(int[] arr) {
        int curr = arr[1];
        int prev = arr[0];
        int next = arr[2];
        if (curr < next && curr < prev)
            return false;
        else
            return true;
    }

    public static void main(String[] args) {
        int arr[] = {10, 22, 9, 33, 49, 50, 31, 60};
        if (arr.length > 2) {
            System.out.println(longestZigZagSequenceRec(arr, arr.length, getFlag(arr)));
        } else {
            System.out.println(arr.length);
        }

        System.out.println(longestZigZag(arr));
    }

    private static boolean getFlag(int[] arr) {
        int end = arr.length;
        int curr = arr[end - 2];
        int next = arr[end - 1];
        int prev = arr[end - 3];
        if (curr < next && curr < prev)
            return false;
        else
            return true;

    }
}

package Array;

/**
 * Created by abhishek.ar on 31/07/17.
 Given a number, find the next smallest palindrome larger than this number. For example, if the input number is “2 3 5 4 5”,
 the output should be “2 3 6 3 2”. And if the input number is “9 9 9”, the output should be “1 0 0 1”.

 The input is assumed to be an array. Every entry in array represents a digit in input number. Let the array be ‘num[]’
 and size of array be ‘n’



 There can be three different types of inputs that need to be handled separately.
 1) The input number is palindrome and has all 9s. For example “9 9 9”. Output should be “1 0 0 1”
 2) The input number is not palindrome. For example “1 2 3 4”. Output should be “1 3 3 1”
 3) The input number is palindrome and doesn’t have all 9s. For example “1 2 2 1”. Output should be “1 3 3 1”.


 */
public class NextPalindrome {

    public static void nextPalindrome(int arr[]){
        int mid = arr.length/2;

        int i = mid -1;
        int j = (mid%2 ==0) ? mid : mid +1;

        boolean isLeftSmaller = false;

        while (i>=0 && arr[i] == arr[j])
            ++i; --j;
        if (i <0 || arr[i] < arr[j])
            isLeftSmaller = true;

        while (i >=0){
            arr[j++] = arr[i--];
        }

        if (isLeftSmaller){
            int carry = 1;
            i = mid -1;

            if (arr.length%2 ==1){
                arr[mid] += carry;
                carry = arr[mid]/10;
                arr[mid] %= carry;
                j = mid +1;
            } else
                j = mid;
            while (i >= 0)
            {
                arr[i] += carry;
                carry = arr[i] / 10;
                arr[i] %= 10;
                arr[j++] = arr[i--]; // copy mirror to right
            }

        }

    }
}

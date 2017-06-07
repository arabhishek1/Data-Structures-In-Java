package Amazon.FullPrograms;

/**
 * Created by abhishek.ar on 02/06/17.
 * Rotate Array by n elements
 */
public class RotateArray {

    public static void rotateUsingTemp(int arr[], int d) {
        int[] temp = new int[d];
        for (int i = 0; i < d; ++i)
            temp[i] = arr[i];

        for (int i = 0; i < arr.length - d; ++i)
            arr[i] = arr[i + d];

        for (int i = arr.length - d, j = 0; i < arr.length; ++i, ++j)
            arr[i] = temp[j];
    }
/*
* This is an extension of method 2. Instead of moving one by one, divide the array in different sets
where number of sets is equal to GCD of n and d and move the elements within sets.
If GCD is 1 as is for the above example array (n = 7 and d =2), then elements will be moved within one set only,
we just start with temp = arr[0] and keep moving arr[I+d] to arr[I] and finally store temp at the right place.

Here is an example for n =12 and d = 3. GCD is 3
Let arr[] be {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}

a)	Elements are first moved in first set –

ArrayRotation

          arr[] after this step --> {4 2 3 7 5 6 10 8 9 1 11 12}

b)	Then in second set.
          arr[] after this step --> {4 5 3 7 8 6 10 11 9 1 2 12}

c)	Finally in third set.
          arr[] after this step --> {4 5 6 7 8 9 10 11 12 1 2 3}

*/


    public static void JuggilingAlgorithmForRotateAntiClockwise(int arr[], int d) {
        for (int i = 0; i < gcd(arr.length, d); ++i) {
            int temp = arr[i], j = i, k;
            while (true) {
                k = j + d;
                if (k >= arr.length) {
                    k -= arr.length;
                }
                if (k == i)
                    break;

                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
    }

    private static int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
/*
    * Please read this for first three methods of array rotation.

    Algorithm:

    rotate(arr[], d, n)
    reverse(arr[], 1, d) ;
    reverse(arr[], d + 1, n);
    reverse(arr[], l, n);
    Let AB are the two parts of the input array where A = arr[0..d-1] and B = arr[d..n-1]. The idea of the algorithm is:
    Reverse A to get ArB.  Ar is reverse of A
    Reverse B to get ArBr. Br is reverse of B
    Reverse all to get (ArBr) r = BA.

    For arr[] = [1, 2, 3, 4, 5, 6, 7], d =2 and n = 7
    A = [1, 2] and B = [3, 4, 5, 6, 7]
    Reverse A, we get ArB = [2, 1, 3, 4, 5, 6, 7]
    Reverse B, we get ArBr = [2, 1, 7, 6, 5, 4, 3]
    Reverse all, we get (ArBr)r = [3, 4, 5, 6, 7, 1, 2]
*/
    public static void rotateUsingReverseAlgorithmAntiClockwise(int arr[], int d){
        reverse(arr, 0, d-1);
        reverse(arr, d, arr.length-1);
        reverse(arr, 0, arr.length-1);
    }

    public static void rotateUsingReverseAlgorithmClockwise(int arr[], int d){
        reverse(arr, 0, arr.length-1 -d);
        reverse(arr, arr.length-d, arr.length-1);
        reverse(arr, 0, arr.length-1);
    }

    private static void reverse(int arr[], int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
//        JuggilingAlgorithmForRotateAntiClockwise(arr, 3);
        rotateUsingReverseAlgorithmAntiClockwise(arr, 1);
//        rotateUsingReverseAlgorithmClockwise(arr, 1);
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
    }
}

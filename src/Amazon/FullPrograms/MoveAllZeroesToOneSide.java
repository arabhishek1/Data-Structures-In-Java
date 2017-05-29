package Amazon.FullPrograms;

/**
 * Created by abhishek.ar on 29/05/17.
 * Move all zeroes to end of array
 * <p>
 * Given an array of random numbers, Push all the zero’s of a given array to the end of the array. For example,
 * if the given arrays is {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0}, it should be changed to {1, 9, 8, 4, 2, 7, 6, 0, 0, 0, 0}.
 */
public class MoveAllZeroesToOneSide {

    public static void moveAllZeroesToOneSide(int arr[]) {
        int count = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] != 0) {
                arr[count++] = arr[i];
            }
        }
        while (count < arr.length) {
            arr[count++] = 0;
        }

    }

    public static void main(String[] args) {
        int arr[] = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0};
        moveAllZeroesToOneSide(arr);
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
    }
}

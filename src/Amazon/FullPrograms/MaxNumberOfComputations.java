package Amazon.FullPrograms;

public class MaxNumberOfComputations {
    private static int[][] memoryLookup = new int[2][1000];

    public static void main(String args[]) throws Exception {
        int arr1[] = {10, 1, 5, 10};
        int arr2[] = {5, 2, 3, 15};
        System.out.println(maxNumberOfComputations(arr1, arr2, arr1.length, 0, arr1, true));
    }

    public static int maxNumberOfComputations(int arr1[], int arr2[], int length, int value, int[] arr, boolean flag) {

        if (length == 0)
            return value;

        int withFlag = Math.max(maxNumberOfComputations(arr1, arr2, length - 1, arr[length - 1] + value, arr1, true),
                maxNumberOfComputations(arr1, arr2, length - 1, arr[length - 1] + value, arr2, false));

        int withoutFlag = Math.max(maxNumberOfComputations(arr1, arr2, length - 1, value, arr2, true),
                maxNumberOfComputations(arr1, arr2, length - 1, value, arr1, false));

        return Math.max(withFlag, withoutFlag);

    }

    public static int maxNumberOfComputationsDP(int arr1[], int arr2[], int length, int arr[], boolean flag) {

        if (memoryLookup[0][length] == 0 && memoryLookup[1][length] == 0) {
            if (length == 0)
                return 0;
            if (flag) {
                memoryLookup[0][length] = arr[length - 1] + Math.max(maxNumberOfComputationsDP(arr1, arr2, length - 1, arr1, true),
                        maxNumberOfComputationsDP(arr1, arr2, length - 1, arr2, false));
                return memoryLookup[0][length];

            } else {
                memoryLookup[1][length] = Math.max(maxNumberOfComputationsDP(arr1, arr2, length - 1, arr1, true),
                        maxNumberOfComputationsDP(arr1, arr2, length - 1, arr2, false));
                return memoryLookup[1][length];
            }
        } else {
            if (flag) {
                return memoryLookup[0][length];
            } else {
                return memoryLookup[1][length];
            }
        }

    }
}

package Amazon.FullPrograms;

/**
 * Created by abhishek.ar on 26/02/18.
 * Rahul && len1nkit are the only two waiters in Royal Restaurant. Today, the restaurant received N orders.
 * The amount of tips may differ when h&&led by different waiters, if Rahul takes the ith order, he would be tipped len1i
 * rupees && if len1nkit takes this order, the tip would be len2i rupees.
 * <p>
 * In order to maximize the total tip value they decided to distribute the order among themselves. One order will be
 * h&&led by one person only. len1lso, due to time constraints Rahul cannot take more than arr1 orders && len1nkit cannot take
 * more than arr2 orders. It is guaranteed that arr1 + arr2 is greater than or equal to N, which means that all the orders
 * can be h&&led by either Rahul or len1nkit. Find out the maximum possible amount of total tip money after processing all
 * the orders.
 * <p>
 * Input:
 * <p>
 * •    The first line contains one integer, number of test cases.
 * •    The second line contains three integers N, arr1, arr2.
 * •    The third line contains N integers. The ith integer represents len1i.
 * •    The fourth line contains N integers. The ith integer represents len2i.
 * <p>
 * <p>
 * <p>
 * Output:
 * Print a single integer representing the maximum tip money they would receive.
 * <p>
 * <p>
 * Constraints:
 * 1 ≤ N ≤ 105
 * 1 ≤ arr1, arr2 ≤ N; arr1 + arr2 ≥ N
 * 1 ≤ len1i, len2i ≤ 104
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input:
 * <p>
 * 2
 * 5 3 3
 * 1 2 3 4 5
 * 5 4 3 2 1
 * 8 4 4
 * 1 4 3 2 7 5 9 6
 * 1 2 3 6 5 4 9 8
 * <p>
 * <p>
 * Output:
 * <p>
 * 21
 * 43
 */
public class MaxTipCalculator {


    public static int maxTipCalculator(int arr1[], int len1, int arr2[], int len2, int noOfOrders, int iterator) {

        if (iterator == arr1.length || noOfOrders == 0)
            return 0;

        if (len1 == 0 && len2 > 0) {
            return Math.max(arr2[iterator] + maxTipCalculator(arr1, len1, arr2, len2 - 1, noOfOrders - 1, iterator + 1),
                    maxTipCalculator(arr1, len1, arr2, len2, noOfOrders, iterator + 1));
        } else if (len2 == 0 && len1 > 0) {
            return Math.max(arr1[iterator] + maxTipCalculator(arr1, len1 - 1, arr2, len2, noOfOrders - 1, iterator + 1),
                    maxTipCalculator(arr1, len1, arr2, len2, noOfOrders, iterator + 1));
        } else if (len1 == 0 && len2 == 0)
            return 0;

        else
            return Math.max(Math.max(arr1[iterator] + maxTipCalculator(arr1, len1 - 1, arr2, len2, noOfOrders - 1, iterator + 1),
                    arr2[iterator] + maxTipCalculator(arr1, len1, arr2, len2 - 1, noOfOrders - 1, iterator + 1)),
                    maxTipCalculator(arr1, len1, arr2, len2, noOfOrders, iterator + 1));
    }

    public static void main(String[] args) {
        int arr1[] = {1, 4, 3, 2, 7, 5, 9, 6};
        int arr2[] = {1, 2, 3, 6, 5, 4, 9, 8};
        int noOfOrders = 8;
        int X = 4;
        int Y = 4;

        System.out.println(maxTipCalculator(arr1, X, arr2, Y, noOfOrders, 0));
    }
}

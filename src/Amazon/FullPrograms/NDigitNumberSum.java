package Amazon.FullPrograms;

/**
 * Created by abhishek.ar on 26/05/17.
 Count of n digit numbers whose sum of digits equals to given sum
 Given two integers ‘n’ and ‘sum’, find count of all n digit numbers with sum of digits as ‘sum’.
 Leading 0’s are not counted as digits.
 1 <= n <= 100 and 1 <= sum <= 50000

 Example:

 Input:  n = 2, sum = 2
 Output: 2
 Explanation: Numbers are 11 and 20

 Input:  n = 2, sum = 5
 Output: 5
 Explanation: Numbers are 14, 23, 32, 41 and 50

 Input:  n = 3, sum = 6
 Output: 21
 */
public class NDigitNumberSum {
    private static int [][] memTable = new int[101][50001];
    // Recursive function to count 'n' digit numbers
    // with sum of digits as 'sum'. This function
    // considers leading 0's also as digits, that is
    // why not directly called
    public static int countNdigitNumberWhoseSum(int n, int sum){
        if ( n == 0)
            return (sum == 0) ? 1 : 0;
        int ans =0;


        // Traverse through every digit and count
        // numbers beginning with it using recursion
        for (int i=0; i <=9; ++i){
            if (sum-i >=0)
                ans += countNdigitNumberWhoseSum(n-1, sum-i);
        }
        return ans;
    }
    // This is mainly a wrapper over countRec. It
    // explicitly handles leading digit and calls
    // countRec() for remaining digits.
    public static int countNdigitNumberWhoseSumWrapper(int n, int sum){
        int ans = 0;
        // Traverse through every digit from 1 to
        // 9 and count numbers beginning with it
        for (int i=1; i <=9; ++i){
            if (sum-i >=0)
                ans += countNdigitNumberWhoseSum(n-1, sum-i);
        }
        return ans;

    }


    public static int countNdigitNumberWhoseSumDP(int n, int sum){
        if ( n == 0)
            return (sum == 0) ? 1 : 0;
        int ans =0;

        // If this subproblem is already evaluated,
        // return the evaluated value
        if (memTable[n][sum] != Integer.MIN_VALUE)
            return memTable[n][sum];

        // Traverse through every digit and count
        // numbers beginning with it using recursion
        for (int i=0; i <=9; ++i){
            if (sum-i >=0)
                ans += countNdigitNumberWhoseSumDP(n-1, sum-i);
        }
        return memTable[n][sum]= ans;
    }
    // This is mainly a wrapper over countRec. It
    // explicitly handles leading digit and calls
    // countRec() for remaining digits.
    public static int countNdigitNumberWhoseSumWrapperDP(int n, int sum){

        for(int i=0; i <=100; ++i){
            for(int j=0; j <=50000; ++j)
                memTable[i][j] = Integer.MIN_VALUE;
        }

        int ans = 0;
        // Traverse through every digit from 1 to
        // 9 and count numbers beginning with it
        for (int i=1; i <=9; ++i){
            if (sum-i >=0)
                ans += countNdigitNumberWhoseSumDP(n-1, sum-i);
        }
        return ans;

    }

    public static void main(String [] args){
        System.out.println(countNdigitNumberWhoseSumWrapper(2, 5));
        System.out.println(countNdigitNumberWhoseSumWrapperDP(2, 5));

    }

/*
    The idea is simple, we subtract all values from 0 to 9 from given sum and recur for sum minus that digit.
     Below is recursive formula.

    countRec(n, sum) = ∑countRec(n-1, sum-x)
                            where 0 =< x <= 9 and
                                 sum-x >= 0

    One important observation is, leading 0's must be
    handled explicitly as they are not counted as digits.
    So our final count can be written as below.
    finalCount(n, sum) = ∑countRec(n-1, sum-x)
                           where 1 =< x <= 9 and
                                 sum-x >= 0

 */
}

package Amazon.FullPrograms;

/**
 * Created by abhishek.ar on 25/05/17.
 * There are n stairs, a person standing at the bottom wants to reach the top. The person can climb
 * either 1 stair or 2 stairs at a time. Count the number of ways, the person can reach the top (order does matter).
 */
public class CountWaysToReachNthStair {


    public static int countWays(int n){
        if (n <=1)
            return 1;
        else
            return  countWays(n-1) + countWays(n-2);
    }

    /* extended for n=3
    public static int countWays(int n){
        if (n <=2)
            return 1;
        else
            return  1 + countWays(n-1) + countWays(n-2) + countWays(n-3);
    }*/



    //fibonacciDP
    public static int fib(int n) {
        /* Declare an array to store Fibonacci numbers. */
        int f[] = new int[n + 1];

    /* 0th and 1st number of the series are 0 and 1*/
        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i <= n; i++) {
       /* Add the previous 2 numbers in the series
         and store it */
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }

    /*
    * We can easily find recursive nature in above problem. The person can reach n’th stair from either (n-1)’th stair
    * or from (n-2)’th stair. Let the total number of ways to reach n’t stair be ‘ways(n)’. The value of ‘ways(n)’
    * can be written as following.

        ways(n) = ways(n-1) + ways(n-2)

    The above expression is actually the expression for Fibonacci numbers, but there is one thing to notice,
    the value of ways(n) is equal to fibonacci(n+1).

    ways(1) = fib(2) = 1
    ways(2) = fib(3) = 2
    ways(3) = fib(4) = 3
    */
//program to count number of ways to reach n't stair when
// a person can climb 1, 2, ..m stairs at a time
    public static int countWaysDP(int n, int m){
       int res[] = new int[n];
        res[0]=1; res[1] =1;
        for(int i=2; i < n; ++i){
            res[i] = 0;
            for(int j=1; j <=m && j <=i ; ++j){
                res[i] += res[i-j];
            }
        }
        return res[n-1];
    }

    public static void main(String[] args){
        System.out.println(countWays(4));
        System.out.println(countWaysDP(4 +1, 2));
    }
}

package Amazon.FullPrograms;

/**
 * Created by abhishek.ar on 11/06/17
 Given a positive integer n, find the number of non-negative integers less than or equal to n, whose binary
 representations do NOT contain consecutive ones.

 Example 1:
 Input: 5
 Output: 5
 Explanation:
 Here are the non-negative integers <= 5 with their corresponding binary representations:
 0 : 0
 1 : 1
 2 : 10
 3 : 11
 4 : 100
 5 : 101
 Among them, only integer 3 disobeys the rule (two consecutive ones) and the other 5 satisfy the rule.
 */
public class NonConsecutiveOnesInBinaryRep {

    public static int countNoOfConsecutiveOnesInBinaryRep(int n){
        int a[] = new int[n];
        int b[] = new int[n];
        a[0] = b[0] =1;
        for(int i=1 ; i < n; ++i){
            a[i] = a[i-1] + b[i-1];
            b[i] = a[i-1];
        }
        return a[n-1] + b[n-1];
    }

    public static void main(String[] args) {
        System.out.println(countNoOfConsecutiveOnesInBinaryRep(3));
    }
}

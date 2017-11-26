package DP;

/**
 * Created by abhishek.ar on 17/08/17.
 Count even length binary sequences with same sum of first and second half bits
 Given a number n, find count of all binary sequences of length 2n such that sum of first n bits is same as sum of
 last n bits.

 Examples:

 Input:  n = 1
 Output: 2
 There are 2 sequences of length 2*n, the
 sequences are 00 and 11

 Input:  n = 2
 Output: 2
 There are 6 sequences of length 2*n, the
 sequences are 0101, 0110, 1010, 1001, 0000
 and 1111
 */
public class BinarySequenceWithSameFirstAndLastSum {

    public static int binarySequenceWithSameSum(int n, int diff){

        if (Math.abs(diff) > n)
            return 0;

        if (n ==1 && diff == 0)
            return 2;
        if (n ==1 && Math.abs(diff) == 1)
            return 1;
        else
            return binarySequenceWithSameSum(n-1, diff-1) +
                    binarySequenceWithSameSum(n-1, diff + 1) +
                    (2 * binarySequenceWithSameSum(n-1, diff));
    }

    public static void main(String[] args) {
        System.out.println(binarySequenceWithSameSum(2, 0));
    }
}

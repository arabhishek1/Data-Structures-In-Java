package Array;

/**
 * Created by abhishek.ar on 30/07/17.
 You are given a binary string S. In a single operation, you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N and
 complement the characters between L and R i.e SL, SL+1, …, SR. By complement, we mean change character 0 to 1 and
 vice-versa.

 You task is to perform ATMOST one operation such that in final string number of 1s is maximised.
 If there is no need to completement, i.e., string contains all 1s, return -1. Else, return the two values denoting L
 and R. If there are multiple solutions,
 return the lexicographically smallest pair of L and R.

 Example:
 S = 010
 Pair of [L, R] | Final string
 [1 1] | 110
 [1 2] | 100
 [1 3] | 101
 [2 2] | 000
 [2 3] | 001
 We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return [1, 1].
 Another example,
 If S = 111
 No operation can give us more than three 1s in final string. So, we return empty array []
 */
public class ComplimentZeros {
    public static int[] maxCompliment(String str){
        int L=0;
        int R=0;
        int currentCount=0;
        int maxCount=0;
        int maxL=0;
        int maxR=0;
        for(int i=0; i <str.length();++i){
            if (str.charAt(i) == '0'){
                R=i;
                ++currentCount;
            } else {
                L= i+1;
                currentCount = 0;
            }
            if (currentCount > maxCount) {
                maxCount = currentCount;
                maxL = L;
                maxR = R;
            }
        }
        if (maxCount ==0)
           return new int[0];
        else {
            int arr[] = {maxL + 1, maxR + 1};
            return arr;
        }
    }

    public static void main(String[] args) {
        String str = "10101010001000001";
        int res[] = maxCompliment(str);
        for(int i=0 ; i< res.length; ++i)
            System.out.print(res[i] + " ");
    }
}

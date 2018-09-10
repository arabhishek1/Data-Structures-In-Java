package Array;

import java.util.HashMap;
import java.util.Map;

/*
* Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l)
* there are such that A[i] + B[j] + C[k] + D[l] is zero.

To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500.
All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.

Example:

Input:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]
Output: 2

Explanation: The two tuples are:

1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
*/
public class Sum4Arrays {

    /*The catch here is A +B + C+ D = 0
    If we just realign it reduces to A+B = -(C+D)
    Now we can create an hash to check The possible sums and since this reduces complexity from n^4 to n^2.
    * */
    public static int findNumberOfWaysSumIsZero(int A[], int B[], int C[], int D[], int N){
        Map<Integer, Integer> sumMapAB = new HashMap<>();
        Map<Integer, Integer> sumMapCD = new HashMap<>();

        for(int i =0; i < N ; ++i){
            for(int j=0; j < N ; ++j){
                int sumAB = A[i]+ B[j];
                int sumCD = C[i]+ D[j];
                addInMap(sumAB, sumMapAB);
                addInMap(sumCD, sumMapCD);
            }
        }

        int result = 0;
        for(Map.Entry<Integer, Integer> entry : sumMapAB.entrySet()){
            if (sumMapCD.containsKey(entry.getKey()*-1)){
                result += entry.getValue()* sumMapAB.get(entry.getKey()*-1);
            }
        }
        return result;
    }

    private static void addInMap(int sum, Map<Integer, Integer> map) {
        if (map.containsKey(sum)){
            map.put(sum, map.get(sum) +1);
        }  else {
            map.put(sum, 1);
        }
    }

    public static void main(String[] args) {

       int [] A = {1, 2};
       int [] B = {-2,-1};
       int [] C = {-1, 2};
       int [] D = { 0, 2};
        System.out.println(findNumberOfWaysSumIsZero(A, B, C, D, A.length));
    }
}

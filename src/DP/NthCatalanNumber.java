package DP;

/**
 * Created by abhishek.ar on 16/08/17.
 Catalan numbers are a sequence of natural numbers that occurs in many interesting counting problems like following.

 1) Count the number of expressions containing n pairs of parentheses which are correctly matched. For n = 3, possible
 expressions are ((())), ()(()), ()()(), (())(), (()()).

 2) Count the number of possible Binary Search Trees with n keys (See this)

 3) Count the number of full binary trees (A rooted binary tree is full if every vertex has either two children or no children) with n+1 leaves.

 See this for more applications.

 The first few Catalan numbers for n = 0, 1, 2, 3, … are 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, …

 Catalan No Formula:

 C0 = 1; CN+1 = Ci* CN-1 for(i=0 to n-1) for n >=0


 catalan No one more formula

 CN = BinomialCoefficient(2n, n)/N+1
 */

public class NthCatalanNumber {

    public static int binomialCoefficient(int n, int k){
        // Since C(n, k) = C(n, n-k)
        if (k > n-k){
            k = n-k;
        }

        int res =1;

        // Calculate value of [n*(n-1)*---*(n-k+1)] / [k*(k-1)*---*1]
        for(int i=0; i < k; ++i){
            res *= n-i;
            res /= i+1;
        }

        return res;
    }


    public static int nthCatalanNo(int n){
        return binomialCoefficient(2*n, n)/(n+1);
    }

    public static void main(String[] args) {
        for(int i=0; i < 10; ++i){
            System.out.println(nthCatalanNo(i));
        }
    }
}

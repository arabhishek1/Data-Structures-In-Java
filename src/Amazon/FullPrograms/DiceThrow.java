package Amazon.FullPrograms;

/**
 * Created by abhishek.ar on 01/06/17.
 Given n dice each with m faces, numbered from 1 to m, find the number of ways to get sum X.
 X is the summation of values on each face when all the dice are thrown.

 */
public class DiceThrow {

    public static int diceThrow(int M, int N, int X){
        int count =0;
        if (X == 0 )
            return 1;
        if (X < 0 ||  N < 0)
            return 0;
        for(int i=1; i <=M; ++i){
            count += diceThrow(i, N-1, X-i);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(diceThrow(4, 3, 5));
    }
}

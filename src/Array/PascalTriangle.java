package Array;

/**
 * Created by abhishek.ar on 30/07/17.
 Pascal’s triangle is a triangular array of the binomial coefficients. Write a function that takes an integer
 value n as input and prints first n lines of the Pascal’s triangle. Following are the first 6 rows of Pascal’s Triangle.

 1
 1 1
 1 2 1
 1 3 3 1
 1 4 6 4 1
 1 5 10 10 5 1
 */

public class PascalTriangle {

    public static void pascalTriangle(int n){
        int multiliper = 1;
        for(int i=0; i <n; ++i){
            int rowValue = (int) Math.pow(11, i);
//            int x,y;
//            while (true){
//                x= rowValue/multiliper;
//                y= rowValue%multiliper;
//
//                System.out.print(x + " ");
//                rowValue =y;
//                if (y<=0)
//                    break;;
//            }
//            System.out.println();
//            multiliper *=10;


            String str = String.valueOf(rowValue);
            for(int j=0; j < str.length(); ++j)
                System.out.print(str.charAt(j)+ " ");

            System.out.println();


        }
    }

    public static void main(String[] args) {
        pascalTriangle(5);
    }
}

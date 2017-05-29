package Amazon.FullPrograms;

/**
 * Created by abhishek.ar on 27/05/17.
 A magic number is defined as a number which can be expressed as a power of 5 or sum of unique powers of 5.
 First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….

 Write a function to find the nth Magic number.

 Example:

 Input: n = 2
 Output: 25

 Input: n = 5
 Output: 130
 */
public class MagicNumber {

    public static int magicNumber(int n){
        int magicNumber=0, pow=1;
        while(n >0){
            pow = pow*5;
            if ((n & 1) == 1){
                magicNumber +=pow;
            }
            n >>= 1 ;
        }
        return magicNumber;
    }

    public static void main(String [] args){
        System.out.println(magicNumber(3));
    }
}

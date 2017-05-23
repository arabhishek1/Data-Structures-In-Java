package Amazon.FullPrograms;

/**
 * Created by abhishek.ar on 23/05/17.
 *
 * Given a binary string, count number of substrings that start and end with 1. For example,
 * if the input string is “00100101”, then there are three substrings “1001”, “100101” and “101”.
 * */
public class BinaryString {
    public static int binarySubString(String str){
        int totalCount =0;
        for(int i=0; i < str.length(); ++i){
            if (str.charAt(i) == '1'){
                for(int j=i+1 ; j < str.length(); ++j){
                    if(str.charAt(j) == '1'){
                       ++totalCount;
                    }
                }
            }
        }
       return totalCount;
    }

/*
* Time Complexity of the above solution is O(n2). We can find count in O(n) using a single traversal of input string.
* Following are steps.
a) Count the number of 1’s. Let the count of 1’s be m.
b) Return m(m-1)/2
The idea is to count total number of possible pairs of 1’s.
* */

    public static int binaryStringPermComb(String str){
        int totalNoOf1s = 0;
        for(int i=0; i < str.length(); ++i){
            if (str.charAt(i) == '1'){
                totalNoOf1s +=1;
            }
        }
        return (totalNoOf1s* (totalNoOf1s-1))/2;
    }

    public static void main(String [] args){
        System.out.println(binaryStringPermComb("00100101"));
    }
}

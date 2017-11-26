package LeetCode.String;

import java.util.*;

/**
 * Created by abhishek.ar on 09/08/17
 You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of
 substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

 For example, given:
 s: "barfoothefoobarman"
 words: ["foo", "bar"]

 You should return the indices: [0,9].
 (order does not matter).
 */
public class SubStringwithConcatWords {

    public List<Integer> findSubString(String s, String [] words){

        List<Integer> indexes = new ArrayList<>();
        Set<String> set = new HashSet<>();
        int lSize =0, wSize=0;
        for(int i=0; i < words.length; ++i) {
            set.add(words[i]);
            wSize = words[i].length();
            lSize +=wSize;

        }

        return null;
    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
//        System.out.println("Enter N : ");
        int n=sc.nextInt();
//        System.out.print("Enter Symbol : ");

        char c = '*';

        for(int i=1; i < 2*n-1; ++i){
            for(int j=1; j <n-1; ++j){
                System.out.print(" ");
            }
            for(int j= 1; j < i && j < n/2; ++j){
                System.out.print(c);
            }
            System.out.println();
        }

//        for(int i=1;i<=2*n;i++)
//        {
//            for(int j=1;j<=n-i;j++)
//
//            {
//                System.out.print(" ");
//            }
//
////            for(int j=(i-1)/2;j>=0;j--)
////
////            {
////                System.out.print(c);
////            }
//            for(int j=1;j<=i/2;j++)
//
//            {
//                System.out.print(c);
//            }
//            System.out.println();
//
//        }
//
//        System.out.println("gslgf");
//        for(int i=n-1;i>0;i--)
//        {
//
//            for(int j=0;j<=(i-1)/2;j++)
//
//            {
//                System.out.print(c);
//            }
//            for(int j=1;j<=n-i;j++)
//
//            {
//                System.out.print(" ");
//            }
//            System.out.println();
//        }
//


    }
}

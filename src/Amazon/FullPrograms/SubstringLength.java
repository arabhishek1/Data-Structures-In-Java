package Amazon.FullPrograms;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by abhishek.ar on 26/11/17.
 Given a String ,
 Return the minimum length of substring where such length substrings are of only consonants.

 Example :

 String a = "bdkafdkalfd"


 */
public class SubstringLength {


    public static int minimumLength(String str){

        Set<Character> set = new HashSet<Character>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        if (isVowelPresent(str, set))
            return 1;
        else
            return str.length();
    }

    private static boolean isVowelPresent(String str, Set<Character> set) {
        for(int i=0; i < str.length(); ++i){
            if (set.contains(str.charAt(i)))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(minimumLength("sgksgjhfskgfa"));
    }
}

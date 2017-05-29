package Amazon.FullPrograms;

/**
 * Created by abhishek.ar on 29/05/17.
 Find if a given string can be represented from a substring by iterating the substring “n” times
 Given a string ‘str’, check if it can be constructed by taking a substring of it and appending multiple copies
 of the substring together.

 Examples:

 Input: str = "abcabcabc"
 Output: true
 The given string is 3 times repetition of "abc"

 Input: str = "abadabad"
 Output: true
 The given string is 2 times repetition of "abad"

 Input: str = "aabaabaabaab"
 Output: true
 The given string is 4 times repetition of "aab"

 Input: str = "abcdabc"
 Output: false
 */
public class StringFormationFromSubString {

    //Naive approach : Check for every substring that can be formed starting from i=0 to len/2.
    //Time complexity : O(n2) n -> len of string
    public static boolean canStringBeFormedFromSubString(String str){
        for(int i=0; i <str.length()/2; ++i){
            String subString = str.substring(0,i+1);
            String newString = "";
            while(newString.length() <= str.length()){
                newString += subString;
                if (!str.contains(newString))
                    break;
                if (newString.equalsIgnoreCase(str))
                    return true;
            }
        }
        return false;
    }

    /*
    Optimized Approach: Use Longest proper prefix which is also suffix method of KMP algo
    Time complexity: O(n)

    Let the given string be ‘str’ and length of given string be ‘n’.

    1) Find length of the longest proper prefix of ‘str’ which is also a suffix. Let the length of the longest
       proper prefix suffix be ‘len’. This can be computed in O(n) time using pre-processing step of KMP string
       matching algorithm.

    2) If value of ‘n – len’ divides n (or ‘n % (n-len)’ is 0), then return true, else return false.

    In case of ‘true’ , the substring ‘str[0..n-len-1]’ is the substring that repeats n/(n-len) times.
    Let us take few examples.

    Input: str = “ABCDABCD”, n = 8 (Number of characters in ‘str’)
    The value of len is 4 (“ABCD” is the longest substring which is both prefix and suffix)
    Since (n-len) divides n, the answer is true.

    Input: str = “ABCDABC”, n = 7 (Number of characters in ‘str’)
    The value of len is 3 (“ABC” is the longest substring which is both prefix and suffix)
    Since (n-len) doesn’t divides n, the answer is false.

    Input: str = “ABCABCABCABCABC”, n = 15 (Number of characters in ‘str’)
    The value of len is 12 (“ABCABCABCABC” is the longest substring which is both prefix and suffix)
    Since (n-len) divides n, the answer is true.


    */

    public static boolean canStringBeFormedFromSubStringOptimized(String str){
        int [] LPS = new int[str.length()];
        computeLPSArray(LPS, str);
        int length = LPS[LPS.length-1];
        if (length > 0)
            System.out.println(str.length()/(str.length()-length));
        return ( length > 0 &&
                (str.length() % (str.length() - length) ) == 0);
    }

    /*
    Preprocessing Algorithm:
    In the preprocessing part, we calculate values in lps[]. To do that, we keep track of the length of the longest
    prefix suffix value (we use len variable for this purpose) for the previous index. We initialize lps[0] and len as 0.
    If pat[len] and pat[i] match, we increment len by 1 and assign the incremented value to lps[i]. If pat[i] and
    pat[len] do not match and len is not 0, we update len to lps[len-1].
    See computeLPSArray () in the below code for details.

    Illustration of preprocessing (or construction of lps[])

    pat[] = "AAACAAAA"

    len = 0, i  = 0.
    lps[0] is always 0, we move
    to i = 1

    len = 0, i  = 1.
    Since pat[len] and pat[i] match, do len++,
    store it in lps[i] and do i++.
    len = 1, lps[1] = 1, i = 2

    len = 1, i  = 2.
    Since pat[len] and pat[i] match, do len++,
    store it in lps[i] and do i++.
    len = 2, lps[2] = 2, i = 3

    len = 2, i  = 3.
    Since pat[len] and pat[i] do not match, and len > 0,
    set len = lps[len-1] = lps[1] = 1

    len = 1, i  = 3.
    Since pat[len] and pat[i] do not match and len > 0,
    len = lps[len-1] = lps[0] = 0

    len = 0, i  = 3.
    Since pat[len] and pat[i] do not match and len = 0,
    Set lps[3] = 0 and i = 4.

    len = 0, i  = 4.
    Since pat[len] and pat[i] match, do len++,
    store it in lps[i] and do i++.
    len = 1, lps[4] = 1, i = 5

    len = 1, i  = 5.
    Since pat[len] and pat[i] match, do len++,
    store it in lps[i] and do i++.
    len = 2, lps[5] = 2, i = 6

    len = 2, i  = 6.
    Since pat[len] and pat[i] match, do len++,
    store it in lps[i] and do i++.
    len = 3, lps[6] = 3, i = 7

    len = 3, i  = 7.
    Since pat[len] and pat[i] do not match and len > 0,
    set len = lps[len-1] = lps[2] = 2

    len = 2, i  = 7.
    Since pat[len] and pat[i] match, do len++,
    store it in lps[i] and do i++.
    len = 3, lps[7] = 3, i = 8

    We stop here as we have constructed the whole lps[].
    */
    private static void computeLPSArray(int LPS[], String str){
        int len=0, i=1;
        LPS[len] = 0; // LPS[0] is always 0. As there will be no proper prefix for string of length 0;
        while( i < str.length()){
            if (str.charAt(len) == str.charAt(i)){
                LPS[i++] = ++len;
            } else{
                if (len!= 0){
                    len = LPS[len-1];
                } else{
                    LPS[i++] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        String str = "aabaabaabaab";
        System.out.println(canStringBeFormedFromSubString(str));
        System.out.println(canStringBeFormedFromSubStringOptimized(str));
    }
}

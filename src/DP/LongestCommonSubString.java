package DP;

/**
 * Created by abhishek.ar on 16/08/17.
 Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.

 Examples :

 Input : X = "GeeksforGeeks", y = "GeeksQuiz"
 Output : 5
 The longest common substring is "Geeks" and is of
 length 5.

 Input : X = "abcdxyz", y = "xyzabcd"
 Output : 4
 The longest common substring is "abcd" and is of
 length 4.

 Input : X = "zxabcdezy", y = "yzabcdezx"
 Output : 6
 The longest common substring is "abcdez" and is of
 length 6.
 */
public class LongestCommonSubString {

    public static int LCSubString(String str1, String str2, int len1, int len2){
        if (len1 <=0 || len2 <=0)
            return 0;

        if (str1.charAt(len1-1) == str2.charAt(len2-1))
            return 1 + LCSubString(str1, str2, len1-1, len2-1);
        else
            return Math.max(LCSubString(str1, str2, len1-1, len2), LCSubString(str1, str2, len1, len2-1));
    }

    public static int LCSubStringDP(String str1, String str2){
        int dp [][] = new int[str1.length()+1][str2.length()+1];
        int result = Integer.MIN_VALUE;
        for(int i=1; i < dp.length; ++i){
            for(int j=1; j < dp[0].length; ++j){
                if (str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    result = Math.max(dp[i][j], result);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s1= "abcdxyz";
        String s2 = "xyzabcd";
        System.out.println(LCSubString(s1, s2, s1.length(), s2.length()));
        System.out.println(LCSubStringDP(s1, s2 ));
    }
}

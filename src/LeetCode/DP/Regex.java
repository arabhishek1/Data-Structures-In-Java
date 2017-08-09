package LeetCode.DP;

/**
 * Created by abhishek.ar on 08/08/17.

 Implement regular expression matching with support for '.' and '*'.

 '.' Matches any single character.
 '*' Matches zero or more of the preceding element.
 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") ? false
 isMatch("aa","aa") ? true
 isMatch("aaa","aa") ? false
 isMatch("aa", "a*") ? true
 isMatch("aa", ".*") ? true
 isMatch("ab", ".*") ? true
 isMatch("aab", "c*a*b") ? true
 */
public class Regex {

    public static boolean isMatch(String str, String pattern){
        boolean[][] dp = new boolean[str.length()+1][pattern.length()+1];
        dp[0][0] = true;
        for (int i = 1; i < dp[0].length; i++) {
            if (pattern.charAt(i-1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }

        for(int i=1; i <=str.length(); ++i){
            for(int j=1; j <=pattern.length(); ++j){
                if (str.charAt(i-1) == pattern.charAt(j-1) || pattern.charAt(j-1) == '.'){
                    dp[i][j] = dp[i-1][j-1];
                } else if (pattern.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-2];
                    if (pattern.charAt(j-2) == '.' || str.charAt(i-1) == pattern.charAt(j-2))
                        dp[i][j] = dp[i][j] || dp[i-1][j];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[str.length()][pattern.length()];
    }

    public static void main(String[] args) {
        String str = "aab";
        String pattern = "c*a*b";
        System.out.println(isMatch(str, pattern));
    }
}

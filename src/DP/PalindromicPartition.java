package DP;

/**
 * Created by abhishek.ar on 17/08/17.
 * Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition is a
 * palindrome. For example, “aba|b|bbabb|a|b|aba” is a palindrome partitioning of “ababbbabbababa”. Determine the fewest
 * cuts needed for palindrome partitioning of a given string. For example, minimum 3 cuts are needed for “ababbbabbababa”.
 * The three cuts are “a|babbbab|b|ababa”. If a string is palindrome, then minimum 0 cuts are needed.
 * If a string of length n containing all different characters, then minimum n-1 cuts are needed.
 */
public class PalindromicPartition {

    public static int palindromicPartition(String str, int start, int end) {
        int res = Integer.MAX_VALUE;
        if (start >= end || isPalindrome(str, start, end))
            return 0;
        for (int k = start; k < end; ++k) {
            int cut = (palindromicPartition(str, start, k) + 1 + palindromicPartition(str, k + 1, end));
            if (cut < res) {
                res = cut;
            }
        }

        return res;
    }

    private static boolean isPalindrome(String str, int start, int end) {
        for (int i = start, j = end; i < j; ++i, --j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "ababbbabbababa";
        System.out.println(palindromicPartition(str, 0, str.length() - 1));
    }

}

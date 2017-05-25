package Amazon.FullPrograms;

/**
 * Created by abhishek.ar on 25/05/17.
 * Given two sequences, find the length of longest subsequence present in both of them.
 * Both the strings are of uppercase.
 */
public class LongestCommonSubsequence {

    //Recursive Approach
    public static int LCSRecursion(char[] str1, char[] str2, int length1, int length2){
        if (length1 == 0 || length2 == 0)
            return 0;
        if (str1[length1 - 1] == str2[length2 - 1])
            return 1 + LCSRecursion(str1, str2, length1 - 1, length2 - 1);
        else
            return Math.max(LCSRecursion(str1, str2, length1, length2 - 1), LCSRecursion(str1, str2, length1 - 1, length2));

    }

    //DP
    public static int LCSDP(String str1, String str2){
        int arr[][] = new int[str1.length()+1][str2.length()+1];
        for(int i=0; i <= str1.length() ; ++i){
            arr[i][0] =0;
        }
        for(int i=0; i <= str2.length() ; ++i){
            arr[0][i] =0;
        }

        for(int i=1; i <= str1.length(); ++i){
            for(int j=1; j <=str2.length(); ++j){
                if (str1.charAt(i-1) == str2.charAt(j-1)){
                    arr[i][j] = 1 + arr[i-1][j-1];
                } else{
                    arr[i][j] = Math.max(arr[i-1][j],arr[i][j-1]);
                }
            }
        }
        return arr[str1.length()][str2.length()];
    }

    public static void main(String [] args){
        String str1 = "ABCDGH";
        String str2 = "AEDFHR";
        System.out.println(LCSRecursion(str1.toCharArray(), str2.toCharArray(), str1.length(), str2.length()));
        System.out.println(LCSDP(str1, str2));
    }
}

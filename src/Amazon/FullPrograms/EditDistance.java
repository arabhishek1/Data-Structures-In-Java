package Amazon.FullPrograms;

/**
 * Created by abhishek.ar on 26/05/17.
 * Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required to convert ‘str1′ into ‘str2′.
 * <p>
 * Insert
 * Remove
 * Replace
 * All of the above operations are of cost=1.
 * Both the strings are of lowercase
 */
public class EditDistance {
    public static int editDistance(String str1, String str2, int length1, int length2) {
        if (length1 == 0)
            return length2;
        if (length2 == 0)
            return length1;
        if (str1.charAt(length1 - 1) == str2.charAt(length2 - 1))
            return editDistance(str1, str2, length1 - 1, length2 - 1);
        else
            return 1 + Math.min(
                    editDistance(str1, str2, length1 - 1, length2 - 1),
                    Math.min(editDistance(str1, str2, length1, length2 - 1),
                            editDistance(str1, str2, length1 - 1, length2)));
    }

    public static int editDistanceDP(String str1, String str2){
        int arr[][] = new int [str1.length()+1][str2.length()+1];
        for(int i=0; i <= str1.length(); ++i){
            for(int j=0; j <= str2.length(); ++j){
                // If first string is empty, only option is to
                // insert all characters of second string
                if (i==0)
                    arr[i][j] = j;
                // If second string is empty, only option is to
                // remove all characters of second string
                else if (j==0)
                    arr[i][j] = i;
                else if (str1.charAt(i-1) == str2.charAt(j-1)){
                    arr[i][j] = arr[i-1][j-1];
                } else{
                    arr[i][j] = 1 + Math.min(arr[i-1][j-1], Math.min(arr[i-1][j], arr[i][j-1]));
                }
            }
        }
        return arr[str1.length()][str2.length()];
    }

    public static void main(String[] args) {
        String str1 = "sunday";
        String str2 = "saturday";
        System.out.println(editDistance(str1, str2, str1.length(), str2.length()));
        System.out.println(editDistanceDP(str1, str2));
    }
}

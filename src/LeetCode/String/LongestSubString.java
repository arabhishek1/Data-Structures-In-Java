package LeetCode.String;

import java.util.HashSet;

/**
 * Created by abhishek.ar on 07/08/17.
 * Given a string, find the length of the longest substring without repeating characters.


 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a
 subsequence and not a substring.
 */
public class LongestSubString {

    public static int lengthOfLongestSubstring(String s) {
        int currLength=0, maxLength= 0, prevIndex;
        int visited[] = new int[256];

        for (int i = 0; i < visited.length; i++) {
            visited[i] = -1;
        }

        for(int i=0;i < s.length(); ++i){
            prevIndex = visited[s.charAt(i)];
            if (prevIndex == -1 || i - currLength > prevIndex){
                currLength +=1;
            } else {
                currLength = i- prevIndex;
            }
            visited[s.charAt(i)] = i;
            if (currLength > maxLength)
                maxLength = currLength;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));
    }
}

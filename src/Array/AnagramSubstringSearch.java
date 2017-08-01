package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by abhishek.ar on 01/08/17.
 Given a word and a text, return the count of the occurrences of anagrams of the word in the text.
 For eg. word is “for” and the text is “forxxorfxdofr”, anagrams of “for” will be “ofr”, “orf”,”fro”, etc.
 So the answer would be 3 for this particular example
 Expected time complexity is O(n)

 */
public class AnagramSubstringSearch {

    public static int anagramCount(String text, String pattern){
        HashMap<Character, Integer> patternCount = new HashMap<>();
        HashMap<Character, Integer> textCount = new HashMap<>();
        int count =0;
        for(int i=0; i < pattern.length(); ++i){
            char ch = pattern.charAt(i);
            if (patternCount.containsKey(ch)){
                patternCount.put(ch, patternCount.get(ch) +1);
            } else {
                patternCount.put(ch, 1);
            }

            if (textCount.containsKey(ch)){
                textCount.put(ch, textCount.get(ch)+1);
            } else {
                textCount.put(ch, 1);
            }
        }

        for (int i=0, j=pattern.length(); j<=text.length(); ++i , ++j){
            if (compare(textCount, patternCount, pattern)) {
                ++count;
                if (j == text.length())
                    return count;
            }
            textCount.put(text.charAt(i), 0);
            if (textCount.containsKey(text.charAt(j)))
                textCount.put(text.charAt(j), textCount.get(text.charAt(j)) +1);
            else
                textCount.put(text.charAt(j), 1);
        }


        return count;

    }

    private static boolean compare(HashMap<Character, Integer> textCount, HashMap<Character, Integer> patternCount, String pattern) {
        for(int i=0; i < pattern.length(); ++i){
            if (patternCount.get(pattern.charAt(i)) != textCount.get(pattern.charAt(i)))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String text = "forxxorfxdofr";
        String pattern = "for";
        System.out.println(anagramCount(text, pattern));
    }
}

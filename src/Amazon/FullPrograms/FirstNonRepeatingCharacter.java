package Amazon.FullPrograms;

/**
 * Created by abhishek.ar on 27/05/17.
 * Given a string, find the first non-repeating character in it.
 * For example, if the input string is “GeeksforGeeks”,
 * then output should be ‘f’ and if input string is “GeeksQuiz”, then output should be ‘G’
 */
public class FirstNonRepeatingCharacter {
    private static int[] charCount = new int[256];

    public static char firstNonRepeatingCharacter(String str) {
        for (int i = 0; i < str.length(); ++i)
            ++charCount[str.charAt(i)];
        char non_repeating_character = '\0';
        for (int i = 0; i < str.length(); ++i) {
            if (charCount[str.charAt(i)] == 1) {
                non_repeating_character = str.charAt(i);
                break;
            }
        }
        return non_repeating_character;
    }

    /*
    The above approach takes O(n) time, but in practice it can be improved. The first part of the algorithm runs
    through the string to construct the count array (in O(n) time). This is reasonable. But the second part about
    running through the string again just to find the first non-repeater is not good in practice. In real situations,
     your string is expected to be much larger than your alphabet.

     Take DNA sequences for example: they could be millions of letters long with an alphabet of just 4 letters.
     What happens if the non-repeater is at the end of the string? Then we would have to scan for a long time (again).

    We can augment the count array by storing not just counts but also the index of the first time you encountered
    the character e.g. (3, 26) for ‘a’ meaning that ‘a’ got counted 3 times and the first time it
    was seen is at position 26. So when it comes to finding the first non-repeater, we just have to scan the count array,
    instead of the string.
    */
    static class charCountIndex {
        int count;
        int index;
    }

    public static char firstNonRepeatingCharacterOptimized(String str) {
        charCountIndex[] charCountIndices = new charCountIndex[256];
        for (int i = 0; i < str.length(); ++i) {
            if (charCountIndices[str.charAt(i)] == null) {
                charCountIndex countIndex = new charCountIndex();
                countIndex.count += 1;
                countIndex.index = i;
                charCountIndices[str.charAt(i)] = countIndex;
            } else {
                ++charCountIndices[str.charAt(i)].count;
            }
        }
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < charCountIndices.length; ++i) {
            if (charCountIndices[i] != null && charCountIndices[i].count == 1 && charCountIndices[i].index < minIndex)
                minIndex = charCountIndices[i].index;
        }
        return str.charAt(minIndex);
    }

    public static void main(String[] args) {
        System.out.println(firstNonRepeatingCharacter("geeksforgeeks"));
        System.out.println(firstNonRepeatingCharacterOptimized("geeksforgeeks"));
    }
}

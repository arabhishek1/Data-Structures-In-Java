package Amazon.FullPrograms;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by abhishek.ar on 21/03/18.
 * <p>
 * Given an array of integers that might contain duplicates, return all possible subsets.
 * <p>
 * Note Output:
 * <p>
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * The subsets must be sorted lexicographically.
 * Example :
 * If S = [1,2,2], the solution is:
 * <p>
 * [
 * [],
 * [1],
 * [1,2],
 * [1,2,2],
 * [2],
 * [2, 2]
 * ]
 */
public class Powerset {
    public static Set<String> set = new TreeSet<>();

    public static void powerset(String str) {
        set.add(str);
        for (int i = 0; i < str.length(); ++i) {
            String newString = str.substring(0, i) + str.substring(i + 1, str.length());
            if (!set.contains(newString))
                powerset(newString);
        }
    }

    public static void main(String[] args) {
        powerset("122");
        for (String str : set) {
            System.out.println(str);
        }
        System.out.println(set.size());
    }
}

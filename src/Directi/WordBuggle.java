package Directi;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by abhishek.ar on 08/07/17.
 Given a dictionary, a method to do lookup in dictionary and a M x N board where every cell has one character.
 Find all possible words that can be formed by a sequence of adjacent characters. Note that we can move to any of
 8 adjacent characters, but a word should not have multiple instances of same cell.
 Example:

 Input: dictionary[] = {"GEEKS", "FOR", "QUIZ", "GO"};
 boggle[][]   = {{'G','I','Z'},
 {'U','E','K'},
 {'Q','S','E'}};

 Output:  Following words of dictionary are present
 GEEKS, QUIZ
 */
public class WordBuggle {

    public static void findWords(char[][] boggle, Set<String> dict){
        boolean [][] visited = new boolean[boggle.length][boggle[0].length];
        String str = "";
        for(int i=0; i <boggle.length; ++i){
            for(int j=0; j <boggle[0].length; ++j)
                findWordsUtil(boggle, dict,visited, i, j, str);
        }
    }

    private static void findWordsUtil(char[][] boggle, Set<String> dict, boolean[][] visited, int i, int j, String str) {
        visited[i][j] = true;
        str += boggle[i][j];
        if (dict.contains(str))
            System.out.println(str);

        for(int row = i-1; row <=i+1&& row <boggle.length; ++row){
            for(int col = j-1; col <=j+1 && col <boggle[0].length; ++col){
                if (row >=0 && col >=0 && !visited[row][col])
                    findWordsUtil(boggle,dict, visited, row, col, str);
            }
        }
        str = "";
        visited[i][j] = false;
    }

    public static void main(String[] args) {
        char boggle[][] = {{'G','I','Z'},
            {'U','E','K'},
            {'Q','S','E'}};
        Set<String> set = new HashSet<>();
        set.add("GEEKS");
        set.add("FOR");
        set.add("QUIZ");
        set.add("GO");
        findWords(boggle, set);
    }
}

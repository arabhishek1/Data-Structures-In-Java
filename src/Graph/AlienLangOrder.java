package Graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by abhishek.ar on 21/07/17.
 Given a sorted dictionary (array of words) of an alien language, find order of characters in the language.
 Input:  words[] = {"baa", "abcd", "abca", "cab", "cad"}
 Output: Order of characters is 'b', 'd', 'a', 'c'
 Note that words are sorted and in the given language "baa"
 comes before "abcd", therefore 'b' is before 'a' in output.
 Similarly we can find other orders.

 Input:  words[] = {"caa", "aaa", "aab"}
 Output: Order of characters is 'c', 'a', 'b'
 */
public class AlienLangOrder {

    public static void TopologicalSortingUtil(Graph G, int s, boolean[] visited, Stack stack){
        visited[s] = true;
        for(int u : G.adj(s)){
            if (!visited[u])
                TopologicalSortingUtil(G, u, visited, stack);
        }
        stack.push(s);
    }

    public static void TopologicalSorting(Graph G){
        boolean visited [] = new boolean[G.V()];
        Stack<Integer> stack = new Stack<>();
        for(int i=G.V()-1; i >= 0; --i){
            if (!visited[i])
                TopologicalSortingUtil(G, i, visited, stack);
        }

        while(!stack.isEmpty()){
            char ch = (char) ('a' +stack.pop());
            System.out.println(ch);
        }
    }

    private static int getUniqueCharacter(String[] words) {
        Set<Character> set = new HashSet<>();
        for(String str: words){
            for(int i=0; i < str.length(); ++i){
                set.add(str.charAt(i));
            }
        }
        return set.size();
    }

    public static void constructGraph(String[] words){
        Graph G = new Graph(getUniqueCharacter(words));
        for(int i=0; i < words.length-1; ++i){
            String word1 = words[i], word2 = words[i+1];
            for(int j=0; j < Math.min(word1.length(), word2.length()); ++j){
                if (word1.charAt(j) != word2.charAt(j)) {
                    G.addDirectedEdge(word1.charAt(j) - 'a', word2.charAt(j) - 'a');
                    break;
                }
            }
        }
        TopologicalSorting(G);
    }

    public static void main(String[] args) {
        String words[] = {"baa", "abcd", "abca", "cab", "cad"};
        constructGraph(words);
    }

}

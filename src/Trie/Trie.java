package Trie;

/**
 * Created by abhishek.ar on 18/04/18.
 */
public class Trie<Value> {

    static final int R = 256;

    static class Node{
        private Node[] children = new Node[R];
        boolean isEndOfWord = false;

    }
    static Node root;

    public static void insert(String key){

        int index;

        Node pCrawl = root;
        for(int level =0; level < key.length(); ++level){
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new Node();
            pCrawl = pCrawl.children[index];
        }

        pCrawl.isEndOfWord = true;
    }

    public static boolean search(String key){
        Node pcrawl = root;int index;
        for(int level=0; level< key.length(); ++level){
            index = key.charAt(level) - 'a';

            if (pcrawl.children[index] == null)
                return false;
            pcrawl = pcrawl.children[index];
        }

        return (pcrawl != null && pcrawl.isEndOfWord);
    }

    public static void main(String[] args) {
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};

        String output[] = {"Not present in trie", "Present in trie"};

        root = new Node();

        for (int i = 0; i < keys.length ; i++)
            insert(keys[i]);

        if(search("the") == true)
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);

        if(search("these") == true)
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);

    }


}

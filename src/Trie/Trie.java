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

    //prints all child node for a given Node with the prefix
    public static void displayContactsUtil(Node node, String prefix){
        if (node != null) {
            if (node.isEndOfWord)
                System.out.println(prefix);

            for (char i = 'a'; i <= 'z'; ++i) {
                Node nextNode = node.children[i - 'a'];
                if (nextNode != null)
                    displayContactsUtil(nextNode, prefix + i);
            }
        }
    }


    public static void displayContacts(Node root, String word){
        String prefix = "";
        Node prevNode  = root, currentNode = root;
        boolean flag = true;
        for(int i=0; i < word.length(); ++i){
            if (flag) {
                prefix += word.charAt(i);
                currentNode = prevNode.children[prefix.charAt(i) - 'a'];

                if (currentNode == null) {
                    System.out.println("no result found " + prefix);
                    break;
                }
                prevNode = currentNode;
            }
        }
        displayContactsUtil(currentNode, prefix);

    }

    public static void main(String[] args) {
        String keys[] = {"the", "there", "answer", "any", "a",
                "by", "bye", "their", "amongst", "amazing", "amount"};

        String output[] = {"Not present in trie", "Present in trie"};

        root = new Node();

        for (int i = 0; i < keys.length ; i++)
            insert(keys[i]);

//        if(search("the") == true)
//            System.out.println("the --- " + output[1]);
//        else System.out.println("the --- " + output[0]);
//
//        if(search("these") == true)
//            System.out.println("these --- " + output[1]);
//        else System.out.println("these --- " + output[0]);

        displayContacts(root, "am");

    }


}

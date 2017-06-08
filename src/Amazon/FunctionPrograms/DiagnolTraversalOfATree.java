package Amazon.FunctionPrograms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by abhishek.ar on 08/06/17.

 Given a Binary Tree, print the diagnol traversal of the binary tree.
 Consider lines of slope -1 passing between nodes. Given a Binary Tree, print all diagonal elements in a binary tree
 belonging to same line.

                       20
                   /       \
                  8        22
                /   \     /   \
              5     3   4    25
                    /    \
                  10     14


 */
public class DiagnolTraversalOfATree {

    private static Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

    public static void diagnolTraversal(TreeNode node, int diagnol){
        if (node == null)
            return;
        if (map.containsKey(diagnol)){
            map.get(diagnol).add(node.key);
        } else {
            List<Integer> list = new ArrayList<Integer>();
            list.add(node.key);
            map.put(diagnol, list);
        }
        diagnolTraversal(node.left, diagnol+1);
        diagnolTraversal(node.right, diagnol);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(10);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(25);
        root.right.left.right = new TreeNode(14);
        diagnolTraversal(root, 0);
        for(Map.Entry entry: map.entrySet()){
            List<Integer> list = (List<Integer>) entry.getValue();
            for(int i : list){
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }
}

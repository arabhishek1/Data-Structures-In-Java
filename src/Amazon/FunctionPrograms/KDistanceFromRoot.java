package Amazon.FunctionPrograms;

/**
 * Created by abhishek.ar on 07/06/17.
 Given a Binary Tree and a number k. Print all nodes that are at distance k from root (root is considered at distance
 0 from itself).  Nodes should be printed from left to right.  If k is more that height of tree, nothing should
 be printed.

 For example, if below is given tree and k is 2.  Output should be 4 5 6.

                1
             /     \
            2        3
         /         /   \
        4         5    6
         \
         8
 */

class TreeNode{
    int key;
    TreeNode left;
    TreeNode right;

    public TreeNode(int key) {
        this.key = key;
        this.left = this.right = null;
    }
}

public class KDistanceFromRoot {

    public static void kDistanceFromRoot(TreeNode root, int k){
        if (k ==0 && root != null){
            System.out.print(root.key + " ");
        } else if (k <0 || root == null){
            return;
        } else {
            kDistanceFromRoot(root.left, k-1);
            kDistanceFromRoot(root.right, k-1);
        }
    }

    private static int heightOfTree(TreeNode node){
        if (node == null)
            return 0;
        else
            return 1 + Math.max(heightOfTree(node.left), heightOfTree(node.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(8);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        kDistanceFromRoot(root, 2);
    }
}

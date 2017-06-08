package Amazon.FunctionPrograms;

/**
 * Created by abhishek.ar on 08/06/17.
 Write a function that returns true if the given Binary Tree is SumTree else false. A SumTree is a Binary Tree
 where value of every node x is equal to sum of nodes present in its left subtree and right subtree of x. An empty tree
 is SumTree and sum of an empty tree can be considered as 0. A leaf node is also considered as SumTree.

 Following is an example of SumTree.

            26
          /    \
        10      3
      /   \   /   \
     4     6  1    2
 */


public class SumTree {


    public static boolean isSumTree(TreeNode root){
        if (root != null){
            if (root.right == null && root.left == null)
                return true;
            int leftSum = sum(root.left);
            int rightSum = sum(root.right);
            return (root.key == leftSum + rightSum) && isSumTree(root.left) && isSumTree(root.right);
        }
        return true;
    }

    private static int sum(TreeNode root) {
        if (root != null) {
            return root.key + sum(root.left) + sum(root.right);
        }
        return 0;
    }


    public static boolean isSumTreeOptimized(TreeNode root){
        int ls,rs;

        if (root == null || isLeaf(root))
            return true;
        if (isSumTreeOptimized(root.left) && isSumTreeOptimized(root.right)) {
            if (isLeaf(root.left)) {
                ls = root.left.key;
            } else {
                ls = 2 * root.left.key;
            }

            if (isLeaf(root.right)) {
                rs = root.right.key;
            } else {
                rs = 2 * root.right.key;
            }
            return root.key == ls + rs;
        }
        return false;
    }

    private static boolean isLeaf(TreeNode root){
        return root != null &&root.left == null && root.right == null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(26);
        root.left = new TreeNode(10);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(6);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(2);
        root.right.left = new TreeNode(1);
        System.out.println(isSumTree(root));
        System.out.println(isSumTreeOptimized(root));
    }
}

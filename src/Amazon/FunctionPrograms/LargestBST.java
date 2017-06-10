package Amazon.FunctionPrograms;

/**
 * Created by abhishek.ar on 10/06/17.
 *
 Given a binary tree, Your task is to complete the function largestBst that returns the size of the largest subtree
 which is also a Binary Search Tree (BST). If the complete Binary Tree is BST, then return the size of whole tree
              5
            /  \
           2    4
         /  \
        1    3
 */
public class LargestBST {
    public static int largestBST(TreeNode root){
        if (isBST(root))
            return size(root);
        return Math.max(largestBST(root.left), largestBST(root.right));
    }

    private static int size(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + size(root.left) +  size(root.right);
    }

    private static boolean isBST(TreeNode root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBSTUtil(TreeNode root, int min, int max){
        if (root == null)
            return true;
        if (root.key < min || root.key > max)
            return false;
        return (isBSTUtil(root.left, min, root.key-1) && isBSTUtil(root.right, root.key +1, max));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(3);
        root.left.left = new TreeNode(1);
        System.out.println(largestBST(root));
    }
}

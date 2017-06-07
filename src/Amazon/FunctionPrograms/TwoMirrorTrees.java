package Amazon.FunctionPrograms;

/**
 * Created by abhishek.ar on 07/06/17.
 Given a Two Binary Trees, write a function that returns true if one is mirror of other, else returns false.
 */
public class TwoMirrorTrees {
    public static boolean isMirrorTree(TreeNode root1, TreeNode root2){
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        return (root1.key == root2.key) && isMirrorTree(root1.left, root2.right) && isMirrorTree(root1.right, root2.left);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(5);
        root1.right.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);

        System.out.println(isMirrorTree(root1, root2));
    }
}

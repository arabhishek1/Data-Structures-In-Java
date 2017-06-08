package Amazon.FunctionPrograms;

/**
 * Created by abhishek.ar on 07/06/17.
 Given a Binary Tree, find diameter of it.  The diameter of a tree is the number of nodes on the longest path between
 two leaves in the tree. The diagram below shows two trees each with diameter nine, the leaves that form the ends of a
 longest path are shaded (note that there is more than one path in each tree of length nine, but no path longer
 than nine nodes).
 */
public class DiameterOfATree {

    public static int diameterOfATree(TreeNode root) {
        if (root != null) {
            int lHeight = heightOfATree(root.left);
            int rHeight = heightOfATree(root.right);

            return Math.max(Math.max(diameterOfATree(root.left), diameterOfATree(root.right)), 1 + lHeight + rHeight);
        }
        return 0;
    }

    public static int heightOfATree(TreeNode root){
        if (root != null){
            return 1 + Math.max(heightOfATree(root.left), heightOfATree(root.right));
        }
        return 0;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
        System.out.println(diameterOfATree(root));
    }
}

package Amazon.FunctionPrograms;

/**
 * Created by abhishek.ar on 08/06/17.
 Given a binary tree, find if it is height balanced or not.  A tree is heigh balanced if difference between heights of
 left and right subtrees is not more than one for all nodes of tree.    Expected time complexity is O(n).

 A height balanced tree
          1
        /  \
      10   39
     /
    5

 An unbalanced tree
         1
        /
      10
     /
    5


 */

class Height{
    int height;

    public Height(int height) {
        this.height = height;
    }
}
public class CheckForBalancedTree {

    public static boolean isHeightBalanced(TreeNode root, Height height){

        if (root == null){
            height.height = 0;
            return true;
        }


        Height lHeight = new Height(0);
        Height rHeight = new Height(0);

        boolean l = isHeightBalanced(root.left, lHeight);
        boolean r = isHeightBalanced( root.right, rHeight);

        height.height = 1 + Math.max(lHeight.height, rHeight.height);

        if (Math.abs(lHeight.height-rHeight.height) >= 2)
            return false;
        return l && r;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
        System.out.println(isHeightBalanced(root, new Height(0)));
    }

}

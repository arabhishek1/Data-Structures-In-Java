package Amazon.FunctionPrograms;

/**
 * Created by abhishek.ar on 08/06/17.
 Given a binary tree and a number, return true if the tree has a root-to-leaf path such that adding up all the values
 along the path equals the given number. Return false if no such path can be found.

                10
             /     \
            8       2
          /  \     /
         3    5   2
 21 –> 10 – 8 – 3
 23 –> 10 – 8 – 5
 14 –> 10 – 2 – 2
 */
public class RootToLeafSumPath {

    public static boolean rootToLeafSumPath(TreeNode root, int sum){
        if (root == null)
            return false;
        if (root.key == sum)
            return true;
        return rootToLeafSumPath(root.right, sum-root.key) || rootToLeafSumPath(root.left, sum - root.key);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
        System.out.println(rootToLeafSumPath(root, 9));
    }
}

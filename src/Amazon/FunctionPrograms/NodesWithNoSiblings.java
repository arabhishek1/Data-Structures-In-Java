package Amazon.FunctionPrograms;

/**
 * Created by abhishek.ar on 10/06/17.
 Print all nodes that don’t have sibling
 Given a Binary Tree, print all nodes that don’t have a sibling (a sibling is a node that has same parent. In a Binary
 Tree, there can be at most one sibling). Root should not be printed as root cannot have a sibling.

                1
              /   \
             2     3
             \    /
              4   5
                   \
                    6

 For example, the output should be “4 5 6” for the following tree.
 */
public class NodesWithNoSiblings {

    public static void printNodesWithNoSiblings(TreeNode root){
        if (root == null)
            return;
        if (root.left != null && root.right == null)
            System.out.print(root.left.key + " ");
        if (root.right != null && root.left == null)
            System.out.print(root.right.key + " ");
        printNodesWithNoSiblings(root.left);
        printNodesWithNoSiblings(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.left.right = new TreeNode(6);
        printNodesWithNoSiblings(root);
    }
}

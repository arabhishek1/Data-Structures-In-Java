package Amazon.FunctionPrograms;

/**
 * Created by abhishek.ar on 08/06/17.
 Given a Binary Tree and 2 nodes value n1 and n2  , your task is to find the lowest common ancestor of the two nodes .
 You are required to complete the function LCA . You should not read any input from stdin/console.
 There are multiple test cases. For each test case, this method will be called individually.
 */
public class LCA {

    public static int LCA(TreeNode root, int a, int b){
        if (root == null)
            return -1;
        if (root.key == a || root.key == b)
            return root.key;
        int leftLCA = LCA(root.left, a, b);
        int rightLCA = LCA(root.right, a ,b);
        if (leftLCA != -1 && rightLCA != -1)
            return root.key;

        return leftLCA != -1 ? leftLCA : rightLCA;
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

        System.out.println(LCA(root, 4, 25));
    }
}

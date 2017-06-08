package Amazon.FunctionPrograms;

/**
 * Created by abhishek.ar on 08/06/17.
 Given a binary tree and two node values your task is to find the minimum distance between them.

 */
public class MinDistanceBetweenNodes {

    //Logic is find the LCA for the given Nodes.
    // THen the min distance = findLevel of node a + findLevel of node b - 2* findLevel of LCA of a and b

    public static int LCA(TreeNode root, int a, int b){
        if (root == null)
            return -1;
        if (root.key == a || root.key == b)
            return root.key;
        int leftLCA = LCA(root.left, a, b);
        int rightLCA = LCA(root.right, a, b);

        if (leftLCA != -1 && rightLCA != -1)
            return root.key;
        return leftLCA != -1 ? leftLCA : rightLCA;
    }

    public static int findLevel(TreeNode root, int a, int height){
        if (root == null)
            return -1;
        if (root.key == a)
            return height;
        int l = findLevel(root.left, a, height +1);
        return (l != -1) ? l: findLevel(root.right, a, height +1);
    }

    public static int minDistanceBetweenNodes(TreeNode root, int a, int b){
        int lca = LCA(root, a, b);
        int depthOfA = findLevel(root, a, 0);
        int depthOfB = findLevel(root, b, 0);
        int depthOfLCA = findLevel(root, lca, 0);
        return depthOfA + depthOfB - 2 * depthOfLCA;
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

        System.out.println(minDistanceBetweenNodes(root, 3, 4));
    }
}

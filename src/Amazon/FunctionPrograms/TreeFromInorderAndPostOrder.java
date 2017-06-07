package Amazon.FunctionPrograms;

/**
 * Created by abhishek.ar on 07/06/17.
 * Given inorder and postorder traversals of a Binary Tree, construct the tree
 * <p>
 * For example, if given inorder and postorder traversals are {4, 8, 2, 5, 1, 6, 3, 7} and {8, 4, 5, 2, 6, 7, 3, 1}
 * respectively, then your function should construct below tree.
 * <p>
 * 1
 * /      \
 * 2        3
 * /    \     /   \
 * 4     5   6    7
 * \
 * 8
 */
public class TreeFromInorderAndPostOrder {

    public static TreeNode treeFromIOrderAndPOrder(int inOrder[], int[] postOrder, int iStart, int iEnd, int pStart, int pEnd) {
        if (iStart > iEnd || pStart > pEnd)
            return null;
        TreeNode root = new TreeNode(postOrder[pEnd]);
        if (iStart == iEnd)
            return root;
        int pos = findPosition(inOrder, iStart, iEnd, root.key);
        root.left = treeFromIOrderAndPOrder(inOrder, postOrder, iStart, pos - 1, pStart, pStart + pos - iStart - 1); // since pos is derived from in order subtract this value
        root.right = treeFromIOrderAndPOrder(inOrder, postOrder, pos + 1, iEnd, pStart - iStart + pos, pEnd - 1);
        return root;
    }

    public static int findPosition(int arr[], int iStart, int iEnd, int key) {
        int x = -1;
        while (iStart <= iEnd) {
            if (arr[iStart] == key) {
                x = iStart;
                return x;
            }
            ++iStart;
        }
        return x;
    }

    public static void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.key + " ");
            inOrder(root.right);
        }
    }

    public static void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.key + " ");
        }
    }

    public static void main(String[] args) {
        int[] inOrder = {4, 8, 2, 5, 1, 6, 3, 7};
        int[] postOrder = {8, 4, 5, 2, 6, 7, 3, 1};
        TreeNode root = treeFromIOrderAndPOrder(inOrder, postOrder, 0, inOrder.length - 1, 0, postOrder.length - 1);
        inOrder(root);

    }
}

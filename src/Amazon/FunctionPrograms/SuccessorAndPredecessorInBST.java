package Amazon.FunctionPrograms;

/**
 * Created by abhishek.ar on 11/06/17.
 Given a BST,  and a reference to a Node x the task is to find the Inorder Successor and predecessor of the node .
 /* Let us create following BST
            50
         /     \
         30    70
        /  \    /  \
     20   40  60   80
**/
public class SuccessorAndPredecessorInBST {

    static TreeNode pre =null, suc = null;


    public static void findSuccessorAndPredecessor(TreeNode root, int key){

        if (root == null)
            return;

        if (root.key == key){
            if (root.right != null) {
                TreeNode temp = root.right;
                while (temp.left != null) {
                    temp = root.left;
                }
                suc = temp;
            }

            if (root.left != null){
                TreeNode temp = root.left;
                while(temp.right != null){
                    temp = temp.right;
                }
                pre = temp;
            }
            return;
        }

        if (root.key > key){
            findSuccessorAndPredecessor(root.left, key);
        } else {
            findSuccessorAndPredecessor(root.right, key);
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(70);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(40);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(80);

        findSuccessorAndPredecessor(root, 70);
        if (suc != null){
            System.out.println(suc.key);
        }
        if (pre != null){
            System.out.println(pre.key);
        }
    }
}

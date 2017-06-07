package Amazon.FunctionPrograms;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by abhishek.ar on 07/06/17.
 Given a Binary Tree,  print the bottom view from left to right. A node x is there in output if x is
 the bottommost node at its horizontal distance from root. Horizontal distance of left child of a node x is equal
 to horizontal distance of x minus 1, and that of right child is horizontal distance of x plus 1.

 Examples:

            20
         /    \
        8      22
     /   \       \
    5     3       25
        /   \
     10     14

 For the above tree the output should be 5, 10, 3, 14, 25.

 If there are multiple bottom-most nodes for a horizontal distance from root, then print the later one in level traversal.
 For example, in the below diagram, 3 and 4 are both the bottom-most nodes at horizontal distance 0, we need to print 4.

                    20
                 /    \
               8       22
             /   \     /   \
            5     3   4    25
                 /    \
                10     14

 For the above tree the output should be 5, 10, 4, 14, 25.


 */
public class ViewOfTree {
    public static TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
    //Using treeMap to get the order of left to right as keys are sorted in treemap.

    //For top and bottom view , use width(horizontal level of tree)

    public static void bottomViewOfTree(TreeNode root, int horizontalLevel){
        if (root != null) {
            map.put(horizontalLevel, root.key);
            bottomViewOfTree(root.left, horizontalLevel - 1);
            bottomViewOfTree(root.right, horizontalLevel + 1);
        }
    }

    public static void topViewOfTree(TreeNode root, int horizontalLevel){
        if (root != null) {
            if (!map.containsKey(horizontalLevel))
                map.put(horizontalLevel, root.key);
            topViewOfTree(root.left, horizontalLevel - 1);
            topViewOfTree(root.right, horizontalLevel + 1);
        }
    }

    //For left and right view use depth from root.
    public static void leftViewOfTree(TreeNode root, int verticalLevel){
        if (root != null){
            if (!map.containsKey(verticalLevel))
                map.put(verticalLevel, root.key);
            leftViewOfTree(root.left, verticalLevel +1);
            leftViewOfTree(root.right, verticalLevel +1);
        }
    }

    public static void rightViewOfTree(TreeNode root, int verticalLevel){
        if (root != null){
            map.put(verticalLevel, root.key);
            rightViewOfTree(root.left, verticalLevel +1);
            rightViewOfTree(root.right, verticalLevel +1);
        }
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
//        bottomViewOfTree(root, 0);
//        topViewOfTree(root, 0);
        leftViewOfTree(root, 0);
//        rightViewOfTree(root, 0);
        for(Map.Entry entry : map.entrySet()){
            System.out.print(entry.getValue()  + " ");
        }
    }
}

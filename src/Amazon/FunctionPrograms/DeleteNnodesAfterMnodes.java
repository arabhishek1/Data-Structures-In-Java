package Amazon.FunctionPrograms;

/**
 * Created by abhishek.ar on 24/05/17.
 * Given a linked list, delete N nodes after skipping M nodes of a linked list until the last of the linked list.
 Example:

 M = 2, N = 2
 Linked List: 1->2->3->4->5->6->7->8
 After 2 nodes 2 nodes will be deleted.Deleted Nodes 3->4 and 7->8
 Output: Linked List: 1->2->5->6
 */

class Node{
    int key;
    Node next;

    public Node(int key) {
        this.key = key;
        this.next = null;
    }
}

public class DeleteNnodesAfterMnodes {
    Node root;

    public static void deleteNnodesAfterMNodes(Node root, int m, int n){
        int traversalCount=1, deletionCount=0;
        while(root != null){
            for(int i=1; i <m && root !=null; ++i){
                root = root.next;
            }

            if (root == null)
                return;
            Node temp = root.next;
            for(int i=1; i <=n && temp!= null; ++i){
                Node deleteNode = temp;
                temp = temp.next;
                deleteNode.next = null;
            }
            root.next = temp;
            root = temp;
        }
    }

    public static void displayNode(Node root){
        while(root != null){
            System.out.print(root.key  + " -> ");
            root = root.next;
        }
        System.out.println();

    }
    public static void main(String [] args){
        Node root= new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(3);
        root.next.next.next = new Node(4);
        root.next.next.next.next = new Node(5);
        root.next.next.next.next.next = new Node(6);
        root.next.next.next.next.next.next = new Node(7);
//        root.next.next.next.next.next.next.next = new Node(8);

        displayNode(root);
        deleteNnodesAfterMNodes(root, 2, 2);
        displayNode(root);
    }
}

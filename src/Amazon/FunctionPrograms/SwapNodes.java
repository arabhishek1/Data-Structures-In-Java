package Amazon.FunctionPrograms;

import static Amazon.FunctionPrograms.DeleteNnodesAfterMnodes.displayNode;

/**
 * Created by abhishek.ar on 24/05/17.
 * Pairwise swap elements of a linked list by swapping data
 * Given a singly linked list, write a function to swap elements pairwise.
 * For example, if the linked list is 1->2->3->4->5 then the function should change it to 2->1->4->3->5,
 * and if the linked list is 1->2->3->4->5->6 then the function should change it to 2->1->4->3->6->5.
 */
public class SwapNodes {

    public static Node swapNodes(Node root){
        while(root != null && root.next != null){
            Node next = root.next;
            root.next = next.next;
            next.next = root;
            root = root.next;
        }
        return root;
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
        swapNodes(root);
        displayNode(root);
    }
}

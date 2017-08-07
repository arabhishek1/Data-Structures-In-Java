package LeetCode.LinkedList;

/**
 * Created by abhishek.ar on 07/08/17.
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
 * order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 */
class LinkedListNode{
    int value;
    LinkedListNode next;

    public LinkedListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

public class AddTwoNumbers {

    public static LinkedListNode addTwoNumbers(LinkedListNode l1, LinkedListNode l2){

        LinkedListNode result = null, temp = null, prev = null;
        int carry =0, sum =0;
        while(l1 != null || l2 != null){
            sum =(l1 != null ? l1.value : 0) + (l2 != null ? l2.value : 0) + carry;
            temp = new LinkedListNode(sum%10);
            carry = sum/10;
            if (result == null) {
                result = temp;
            } else {
                prev.next = temp;
            }
            prev = temp;

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        if (carry > 0) {
            temp.next = new LinkedListNode(carry);
        }

        return result;
    }

    public static void displayList(LinkedListNode l){
        while (l != null){
            System.out.println(l.value);
            l = l.next;
        }
    }

    public static void main(String[] args) {
        LinkedListNode l1 = new LinkedListNode(2);
        l1.next = new LinkedListNode(4);
        l1.next.next = new LinkedListNode(3);

        LinkedListNode l2 = new LinkedListNode(5);
        l2.next = new LinkedListNode(6);
        l2.next.next = new LinkedListNode(4);

        LinkedListNode result = addTwoNumbers(l1, l2);
    }
}

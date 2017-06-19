package Stack;

import java.util.Stack;

/**
 * Created by abhishek.ar on 19/06/17.
 *
 * Design a stack that supports getMax() in O(1) time and O(1) extra space
 */
public class MaximumElement {

    public static Stack<Integer> normalStack = new Stack<Integer>();
    public static Stack<Integer> stackWithMax = new Stack<Integer>();

    public static void push (int element){
        if (!normalStack.isEmpty()){
            if (element > normalStack.peek())
                stackWithMax.push(element);
            else
                stackWithMax.push(stackWithMax.peek());
        } else {
            stackWithMax.push(element);
        }
        normalStack.push(element);
    }

    public static int pop(){
        stackWithMax.pop();
        return normalStack.pop();
    }

    public static int getMaxElement(){
        return stackWithMax.peek();
    }

    public static void main(String[] args) {
        push(3);
        push(5);
        push(2);
        push(1);
        push(6);
        push(-1);
        pop();
        pop();
        for(Integer i : stackWithMax)
            System.out.print(i + " ");
        System.out.println();
        for(Integer i : normalStack)
            System.out.print(i + " ");
        System.out.println(getMaxElement());
    }
}

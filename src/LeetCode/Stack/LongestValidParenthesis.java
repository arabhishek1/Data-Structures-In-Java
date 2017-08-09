package LeetCode.Stack;

import java.util.Stack;

/**
 * Created by abhishek.ar on 09/08/17.
 Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed)
 parentheses substring.

 For "(()", the longest valid parentheses substring is "()", which has length = 2.

 Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
public class LongestValidParenthesis {

    public static int longestValidParenthesis(String str){
        int matchedCount = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    matchedCount = Math.max(matchedCount, i-stack.peek());
                } else {
                    stack.push(i);
                }
            }
        }
        return matchedCount;
    }

    public static void main(String[] args) {
        String parenthesis = "())()()";
        System.out.println(longestValidParenthesis(parenthesis));
    }
}

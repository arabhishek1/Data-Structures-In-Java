package Amazon.FullPrograms;

import java.util.Stack;

/**
 * Created by abhishek.ar on 24/05/17.
 *
 Given an expression string exp, examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp.
 For example, the program should print 'balanced' for exp = “[()]{}{[()()]()}” and 'not balanced' for exp = “[(])”
 */
public class ParenthesisChecker {
    public static boolean parenthesisChecker(String str){
        Stack<Character> stack = new Stack<Character>();
        for(int i=0 ; i < str.length(); ++i) {
            char currentChar = str.charAt(i);
            if (currentChar == '{' || currentChar == '(' || currentChar == '[') {
                stack.push(currentChar);
            } else {
                if (stack.isEmpty())
                    return false;
                else {
                    char poppedChar = stack.pop();
                    if (!((currentChar == '{' && poppedChar == '}') || (currentChar == '[' && poppedChar == ']') || (currentChar == '(' && poppedChar == ')')))
                        return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args){
        System.out.println(parenthesisChecker("[(])"));
    }

}

package LeetCode.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/*Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Example 1:

Input: "()())()"
Output: ["()()()", "(())()"]
Example 2:

Input: "(a)())()"
Output: ["(a)()()", "(a())()"]
Example 3:

Input: ")("
Output: [""]
*/
public class RemoveInvalidParethesis {

    public static String removeInvalidParenthesis(String input){
        Stack<Character> stack = new Stack<>();
        for(Character ch : input.toCharArray()){
            if (ch == '('){
                stack.push(ch);
            } else if (ch == ')'){

            }
        }
        return null;
    }

    public static int[][] reconstructQueue(int[][] people) {
        int[][] result = new int[people.length][];
        Arrays.sort(people, new Comparator<int[]>(){
            public int compare(int[] a1, int[] a2){
                if(a1[0]!=a2[0]){
                    return a2[0]-a1[0];
                }else{
                    return a1[1]-a2[1];
                }
            }
        });

        for(int i=0; i < people.length;++i){
            for(int j=0; j < people[0].length; ++j)
                System.out.print(people[i][j] + " ");
            System.out.println();
        }

        ArrayList<int[]> list = new ArrayList<int[]>();

        for(int i=0; i<people.length; i++){
            int[] arr = people[i];
            list.add(arr[1],arr);
        }

        for(int i=0; i<people.length; i++){
            result[i]=list.get(i);
        }


        System.out.println("---------------------");

        for(int i=0; i < result.length;++i){
            for(int j=0; j < result[0].length; ++j)
                System.out.print(result[i][j] + " ");
            System.out.println();
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[][] = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        reconstructQueue(arr);

    }
}

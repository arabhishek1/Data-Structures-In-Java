package Amazon.FullPrograms;

import java.util.Stack;

/**
 * Created by abhishek.ar on 26/05/17.
 *
 Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a number
 of contiguous bars. For simplicity, assume that all bars have same width and the width is 1 unit.
 */
public class Histogram {

    //Recursion : o(n2)

    public static int maxAreaHistogram(int arr[],int start, int length){

        if (start == length)
            return 0;

        int maxArea = 0;
        int min = Integer.MAX_VALUE;
        int count =1;
        for(int i= start; i <= length; ++i){
            if (arr[i-1] < min){
                min = arr[i-1];
            }
            if (count* min > maxArea) {
                maxArea = count * min;

            }
            ++count;
        }
        return Math.max(maxArea, maxAreaHistogram(arr, start+1, length));
    }

    // Stack approach : O(n)
    public static int maxAreaHistogramStack(int arr[]){
        Stack<Integer> stack = new Stack<Integer>();
        int i=0;
        int area, maxArea = Integer.MIN_VALUE;
        while(i < arr.length){
            if (stack.isEmpty() || arr[stack.peek()] <= arr[i] ){
                stack.push(i++);
            } else {
                int index = stack.pop();
                if (stack.isEmpty())
                     area= arr[index]* i;
                else
                    area = arr[index]* (i- stack.peek() -1);
                if (area > maxArea)
                    maxArea = area;

            }
        }

        while(!stack.isEmpty()){
            int index = stack.pop();
            if (stack.isEmpty())
                area= arr[index]* i;
            else
                area = arr[index]* (i- stack.peek() -1);
            if (area > maxArea)
                maxArea = area;
        }
        return maxArea;
    }

    public static void main(String [] args){
        int arr[]= {6,2,5,4,5,1,6};
        System.out.println(maxAreaHistogram(arr, 1, arr.length));
        System.out.println(maxAreaHistogramStack(arr));
    }
}

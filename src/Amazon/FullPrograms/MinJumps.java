package Amazon.FullPrograms;

/**
 * Created by abhishek.ar on 25/05/17.
 * Given an array of integers where each element represents the max number of steps that
 * can be made forward from that element. Write a function to return the minimum number of jumps
 * to reach the end of the array (starting from the first element). If an element is 0,
 * then cannot move through that element.
 */
public class MinJumps {

    public static int minJumps(int arr[], int start, int end){

//        recursive soln. didnt understand
        if (start == end)
            return 0;
        if (arr[start] == 0)
            return Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i= start +1; i <=end && i <=start +arr[start]; ++i){
            int jumps = minJumps(arr, i, end);
            if (jumps != Integer.MAX_VALUE && jumps + 1 < min)
                min = jumps +1;
        }
        return min;
    }

    public static int minJumpsDP(int arr[]){
        int [] minJumps = new int[arr.length];
        minJumps[0] = 0;
        for(int i=1; i < arr.length ; i++){
            minJumps[i] = Integer.MAX_VALUE-1;
        }
        for(int i=1; i < arr.length; ++i){
            for(int j=0; j <i; ++j){
                if (arr[j] +j >=i  &&  minJumps[i] > minJumps[j] + 1 ){
                    minJumps[i] = minJumps[j] + 1;
                }
            }
        }
        return minJumps[arr.length-1];
    }

    public static void main(String [] args){
        int arr[] = {1 , 3,  5,  8,  9,  2,  6, 7, 6, 8, 9};
        System.out.println(minJumps(arr, 0, arr.length));
        System.out.println(minJumpsDP(arr));
    }
}

package Amazon.FullPrograms;

/**
 * Created by abhishek.ar on 31/05/17.
 * <p>
 * Write a program to find the majority element in the array. A majority element in an array A[] of size n is an element
 * that appears more than n/2 times (and hence there is at most one such element).  If input array doesn't contain a
 * majority element, then output "NO Majority Element"
 *
 I/P : 3 3 4 2 4 4 2 4 4
 O/P : 4

 I/P : 3 3 4 2 4 4 2 4
 O/P : NONE
 */
public class MajorityElement {
/*
Below algorithm loops through each element and maintains a count of a[maj_index], If next element is same then
increments the count, if next element is not same then decrements the count, and if the count reaches 0 then changes
the maj_index to the current element and sets count to 1.

First Phase algorithm gives us a candidate element. In second phase we need to check if the candidate is really a
majority element. Second phase is simple and can be easily done in O(n). We just need to check if count of the
candidate element is greater than n/2.
 */
    public static int getMajorityElement(int arr[]) {
        int majorityIndex = 0, count = 1;
        for (int i = 1; i < arr.length-1; ++i) {
            if (arr[majorityIndex] == arr[i]) {
                ++count;
            } else {
                --count;
            }
            if (count == 0) {
                majorityIndex = i + 1;
                count = 1;
            }
        }
        return arr[majorityIndex];
    }

    public static boolean isMajorityElementPresent(int arr[], int majorityElement){
        int count =0;
        for(int i=0; i < arr.length; ++i)
            if(arr[i] == majorityElement)
                ++count;

        return count > arr.length/2;
    }

    public static void main(String [] args){
        int a[] = {1, 3, 3, 3, 2};
        int majorityElement = getMajorityElement(a);
        if (isMajorityElementPresent(a, majorityElement)){
            System.out.println("Majority ELement is " + majorityElement);
        } else {
            System.out.println("No Majority Element found");
        }
    }
}

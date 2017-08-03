package Array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by abhishek.ar on 03/08/17.
 Arrange given numbers to form the biggest number | Set 1
 Given an array of numbers, arrange them in a way that yields the largest value. For example, if the given numbers are
 {54, 546, 548, 60}, the arrangement 6054854654 gives the largest value.

 And if the given numbers are {1, 34, 3, 98, 9, 76, 45, 4}, then the arrangement 998764543431 gives the largest value.
 */

class customComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String XY = o1.concat(o2);
        String YX = o2.concat(o1);
        if (XY.equalsIgnoreCase(YX))
            return 0;
        else if (XY.compareTo(YX) > 0)
            return -1;//Decreasing order
        else
            return 1;
    }
}

public class ArrangeNumbers {

    public static void largestNumber(String [] numbers){
        Arrays.sort(numbers, new customComparator());
        for(int i=0; i <numbers.length; ++i){
            System.out.print(numbers[i]);
        }
    }

    public static void main(String[] args) {
        String arr[] = {"54", "546", "548", "60"};
        largestNumber(arr);
    }
}

package Amazon.FullPrograms;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by abhishek.ar on 16/04/18.
 Given a fraction, find recurring sequence of digits if exists, otherwise print “No recurring sequence”.

 Input  : Numerator = 8, Denominator = 3
 Output : Recurring sequence is 6
 Explanation : 8/3 = 2.66666666.......

 Input : Numerator = 50, Denominator = 22
 Output : Recurring sequence is 27
 Explanation : 50/22 = 2.272727272.....

 Input : Numerator = 11, Denominator = 2
 Output : No recurring sequence
 Explanation : 11/2 = 5.5
 */
public class RepeatingRemainder {

    public static int repeatingRemainder(int numerator, int denominator){

        int remainder = numerator % denominator;
        String result = "";
        Map<Integer, Integer> map = new HashMap();
        // find the right syntax currently its wrong
        while(remainder != 0 && map.get(remainder) == 0){
            int temp = remainder*10;
            result += remainder/denominator;
            remainder = remainder%denominator;
        }
        return 0;
    }
}

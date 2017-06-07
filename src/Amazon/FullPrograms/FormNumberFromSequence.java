package Amazon.FullPrograms;

/**
 * Created by abhishek.ar on 06/06/17.
 Given a pattern containing only I’s and D’s. I for increasing and D for decreasing. Devise an algorithm to print
 the minimum number following that pattern. Digits from 1-9 and digits can’t repeat.

 Examples:

 Input: D        Output: 21
 Input: I        Output: 12
 Input: DD       Output: 321
 Input: II       Output: 123
 Input: DIDI     Output: 21435
 Input: IIDDD    Output: 126543
 Input: DDIDDIID Output: 321654798
 */
public class FormNumberFromSequence {

    public static int formMinimumNumberFromSequence(char[] chars, int end){
        String finalString = "";
        if (chars[0] == 'I')
            finalString = "12";
        else
            finalString = "21";
        for(int i=1; i < chars.length; ++i){
            if (chars[i] == 'I'){
                if (true){

                }
            } else {

            }
        }
        return -1;
    }
}

package LeetCode.String;

/**
 * Created by abhishek.ar on 07/08/17.
 *
 The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"
 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class Zigzag {

    public static String convert(String s, int numRows) {

        if (numRows == 1){
            return s;
        }

        String [] result = new String[numRows];
        boolean down =true;
        int row =0;
        for(int i=0; i < s.length(); ++i){
            if (result[row] != null) {
                result[row] =result[row] + s.charAt(i);
            } else {
                result[row] = String.valueOf(s.charAt(i));
            }
            if (row == numRows -1)
                down = false;
            else if (row ==0)
                down = true;

            if (down)
                ++row;
            else
                --row;
        }
        String res = "";
        for(int i=0; i<numRows; ++i){
            res += result[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(convert("ABC", 2));
    }
}

package Directi;

/**
 * Created by abhishek.ar on 09/07/17.

 Transform One String to Another using Minimum Number of Given Operation

 Given two strings A and B, the task is to convert A to B if possible. The only operation allowed is to put any
 character from A and insert it at front. Find if it’s possible to convert the string. If yes, then output minimum no.
 of operations required for transformation.

 Input:  A = "ABD", B = "BAD"
 Output: 1
 Explanation: Pick B and insert it at front.

 Input:  A = "EACBD", B = "EABCD"
 Output: 3
 Explanation: Pick B and insert at front, EACBD => BEACD
 Pick A and insert at front, BEACD => ABECD
 Pick E and insert at front, ABECD => EABCD
 */
public class TransformOneStrToAnother {

    public static int transformOneStrToAnother(String str1, String str2){
        if (checkBothStringContainSameCharacters(str1, str2)){
            int i= str1.length()-1, j= str2.length()-1;
            int res =0;
            while (i >=0){
                while (i >= 0 && str1.charAt(i) != str2.charAt(j)){
                    --i; res +=1;
                }
                if (i >=0){
                    --i; --j;
                }

            }
            return res;
        }
        return -1;
    }

    private static boolean checkBothStringContainSameCharacters(String str1, String str2) {
        int[] count = new int[256];
        for(int i=0; i < str1.length(); ++i){
            ++count[str1.charAt(i)];
        }

        for(int i=0; i <str2.length(); ++i){
            --count[str2.charAt(i)];
        }

        for(int i=0; i <count.length;++i)
            if (count[i] != 0)
                return false;
        return true;
    }

    public static void main(String[] args) {
        String str1 = "EACBD";
        String str2 = "EABCD";
        System.out.println(transformOneStrToAnother(str1, str2));
    }
}

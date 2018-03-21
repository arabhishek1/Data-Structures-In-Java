package Amazon.FullPrograms;

/**
 * Created by abhishek.ar on 20/03/18.
 * You are involved in a betting game whose rules are as follows :
 a) If you win a round, the bet amount will be added to your current sum and next bet amount will become $1;
 b) If you lose a round, the bet amount will be reduced from your current sum and next bet will become twice the previous.
 c) game ends either when all the rounds are complete or when you don't have sufficient sum.
 Initially, you are given with a string consisiting of characters from the set {'W', 'L'}, where 'W' indicates a win and 'L'
 indicates a loss, and initial sum is 4. Initial bet amount for the 1st round will be $1.

 You need to find and print the amount at the end of the game (final sum) and in case you do not have enough money in
 between the game to play the next round, then print -1.

 Example:

 Input:
 WL
 WLWLLLWWLW

 Output:
 4
 -1
 */
public class Betting {

    public static int getBettingMONEY(String str, int start, int end, int bet, int initialSum){
        if (start < end && initialSum > 0) {
            if (str.charAt(start) == 'W')
                return getBettingMONEY(str, start + 1, end, 1, bet+ initialSum);
            else
                return getBettingMONEY(str, start + 1, end, 2* bet, initialSum - bet) ;
        } else if (start < end && initialSum < 0)
            return -1;
        return initialSum;
    }

    public static int getMoney(String str, int initialSum){
        int bet = 1;
        for(int i=0;i < str.length(); ++i){
            if (initialSum > 0) {
                if (str.charAt(i) == 'W') {
                    initialSum += bet;
                    bet = 1;
                }
                if (str.charAt(i) == 'L') {
                    initialSum -= bet;
                    bet = 2*bet;
                }
            } else
                return -1;
        }
        return initialSum;
    }

    public static void main(String[] args) {
        String str = "WL";
        System.out.println(getBettingMONEY(str, 0, str.length(), 1 ,4));
        System.out.println(getMoney(str, 4));
    }
}

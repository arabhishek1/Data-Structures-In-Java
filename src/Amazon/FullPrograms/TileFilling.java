package Amazon.FullPrograms;

/**
 * Created by abhishek.ar on 26/03/18.
 Count number of ways to fill a “n x 4” grid using “1 x 4” tiles
 Given a number n, count number of ways to fill a n x 4 grid using 1 x 4 tiles.

 Input : n = 1
 Output : 1

 Input : n = 2
 Output : 1
 We can only place both tiles horizontally

 Input : n = 3
 Output : 1
 We can only place all tiles horizontally.

 Input : n = 4
 Output : 2
 The two ways are :
 1) Place all tiles horizontally
 2) Place all tiles vertically.

 Input : n = 5
 Output : 3
 */
public class TileFilling {

    /*
    This is classic case of recurrence:
    From the above example we can complete to conclusion for following recurrence relation:
    count(n) = 1 ; for n =1, n=2, n=3
    count(n) = 2; for n =2
    count(n) = count(n-1) + count(n-4) ; for n >4
    //Simple reason being , simply execute this using this concept of , we will place it horizontally or vertically
    //If we place horizontally, reduce one from count; if we place vertically we have to add remaining value to fill the
    //tile layout
    * */
    public static int getNumberWaysToFillTheTile(int n){
        int arr[] = new int[n+1];

        for(int i=1; i <= n; ++i){
            if (i == 1 || i== 2 || i== 3)
                arr[i] = 1;
            else if (i == 4)
                arr[i] = 2;
            else
                arr[i] = arr[i-1] + arr[i-4];

        }
        return arr[n];
    }

    public static void main(String[] args) {
        System.out.println(getNumberWaysToFillTheTile(6));
    }

}

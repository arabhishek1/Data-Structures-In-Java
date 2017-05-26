package Amazon.FullPrograms;

/**
 * Created by abhishek.ar on 25/05/17.
 * The following is a description of the instance of this famous puzzle involving n=2 eggs and a building with k=36 floors.

 Suppose that we wish to know which stories in a 36-story building are safe to drop eggs from, and which will cause the
 eggs to break on landing. We make a few assumptions:

 …..An egg that survives a fall can be used again.
 …..A broken egg must be discarded.
 …..The effect of a fall is the same for all eggs.
 …..If an egg breaks when dropped, then it would break if dropped from a higher floor.
 …..If an egg survives a fall then it would survive a shorter fall.
 …..It is not ruled out that the first-floor windows break eggs, nor is it ruled out that the 36th-floor do not cause
 an egg to break.
 In this problem you have to find minimum trials to solve for n eggs and k floors.
 */
public class EggDropping {
    public static int eggDropping(int n, int k){
        // If there are no floors, then no trials needed. OR if there is
        // one floor, one trial needed.
        if (k==0 || k==1)
            return k;
        // We need k trials for one egg and k floors
        if (n == 1)
            return k;
        int min = Integer.MAX_VALUE;
        // Consider all droppings from 1st floor to kth floor and
        // return the minimum of these values plus 1.
        for(int i=1; i <=k; ++i){
            int res = 1 + Math.max(eggDropping(n-1, i-1), eggDropping(n, k-i));
            if (res < min)
                min =res;
        }
        return min;
    }

/*When we drop an egg from a floor x, there can be two cases (1) The egg breaks (2) The egg doesn’t break.

1) If the egg breaks after dropping from xth floor, then we only need to check for floors lower than x with remaining
    eggs; so the problem reduces to x-1 floors and n-1 eggs
2) If the egg doesn’t break after dropping from the xth floor, then we only need to check for floors higher than x;
    so the problem reduces to k-x floors and n eggs.

Since we need to minimize the number of trials in worst case, we take the maximum of two cases. We consider the max
of above two cases for every floor and choose the floor which yields minimum number of trials.

  k ==> Number of floors
  n ==> Number of Eggs
  eggDrop(n, k) ==> Minimum number of trials needed to find the critical
                    floor in worst case.
  eggDrop(n, k) = 1 + min{max(eggDrop(n - 1, x - 1), eggDrop(n, k - x)):
                 x in {1, 2, ..., k}}
*/

    public static int eggDroppingDP(int n , int k){
        int arr[][] = new int [n+1][k+1];
        // We always need k trials for one egg and k floors.
        for(int i=1; i <=k ; ++i){
            arr[1][i] = i;
        }
        // We need one trial for one floor and0 trials for 0 floors
        for(int i=1 ; i <=n; ++i){
            arr[i][1] = 1;
            arr[i][0] = 0;
        }

        for(int i=2; i <=n; ++i){
            for(int j=2; j <=k ; ++j){
                arr[i][j] = Integer.MAX_VALUE;
                for(int x = 1; x <=j; ++x){
                    int res = 1 +  Math.max(arr[i-1][x-1], arr[i][j-x]);
                    if (res < arr[i][j])
                        arr[i][j]= res;
                }
            }
        }
        return arr[n][k];

    }

    public static void main(String [] args){
        System.out.println(eggDropping(2, 10));
        System.out.println(eggDroppingDP(2,36));
    }
}

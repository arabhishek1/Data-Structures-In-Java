package Stack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by abhishek.ar on 21/06/17.
 */
public class Solution {


    // we will create a max heap
    public Solution(int length) {
//        pq = new PriorityQueue<>(length, new Comparator<Integer>() {
//
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                // TODO Auto-generated method stub
//                return o2 - o1;
//            }
//        });
    }

    public long maximumAmount(int[] a, long k) {

        PriorityQueue<Integer> pq= new PriorityQueue<>(a.length, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        long revenue = 0;
        // insert the all the elements of an array into the priority queue
        for (int i = 0; i < a.length; i++) {
            pq.offer(a[i]);
        }

        while (k > 0) {
            int ticketPrice = pq.poll();
            revenue += ticketPrice;
            pq.offer(--ticketPrice);
            k--;
        }
        return revenue;
    }

//    int start = 0;
//    int end = maximum number of ticket in one window;
//    while(start <= end)
//    int mid = (start + end)/2;
//    for(each window)
//    number of sell ticket += a(i) - mid;//if mid is larger than a(i), just add a zero
//    if(number of sell ticket >= m)
//    increase start;
//    else
//    decrease end;
//
//    static long maxAmt(int []a, long k){
//        int start =0;
//        int end =0;
//        while(start <=end){
//            int mid = (start + end)/2;
//            for(int i=0; i <a.length; ++i){
//
//            }
//        }
//    }

    static long maximumAmountAliter(int a[], long k){
        Arrays.sort(a);

        int tickets = a[a.length - 1];
        int[] dp = new int[tickets + 1];

        for (int i = 0; i < a.length; i++) {
            dp[a[i]]++;
        }

        long total = 0;
        int i = dp.length - 1;

        while (k > 0) {
            if (dp[i] > 0) {
                total += i;
                k--;
                dp[i]--;
                dp[i - 1]++;
            } else {
                i--;
            }
        }
        return total;

    }


    public static void main(String[] args) {
        int[] windowsTickets = { 2,8,4,10,6};
        int noOfTickets = 20;
        Solution mx = new Solution(windowsTickets.length);
        System.out.println( mx.maximumAmount(windowsTickets, noOfTickets));
        System.out.println(mx.maximumAmountAliter(windowsTickets, noOfTickets));

    }
}

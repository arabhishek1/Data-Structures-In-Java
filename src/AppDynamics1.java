/**
 * Created by abhishek.ar on 21/06/17.
 */
public class AppDynamics1 {

    static long countSum(int arr[]){
        long sum =0;
        for(int i=0; i < arr.length; ++i){
            sum += other(arr[i]);
        }
        return sum;
    }

    private static long getAllOddDivisors1(int num) {
        long count =0;
        for(int i=1; i <= Math.sqrt(num)+1; ++i){
            if (num % i ==0 && i %2 ==1) {
                count += i;
                if (num / i != i) {
                    if ( (num / i) %2 ==1)
                        count += num/i;
                }
            }
        }
        return count;
    }

    static long other(int num){
        long count =0;
        for (int i = 1; i <= num/2; ++i) {
            if (num % i == 0 &&  i%2 ==1) {
                    count +=i ;
                if (i != num/i && (num/i)%2 == 1) {
                    count += (num/i);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[]= {1,6,10};
        System.out.println(countSum(arr));
    }
}

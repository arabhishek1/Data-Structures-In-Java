/**
 * Created by abhishek.ar on 21/06/17.
 */
public class AppDynamics3 {

    static int knapSack(int n, int bundleQuantities[] ,int bundleCosts[])
    {
        int dp[] = new int[n+1];

        // Build table K[][] in bottom up manner
        for (int i=0; i<=n; i++)
            for (int j=0; j<bundleQuantities.length; j++)
                if (bundleCosts[j] <= i)
                    dp[i] = Math.max(dp[i], dp[i-bundleCosts[j]]+bundleQuantities[j]);

        return dp[n];
    }

    public static void main(String[] args) {
        int bundleQunaties[]={20,19};
        int bundleCosts []= {24,20};
        int W = 50;
        System.out.println(knapSack(W,  bundleQunaties, bundleCosts));

    }
}

class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[][] dp = new long[n+forget][3];

        long mod=(long) 1e9+7;
        dp[0][0] =dp[delay][1] = dp[forget][2]=1;
        for(int i=1;i<n;i++){
            dp[i][1] = (dp[i][1]+dp[i-1][1]-dp[i][2]+mod)%mod;

            dp[i+forget][2]=dp[i][1];
            dp[i+delay][1]=dp[i][1];

            dp[i][0]=(dp[i-1][0]+dp[i][1]-dp[i][2]+mod)%mod;

        }

        return (int) dp[n-1][0];


    }
}
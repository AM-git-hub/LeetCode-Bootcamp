class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] dp = new long[n+1];
        dp[1] = 1;
        long mod = (int)Math.pow(10,9)+7;
        long peopleKnowSecret = 0;

        for(int i=2;i<=n;i++)
        {
            long canShare = dp[Math.max(i-delay,0)];
            long willForget = dp[Math.max(i-forget,0)];

            peopleKnowSecret=(peopleKnowSecret+canShare - willForget+mod)%mod;
            dp[i] = peopleKnowSecret;
        }

        long res=0;
        for(int i=n-forget+1;i<=n;i++)
        {
            res=(res+dp[i])%mod;
        }
        return (int)res;
    }
}
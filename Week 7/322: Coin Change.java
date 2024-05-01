class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        
        dp[0]=0;
        for(int a=1;a<=amount;a++)
        {
            for(int c : coins)
            {
                if(a-c>=0 && dp[a-c]!=Integer.MAX_VALUE)
                {
                    dp[a] = Math.min(dp[a],1+dp[a-c]);
                }   
            }
        }
        return dp[amount]!=Integer.MAX_VALUE ? dp[amount] : -1 ;
    }    
        
}
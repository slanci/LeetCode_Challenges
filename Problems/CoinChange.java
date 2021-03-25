class Solution {
    public int coinChange(int[] coins, int amount){
        int max = amount + 1;
        int[] dp = new int[amount + 1]; //memoization table
        Arrays.fill(dp, max); //we need to fill with max because we are using bottom up approach
        dp[0] = 0; // base case
        
        for(int i = 1; i <= amount; i++)
        {
            for(int j = 0; j < coins.length; j++){
                if(coins[j] <= i){
                    dp[i] = Math.min(dp[i] , dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount]; //because we filled the table with max which is amount + 1,                                                       //if the minimization never happened it would be bigger                                                           //than amount 
    }
}
package DP;
// Climbing Stairs LeetCode 70
// Input:
//    n=3 Output:3 
//    Explanation:
//      3 ways:
//      1. 1 step+1 step+1 step 
//      2. 1 step+2 steps 
//      3. 2 steps+1 step

import java.util.Arrays;


public class ClimbStairs {
    // approch 1 plain recursion 
    // time exponential(2^n)



    public static int climbstair(int n){
        if (n == 0 || n == 1) {
            return 1;
        }

        return climbstair(n-2) + climbstair(n-1);
    }
    // public static void main(String[] args) {
    //    int n = 3;
    //    System.out.println(" Way climb "+ n + " stairs "+ climbstair(n)); 
    // }

    // approch 2 DP memoization
    static int dp[];
    public static int memeClimbStairsDP(int n){
        if (n == 0 || n == 1) {
            return 1;
        }
        // calculated 
        if (dp[n] != -1) {
            return dp[n];
        }
        dp[0] = 1;
        dp[1] = 1;

        dp[n] = memeClimbStairsDP(n-1) + memeClimbStairsDP(n-2);
        
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 10;
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(" Climb stairs dp " + n + " : "+ memeClimbStairsDP(n));
    }

    // aproch 3 using tabulation 
    public static int tabulationDpStairs(int n){
        if (n == 0 || n == 1) {
            return 1;
        }

        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
    // public static void main(String[] args) {
    //     int n = 10;
    //     System.out.println("Tabulation dp stairs "+ n+ " : "+ tabulationDpStairs(n));
    // }

    // approch 4 space optamized
    // time O(n) space O(1)
    public static int spaceOptamizeStair(int n){
        if (n == 0  || n == 1) {
            return 1;
        }
        int prev0 = 1;
        int prev1 = 1;

        for(int i=2; i<=n; i++){
            int curr = prev0 + prev1;
            prev0 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    // public static void main(String[] args) {
    //     int n = 40;
    //     System.out.println("Stair case optaimize "+ n+ " : "+ spaceOptamizeStair(n));
    // }
}

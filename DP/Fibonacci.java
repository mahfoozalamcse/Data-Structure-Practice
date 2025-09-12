package DP;

// import java.util.Arrays;

public class Fibonacci {
    // 1. recursion solution 
    // time O(2^n) exponential 
    public static int fiboRecursion(int n){
        if (n == 0 || n == 1) {
            return n;
        }

        return fiboRecursion(n-1) + fiboRecursion(n-2);
    }
    // public static void main(String[] args) {
    //     int n = 45;
    //     System.out.println(" Fibonacci using recursion : " + fiboRecursion(n));
    // }


    // 2 Use Dp memoization solution
    // here take O(n) time and space O(n) rec statck + Dp O(n)
    // here top down approch dp used
    static int[] dp;
    public static int fiboMemoDp(int n){
         if (n == 0 || n == 1) {
            return n;
         }
       
         // if already calculated
         if (dp[n] != -1) {
            return dp[n];
         }
        dp[n] = fiboMemoDp(n-1) + fiboMemoDp(n-2);
        return dp[n];
    }
    // public static void main(String[] args) {
    //     int n = 70;
    //     dp = new int[n+1];
    //     Arrays.fill(dp, -1);

    //     System.out.println(" Memo Fibo Dp solution " + n + " output "+ fiboMemoDp(n));
    // }

    // 3. Dp tabulation approch
    // time O(n) space O(n)
    // bottom approch in DP use here

    public static int tabulationFiboDp(int n){
      if (n == 0 || n == 1) {
         return n;
      }
      int dp[] = new int[n+1];
      dp[0] = 0;
      dp[1] = 1;

      for(int i=2; i<=n; i++){
         dp[i] = dp[i-2] + dp[i-1];
      }

      return dp[n];
    }
    // public static void main(String[] args) {
    //   int n = 70;
    //   System.out.println("Tabulation solution : "+ n + " : "+ tabulationFiboDp(n));  
    // }

    // approch 4 space optamized
    public static int spaceOptamizeFibo(int n){
        if (n == 0 || n == 1) {
            return n;
        }

        int prev0 = 0;
        int prev1 = 1;

        for(int i=2; i<=n; i++){
            int curr = prev0 + prev1;
            prev0= prev1;
            prev1 = curr;

        }

        return prev1;
    }
    public static void main(String[] args) {
        int n = 75;
        System.out.println(" Space optamized dp "+ n + " : "+ spaceOptamizeFibo(n));
    }
}

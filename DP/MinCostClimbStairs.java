package DP;
// Min Cost Climbing Stairs (LeetCode 746)
// input:cost=[10,15,20]
//    Output:15 
//    Explanation:
//       Start at index 1→pay 15→climb 2 steps→reach top

public class MinCostClimbStairs {
    // approch 1 recursive solution
    public static int minCostClimbRec(int[] cost){
        return Math.min(findMin(cost, 0), findMin(cost, 1));
    }
    private static int findMin(int [] cost, int currStep){
      if (currStep >= cost.length) {
         return 0;
      }
        

      int currCost = cost[currStep];
      int minCostNext = Math.min(findMin(cost, currStep+1), findMin(cost, currStep+2));

      return currCost + minCostNext;
    }
    // public static void main(String[] args) {
    //     int cost[] = {10, 15, 20};
    //     System.out.println("Min cost climb stairs "+ minCostClimbRec(cost));
    // }


    // approch 2 : using memoization method

    
    
}

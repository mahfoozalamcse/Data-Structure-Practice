package DP;

//import java.util.Arrays;

// House Robber (LeetCode 198)
// Input: nums=[2,7,9,3,1]
// Output: 12 Explanation:Rob house 1(2)+house 3(9)+house 5(1)=12

public class HouseRobber {
    // approch 1 simple recursion
    public static int houseRobRec(int arr[], int i) {
        if (i < 0) {
            return 0;
        }
        if (i == 0) {
            return arr[0];
        }

        // here choice pick or not pick
        int pick = arr[i] + houseRobRec(arr, i - 2);
        int noTpick = houseRobRec(arr, i - 1);

        // here add in result max value
        int res = Math.max(pick, noTpick);
        return res;
    }
    // public static void main(String[] args) {
    // int arr[] = {2, 7, 9, 3, 1};
    // System.out.println("Max price stolen : "+ houseRobRec(arr, arr.length-1));
    // }

    // approch 2 use dp memo approach
    static int[] dp;

    public static int houseRobDpMemo(int arr[], int i) {
        if (i < 0) {
            return 0;
        }
        if (i == 0) {
            return arr[0];
        }

        // check dp full or not
        if (dp[i] != -1) {
            return dp[i];
        }
        // chice
        int pick = arr[i] + houseRobDpMemo(arr, i - 2);
        int notPick = houseRobDpMemo(arr, i - 1);

        dp[i] = Math.max(pick, notPick);

        return dp[i];
    }

    // public static void main(String[] args) {
    //     int arr[] = { 2, 7, 9, 3, 1 };
    //     dp = new int[arr.length];
    //     Arrays.fill(dp, -1);
    //     System.out.println("Max price stolen : " + houseRobDpMemo(arr, arr.length - 1));

    // }


    // approch 3 using tabulation method
    public static int houseRobTabu(int arr[]){
        int n = arr.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return arr[0];
        }

        int[] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for(int i=2; i<n; i++){
            int pick = arr[i] + dp[i-2];
            int notPick = dp[i-1];

            dp[i] = Math.max(pick, notPick);
        }

        return dp[n-1];
    }
    // public static void main(String[] args) {
    //     int arr[] = { 2, 7, 9, 3, 1 };
    //     System.out.println("Max price stolen : "+ houseRobTabu(arr));
    // }


    // approch 4 use space optamized 
    public static int houseRobSpaceOptamized(int arr[]){
        int n = arr.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return arr[0];
        }

        int prev0 = arr[0];
        int prev1 = Math.max(arr[0], arr[1]);

        for(int i=2; i<n; i++){
            int curr = Math.max(arr[i] + prev0, prev1);
            prev0 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
    public static void main(String[] args) {
        int arr[] = { 2, 7, 9, 3, 1 };
        System.out.println("Max price stolen : " + houseRobSpaceOptamized(arr));
    }
}

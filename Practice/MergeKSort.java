package Practice;

import java.util.Arrays;

public class MergeKSort {
    public static int candy1(int[] rating){

        int n = rating.length;
        int left[] = new int[n];
        int right[] = new int[n];

        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        for(int i=1; i<n; i++){
            if (rating[i] > rating[i-1] ) {
                left[i] = left[i-1]+1;
            }
        }

        for (int i = n-2; i >= 0; i--) {
            if (rating[i] > rating[i+1]) {
                right[i] = right[i+1] + 1;
            }
        }

        int total = 0;
        for(int i=0; i<n; i++){
           total  += Math.max(left[i], right[i]);
        }

        return total;

    }

    // single to allocate
    public static int candy2(int[] rating){
        int n = rating.length;
        int[] candies = new int[n];

        // assighn 1 of each children
        for(int i=0; i<n; i++){
            candies[i] = 1;
        }

        // traverse left to right and check which is greater neighbour than increase
        for(int i=1; i<n; i++){
            if (rating[i] > rating[i-1]) {
                candies[i] = candies[i-1]+1;
            }
        }

        // traverse from right to left
        for(int i=n-2; i>=0; i--){
            if (rating[i] > rating[i+1]) {
                candies[i] = Math.max(candies[i], candies[i+1]+1);
            }
        }

        int total = 0;

        for(int el : candies){
            total += el;
        }

        return total;
    }

    // 2nd approach
    
    public static void main(String[] args) {
        int rating[] = {1, 0, 2};
        System.out.println(candy1(rating));
        int reting[] = {1, 2, 2};
        System.out.println(candy1(reting));

        System.out.println(" Practice 2 ans : ");
        System.out.println(candy2(rating));
        System.out.println(candy2(reting));
    }
}

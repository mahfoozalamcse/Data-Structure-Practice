package Practice;

import java.util.Arrays;

public class MergeKSort {
    public static int candy(int[] rating){

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
                right[i] = left[i+1] + 1;
            }
        }

        int total = 0;
        for(int i=0; i<n; i++){
           total  += Math.max(left[i], right[i]);
        }

        return total;

    }
    public static void main(String[] args) {
        int rating[] = {1, 0, 2};
        System.out.println(candy(rating));
        int reting[] = {1, 2, 2};
        System.out.println(candy(reting));
    }
}

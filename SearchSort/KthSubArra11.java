package SearchSort;

public class KthSubArra11 {
    public static int maxSubArraySize(int[] arr, int k){
        int n = arr.length;

        // edge case handle
        for(int num : arr){
            if(num > k){
                return -1;
            }
        }

        int low = 1;
        int high = n;
        int ans = -1;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isValid(arr, n, mid, k)) {
                ans = mid;
                low = mid + 1;
            }else{
                high = mid;
            }
        }

        return ans;
    }
    public static boolean isValid(int[] arr, int n, int L, int K){
     int windowSum = 0;
     for(int i=0; i<L; i++){
        windowSum += arr[i];
     }

     if (windowSum > K) {
        return false;
     }

     for(int i=L; i<n; i++){
        windowSum += arr[i];
        windowSum -= arr[i-L];
        if (windowSum > K) {
            return false;
        }
     }

     return true;
    }
    public static void main(String[] args) {
     int arr[] = {1, 2, 3, 4};
     int k = 8;
     System.out.println(" Ans : "+maxSubArraySize(arr, k));

    }
}

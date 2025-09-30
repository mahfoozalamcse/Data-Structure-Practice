package Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KthClosestElement {
    // naive approach 1: 

    public static List<Integer> kthClosest1(int arr[], int k, int x){

      ArrayList<Integer> result = new ArrayList<>();

      // store list differences in list
      List<int[]> diff = new ArrayList<>();

      for (int num : arr) {
          if (num == x) {
            continue; // skip same element
          }

          diff.add(new int[]{Math.abs(num-x), num});
      }

      // sort on the basis of difference first than on the basis of value
      Collections.sort(diff, (a, b) ->
         a[0] == b[0] ? Integer.compare(a[1],b[1]) : Integer.compare(a[0], b[0]));

    
      // pick first k element
      for(int i=0; i<k; i++){
        result.add(diff.get(i)[1]);
      }

      // sort result to maintain order
      Collections.sort(result);

      return result;

    }

    // approach 2
    // Binary search + two pointer
    public static List<Integer> kthClosest2(int arr[], int k, int x){

        int n = arr.length;

        // Binary search to find index
        int index = Arrays.binarySearch(arr, x);

        if (index < 0) {
            index = -(index + 1);
        }

        int left = index-1, right = index;
        List<Integer> result = new ArrayList<>();

        // get k close
        while (k > 0) {

            if (left >=0 && right < n) {
                int diffLeft = Math.abs(arr[left]-x);
                int diffRight = Math.abs(arr[right]-x);

                if (arr[left] == x) {
                    left--;
                    continue;
                }
                if (arr[right] == x) {
                    right++;
                    continue;
                }

                if (diffLeft <= diffRight) {
                    result.add(arr[left--]);
                }else{
                    result.add(arr[right++]);
                }
            }

            // when have only left or right only left element
            else if (left >= 0) {
                if (arr[left] != x) {
                    result.add(arr[left--]);
                }
            }else{
               if (arr[right] != x) {
                   result.add(arr[right++]);
               }
            }

            k--;
        }

        Collections.sort(result);
        return result;
    }

    // approach 3 using minHeap
    public static List<Integer> kthClosest3(int arr[], int k, int x){
       PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b)->
       a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

       // add in minheap
       for(int num : arr){
        if (num == x) {
            continue;
        }
        minHeap.offer(new int[]{Math.abs(num-x), num});
       }

       List<Integer> result = new ArrayList<>();
       while (k-- > 0 && !minHeap.isEmpty()) {
           result.add(minHeap.poll()[1]);
       }
       
       Collections.sort(result);
       return result;
    }

    // approach 4 more efficient
    // sliding windows + binary search
    public static List<Integer> ktClosest4(int arr[], int k, int x){
      int n = arr.length;
      int left = 0, right = n-k;

      // find best window wich collect kth close
      while (left < right) {
          int mid = (left + right)/2;

          if (x - arr[mid] > arr[mid+k] - x) {
            left = mid + 1;
          }else{
            right = mid;
          }
      }

      // add result
      List<Integer> result = new ArrayList<>();
      for(int i=left; i<left+k; i++){
        if (arr[i] == x) {
            continue; // skip if equal
        }
        result.add(arr[i]);
      }

      return result;

    }

    public static void main(String[] args) {
        int[] arr = { 12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56 };
        int k = 4, x = 35;
        System.out.println("kth Close using naive approach "+kthClosest1(arr, k, x));
        System.out.println(" Kth close using Binary and two pointer "+ kthClosest2(arr, k, x));

        System.out.println(" Kth close using MinHeap " + kthClosest3(arr, k, x));

        System.out.println(" Kth close using Sliding window and two pointer " + kthClosest2(arr, k, x));
 
    }
}

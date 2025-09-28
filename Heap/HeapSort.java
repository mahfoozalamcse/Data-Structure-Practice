package Heap;
// step of heap sort
// 1. Build max Heap
// 2. swap first and last element
// 3. reduce the size of heap by 1
// 4. heapify the root elemen
// 5. repeat step 2,3,4 until size of heap is greater than 1

public class HeapSort {
    // Besed on max heap 
    public static void heapify(int arr[], int n, int i){
       int largest = i;
       int left = 2*i+1;
       int right = 2*i+2;

       if (left < n && arr[left] > arr[largest]) {
            largest = left;
       }
       if (right < n && arr[right] > arr[largest]) {
           largest = right;
       }

       if (largest != i) {
          int temp = arr[i];
          arr[i] = arr[largest];
          arr[largest] = temp;

          // next inside arrange in order
          heapify(arr, n, largest);
       }
    }

    public static void buildMaxHeap(int arr[]){
        int n = arr.length;

        for(int i=n/2 -1; i>=0; i--){
            heapify(arr, n, i);
        }
    }
    // heapsort
    public static void heapSort(int arr[]){
        int n = arr.length;
        // 1. build maxHeap
        buildMaxHeap(arr);

        // extraxt swap large in end till left 1
        for(int i=n-1; i>0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static void print(int arr[]){
        for(int e : arr){
            System.out.print(" "+e);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };

        System.out.println("Original Array:");
        print(arr);

        heapSort(arr);

        System.out.println("Sorted Array:");
        print(arr);
    }
}

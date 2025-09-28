package Heap;

public class BuildMinHeap {
    public static void heapify(int arr[], int n, int i){
        int smallest = i; // treat a parent
        int left = 2*i+1;
        int right = 2*i+2;

        if (left < n && arr[left] < arr[smallest]) {
            smallest = left;
        }

        if (right < n && arr[right] < arr[smallest]) {
            smallest = right;
        }

        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;

            heapify(arr, n, smallest);

        }

    }

    // Build min heap
    public static void buildHeap(int arr[]){
       int n = arr.length;

       for(int i=n/2-1; i>=0; i--){
          heapify(arr, n, i);
       }
    }
    public static void main(String[] args) {
       int arr[] = { 3, 5, 1, 10, 2, 7 };
       buildHeap(arr);
       System.out.println();
       for(int el : arr){
        System.out.print(el+" ");
       }

    }
}

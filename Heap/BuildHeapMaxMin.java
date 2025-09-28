package Heap;

public class BuildHeapMaxMin {
   public static void heapify(int arr[], int n, int i){
      int largest = i;
      int left = 2*i+1;
      int right = 2*i+2;

      // if left is greater 
      if (left < n && arr[left] > arr[largest]) {
        largest = left;
      }

      // if right is greater
      if (right < n && arr[right] > arr[largest]) {
          largest = right;
      }

      // if largest is not root
      if (largest != i) {
         int temp = arr[i];
         arr[i] = arr[largest];
         arr[largest] = temp;
      }
   }
    public static void buildHeap(int arr[]){
        int n = arr.length;

        for (int i = n/2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }
    public static void main(String[] args) {
     
        int arr[] = {3,5,1,10,2,7};
        buildHeap(arr);
        System.out.println();
        for (int i : arr) {
    
             System.out.print(i + " ");
        }
    }
}

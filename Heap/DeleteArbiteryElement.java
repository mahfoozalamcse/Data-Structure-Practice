package Heap;

public class DeleteArbiteryElement {
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

        if (i != largest) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // recursive handle all effective sub tree
            heapify(arr, n, largest);
        }
    }

    // heapify up direction
    // why need when insert new that 
    // Heapify Up is used when we insert a new element into a Max Heap.

    public static void heapifyUpDirection(int arr[], int i){
        
       int parent = (i-1)/2;
        while (i > 0 && arr[parent] < arr[i]) {
            int temp = arr[i];
            arr[i] = arr[parent];
            arr[parent] = temp; 

            i = parent;
            parent = (i-1)/2;
        }
    }

    // delete any arbitery point in given heap
    public static int DeleteHeapArbitery(int arr[], int n, int i){
      if (i >= n) {
         System.out.println(" Index out of bound");
         return n;
      }

      arr[i] = arr[n-1];
      n--;

      // hepify
      heapify(arr, n, i); // bottom up
      heapifyUpDirection(arr, i);

      return n;

    }

    public static void print(int arr[], int n){
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = { 10, 5, 3, 2, 4 };
        int n = arr.length;

        System.out.println("Original Heap:");
        print(arr, n);

        // Delete root index 0
        n = DeleteHeapArbitery(arr, n, 0);
        System.out.println("After deleting root:");
        print(arr, n);

        // Delete element at index 2 
        n = DeleteHeapArbitery(arr, n, 2);
        System.out.println("After deleting index 2:");
        print(arr, n);  
    }
}

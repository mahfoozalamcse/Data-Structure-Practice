package Heap;

public class InsertInMaxHeap {
    
    public static void heapifyUp(int arr[], int i){
        int parent = (i-1)/2;

        while (i > 0 && arr[i] > arr[parent]) {
            int temp = arr[i];
            arr[i] =  arr[parent];
            arr[parent] = temp;

            i = parent;

            parent = (i-1)/2;
        }
    }

    // insert 
    public static int insertHeap(int arr[], int n, int key){
        // step 1 insert at end
         arr[n] = key;
         n++; // increase size

         // fix heap property
         heapifyUp(arr, n-1);

         return n;

    }

    public static void print(int arr[], int n){
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int capacity = 10; // big enough space for test 
        int arr[] = new int[capacity];

        // Start with empty heap
        int n = 0;

        // Insert elements
        n = insertHeap(arr, n, 50);
        n = insertHeap(arr, n, 30);
        n = insertHeap(arr, n, 40);
        n = insertHeap(arr, n, 10);
        n = insertHeap(arr, n, 20);

        System.out.println("Heap after initial insertions :");
        print(arr, n);

        // Insert a larger element (60)
        n = insertHeap(arr, n, 60);

        System.out.println("Heap after inserting 60 :");
        print(arr, n);

        // Insert a smaller element (15)
        n = insertHeap(arr, n, 15);

        System.out.println("Heap after inserting 15 :");
        print(arr, n);
    }
}

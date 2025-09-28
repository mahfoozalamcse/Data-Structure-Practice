package Heap;

public class DeleteHeap {
    // Delete heap
    // step 1 : swap last with root
    // step 2 : delete last
    // step 3 : heapify to build max heap

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

        // if difrent largest than change
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // recursive heapify affected sub tree
            heapify(arr, n, largest);
        }
    }
    public static int DeleteHeapElementRoot(int arr[], int n){

        int lastElement = arr[n-1];
        arr[0] = lastElement;

        // free last element memory space reduce heap size 1
        n = n-1;
  
        heapify(arr, n, 0);

        return n;
    }

    // print 
    public static void print(int arr[], int n){

        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }

        System.out.println();
    }
    public static void main(String[] args) {
        // Array representation of Max-Heap
        //      10
        //     / \
        //    5  3
        //   / \
        //  2  4

        int arr[] = { 10, 5, 3, 2, 4 };

        int n = arr.length;
        System.out.println(" Before ");
        print(arr, n);
        n = DeleteHeapElementRoot(arr, n);

        System.out.println(" After deletion ");
        print(arr, n);
    }
}

package practice1;

public class DeleteLinkedListMiddle {
    
    static class Node{
        int data;
        Node next;
        Node(int value){
            data = value;
            next = null;
        }
    }
    static Node head;
    // delete middle
    static void deleteMiddleLinkedList(Node head){
        if (head == null || head.next == null) {
            head = null;
            return;
        }

        Node slow = head, fast = head;
        Node prev = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;

        }
        // prev one step back to slow and slow at middle position
        prev.next = slow.next;
    
    }
    // print list
    static void printList(Node head){
        Node curr = head;
        while (curr != null) {
             System.out.print(curr.data+" ");
             curr = curr.next;
        }
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.print("Original List: ");
        printList(head);

        deleteMiddleLinkedList(head);

        System.out.print("After Deleting Middle: ");
        printList(head);  
    }
}

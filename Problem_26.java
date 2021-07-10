public class Problem_26 {
    static class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    static void remove_nth_fromlast(Node head, int n){
        Node main_ptr = head;
        Node ref_ptr = head;
        int count = 0;

        while (count < n) {
            ref_ptr = ref_ptr.next;
            count++;
        }
        while (ref_ptr != null) {
            main_ptr = main_ptr.next;
            ref_ptr = ref_ptr.next;
        }
        System.out.println(main_ptr.data + " is removed from the Linked list");
        main_ptr.data = main_ptr.next.data;
        main_ptr.next = main_ptr.next.next;
    }
    public static void main(String []args) {
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
        remove_nth_fromlast(head,3);
        System.out.println("Modified Linked list is printed below");
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }
}

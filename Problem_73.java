public class Problem_73 {
    public static class Node{
        int data;
        Node next;
    }

    private static Node CreateList(int[] arr) {
        Node root = new Node();
        root.data = arr[0];
        Node temp = root;
        int size = arr.length;
        for (int i=1;i<size;i++){
            Node temp2 = new Node();
            temp2.data = arr[i];
            temp.next = temp2;
            temp = temp2;
        }
        return root;
    }

    private static void PrintList(Node root) {
        while(root!=null){
            System.out.print(root.data+" ");
            root = root.next;
        }
    }

    private static Node ReverseList(Node root) {
        Node newhead = null;
        Node temp;
        while (root!=null){
            temp = root.next;
            root.next = newhead;
            newhead = root;
            root=temp;
        }
        return newhead;
    }

    public static void main(String args[]) {
        int arr[] = {1,2,3,4,5};
        Node root = CreateList(arr);
        System.out.print("Linked list is ");
        PrintList(root);
        System.out.println();
        Node root2 = ReverseList(root);
        System.out.print("Reversed Linked list is ");
        PrintList(root2);
    }
}

public class Problem145 {
    public static class Node{
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }

    private static void PrintList(Node root) {
        while(root!=null){
            System.out.print(root.data+" ");
            root = root.next;
        }
    }
    public static void main(String[] args){
        Node root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(3);
        root.next.next.next = new Node(4);
        SwapEveryTwoNodes(root);
        PrintList(root);
    }

    private static void SwapEveryTwoNodes(Node root) {
        while (root!=null&&root.next!=null){
            int temp = root.data;
            root.data = root.next.data;
            root.next.data = temp;
            root = root.next.next;
        }
    }
}

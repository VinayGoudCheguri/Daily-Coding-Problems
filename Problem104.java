public class Problem104 {
    public static class Node{
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args){
        Node root = CreateLinkedList(new int[]{1, 2, 3, 4, 3, 2,1});
        System.out.print(IsPalindrome(root));
    }

    private static boolean IsPalindrome(Node root) {
        int length = 0;
        Node node = root;
        while (node!=null){
            length++;
            node = node.next;
        }
        if(length%2==0){
            return false;
        }
        else {
            Node temp = null;
            int count =0;
            while (count<length/2){
                Node rev = new Node(root.data);
                rev.next = temp;
                root = root.next;
                temp = rev;
                count++;
            }
            root = root.next;
            while (root!=null){
                if(temp.data!= root.data){
                    return false;
                }
                root = root.next;
                temp = temp.next;
            }
        }
        return true;
    }

    private static Node CreateLinkedList(int[] arr) {
        Node root = new Node(arr[0]);
        Node temp = root;
        for(int i=1;i< arr.length;i++){
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
        temp.next=null;
        return root;
    }
}

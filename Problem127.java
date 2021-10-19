public class Problem127 {
    public static class Node{
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args){
        Node l1 = CreateLinkedList(99);
        Node l2 = CreateLinkedList(52);
        Node l3 =  FindSumLinkedList(l1,l2);
        PrintList(l3);
    }

    private static Node FindSumLinkedList(Node l1, Node l2) {
        int i1 = FindNum(l1);
        int i2 = FindNum(l2);
        int sum = i1+i2;
        int sumrev = ReverseDigits(sum);
        Node sumNode = CreateLinkedList(sumrev);
        return sumNode;
    }

    private static int ReverseDigits(int number) {
        int reverse = 0;
        while(number != 0)
        {
            int remainder = number % 10;
            reverse = reverse * 10 + remainder;
            number = number/10;
        }
        return reverse;
    }


    private static int FindNum(Node root) {
        int multiplier = 1;
        int sum = 0;
        while(root!=null){
            sum+= root.data*multiplier;
            multiplier*=10;
            root = root.next;
        }
        return sum;
    }

    private static void PrintList(Node root) {
        while(root!=null){
            System.out.print(root.data+" ");
            root = root.next;
        }
    }

    private static Node CreateLinkedList(int i) {
        int divider = 10;
        while (i/divider!=0){
            divider*=10;
        }
        divider = divider/10;
        Node root = new Node(i/divider);
        i=i%divider;
        divider/=10;
        Node temp = root;
        while (divider>0){
            temp.next = new Node(i/divider);
            i=i%divider;
            temp = temp.next;
            divider/=10;
        }
        return root;
    }
}

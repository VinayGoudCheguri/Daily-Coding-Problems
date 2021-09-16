public class Problem_94 {
    static int MAX_SUM = Integer.MIN_VALUE;
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static void main(String[] args){
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(20);
        root.left.left = new Node(2);
        root.right.left = new Node(15);
        root.right.right = new Node(25);
        root.right.left.right = new Node(18);
        FindMaxSum(root);
        System.out.println("Maximum sum in given tree is "+ MAX_SUM);
    }

    private static int FindMaxSum(Node root) {
        if(root==null){
            return 0;
        }
        int left_max = FindMaxSum(root.left);
        int right_max = FindMaxSum(root.right);
        int both_side_sum = Math.max(left_max+right_max+root.data,root.data);
        int max_oneside = Math.max(root.data+Math.max(left_max,right_max), root.data);
        MAX_SUM = Math.max(Math.max(both_side_sum,max_oneside),MAX_SUM);
        return max_oneside;
    }
}

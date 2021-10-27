public class Problem135 {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
        }
    }
    static int max_sum = Integer.MAX_VALUE;
    public static void main(String[] args){
        Node root = CreateTree();
        MinimumPath(root);
        System.out.println(max_sum);
    }

    private static void MinimumPath(Node root) {
        int sum = root.data;
        MinimumPathHelper(root.left,sum);
        MinimumPathHelper(root.right,sum);
    }

    private static void MinimumPathHelper(Node node, int sum) {
        if(node==null){
            if (sum<max_sum){
                max_sum = sum;
            }
        }
        else {
            sum+= node.data;
            MinimumPathHelper(node.left,sum);
            MinimumPathHelper(node.right,sum);
        }
    }

    private static Node CreateTree() {
        Node root = new Node(10);
        Node left = new Node(5);
        left.right = new Node(2);
        Node right = new Node(5);
        right.right = new Node(1);
        right.right.left = new Node(-1);
        root.left = left;
        root.right = right;
        return root;
    }
}

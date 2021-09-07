public class Problem_83 {
    static final int COUNT = 4;
    public static class Node{
        char data;
        Node left;
        Node right;

        public Node(char data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    static void print2DUtil(Node root, int space)
    {
        if (root == null)
            return;
        // Increase distance between levels
        space += COUNT;
        // Process right child first
        print2DUtil(root.right, space);
        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.data + "\n");
        // Process left child
        print2DUtil(root.left, space);
    }
    public static void main(String[] args){
        Node root = new Node('a');
        root.left = new Node('b');
        root.right = new Node('c');
        root.left.left = new Node('d');
        root.left.right = new Node('e');
        root.right.left = new Node('f');
        System.out.println("Original tree is:");
        print2DUtil(root,0);
        System.out.println("tree after flipping is:");
        FlipTree(root);
        print2DUtil(root,0);
    }

    private static void FlipTree(Node node) {
        if(node!=null){
            Node temp = node.right;
            node.right = node.left;
            node.left = temp;
            FlipTree(node.left);
            FlipTree(node.right);
        }
    }
}

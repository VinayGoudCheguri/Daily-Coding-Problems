public class Problem_89 {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private static boolean IsBST(Node node) {
        if(node==null){
            return true;
        }
        int key = node.data;
        if(node.left!=null&&node.left.data>key){
            return false;
        }
        if(node.right!=null&&node.right.data<key){
            return false;
        }
        if(!IsBST(node.left)||!IsBST(node.right)){
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(1);
        root.left.right = new Node(8);
        root.right.right = new Node(26);
        boolean bool = IsBST(root);
        if(bool==true){
            System.out.println("Given tree is a valid Binary Search Tree");
        }
        else {
            System.out.println("Given tree is not a Binary Search Tree");
        }
    }
}

public class Problem133 {
    public static class Node{
        private final int data;
        private Node parent;
        private Node left;
        private Node right;
        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args){
        Node root = CreateTree();
        System.out.println(InorderSuccessor(root));
    }

    private static int InorderSuccessor(Node root) {
        if (root==null){
            return -1;
        }
        else if(root.right!=null){ // if root has right sub-tree
            Node node = root.right;
            while (node.left!=null){
                node = node.left;
            }
            return node.data;
        }
        else if(root.parent!=null&&root.parent.left!=root){ // if root is on right branch
            root = root.parent;
        }
        return root.parent.data; // if root is on left branch
    }

    private static Node CreateTree() {
        Node five = new Node(5);
        Node ten = new Node(10);
        Node twentyTwo = new Node(22);
        Node thirty = new Node(30);
        Node thirtyFive = new Node(35);

        twentyTwo.parent = thirty;
        thirtyFive.parent = thirty;

        thirty.parent = ten;
        thirty.left = twentyTwo;
        thirty.right = thirtyFive;

        five.parent = ten;
        ten.left = five;
        ten.right = thirty;
        return twentyTwo;
    }

}

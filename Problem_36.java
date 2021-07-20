public class Problem_36{
    // To count number of visited nodes from highest node
    public static class Count {
        int count = 0;
    }
    static class Node{
        int data;
        Node left,right;
        Node(int x){
            data = x;
            left = null;
            right = null;
        }
    }
    // creates a binary search tree
    public static class BST{
        Node root;
        public BST() {
            this.root = null;
        }
        public void insert(int data)
        {
            this.root = insertToTree(this.root, data);
        }
        Node insertToTree(Node node, int data)
        {
            // If tree is empty
            if (node == null) {
                this.root = new Node(data);
                return root;
            }
            // adding on left side
            if (data < node.data) {
                node.left = this.insertToTree(node.left, data);
            }
            // adding on right side
            else {
                node.right = this.insertToTree(node.right, data);
            }
            return node;
        }
    }
    // prints the second highest node
    static void printSecondLargestNode(Node node, Count C){
        if (node == null || C.count > 2){
            return;
        }
        // count++ starts after reaching the highest node on right tree
        printSecondLargestNode(node.right, C);
        C.count++;
        if (C.count == 2) {
            System.out.print("Second largest node is "+ node.data);
            return;
        }
        printSecondLargestNode(node.left, C);
    }

    public static void main(String []args){
        Count C = new Count();
        BST tree = new BST();
        tree.insert(5);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(7);
        tree.insert(6);
        printSecondLargestNode(tree.root,C);
    }
}

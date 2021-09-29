import java.util.LinkedList;
import java.util.Queue;

public class Problem107 {
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
    public static void main(String[] args){
        // creating binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        PrintTreeLevelWise(root);
    }

    private static void PrintTreeLevelWise(Node root) {
        if(root==null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (true){
            int NodeCount = q.size();
            if(NodeCount==0){
                break;
            }
            while (NodeCount>0){
                Node temp = q.remove();
                System.out.print(temp.data+" ");
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
                NodeCount--;
            }
        }
    }
}

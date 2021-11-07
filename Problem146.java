import java.util.LinkedList;
import java.util.Queue;

public class Problem146 {
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

    private static Node CreateTree() {
        Node root = new Node(0);
        Node left = new Node(1);
        Node right = new Node(0);
        right.right = new Node(0);
        right.left = new Node(1);
        right.left.left = new Node(0);
        right.left.right = new Node(0);
        root.left = left;
        root.right = right;
        return root;
    }
    public static void main(String[] args){
        Node root = CreateTree();
        PrintTreeLevelWise(root);
        System.out.println();
        PruneTree(root);
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

    private static boolean PruneTree(Node root) {
        if(root==null){
            return true;
        }

        if(PruneTree(root.left)){
            root.left=null;
        }
        if(PruneTree(root.right)){
            root.right=null;
        }

        if(root.data==1){
            return false;
        }
        else {
            return PruneTree(root.left)&&PruneTree(root.right);
        }
    }
}

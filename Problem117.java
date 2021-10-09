import java.util.LinkedList;
import java.util.Queue;

public class Problem117 {
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
        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        int level = FindMinLevel(root);
        System.out.println(level);
    }

    private static int FindMinLevel(Node root) {
        if (root == null)
            return 0;
        int level = 0;
        int ans=0;
        int min_sum = root.data;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty())
        {
            int count = q.size();
            int sum = 0;
            while (count-- > 0) {
                Node temp = q.poll();
                sum = sum + temp.data;
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
            if(sum<min_sum){
                min_sum=sum;
                ans = level;
            }
            level++;
        }
        return ans;
    }
}

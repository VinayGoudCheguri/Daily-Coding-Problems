public class Problem_80 {
    static char ans;
    static int max_level = -1;
    public static class Node{
        char data;
        Node left,right;

        public Node(char data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private static char FindDeepestNode(Node root) {
        FindDeepestNodeHelper(root,0);
        return ans;
    }

    private static void FindDeepestNodeHelper(Node node, int level) {
        if(node!=null){
            if(level>max_level){
                max_level = level;
                ans = node.data;
            }
            level++;
            FindDeepestNodeHelper(node.left,level);
            FindDeepestNodeHelper(node.right,level);
        }
    }

    public static void main(String[] args){
        Node root = new Node('a');
        root.left = new Node('b');
        root.right = new Node('c');
        root.left.left = new Node('d');
        char ans = FindDeepestNode(root);
        System.out.println("Deepest node is " + ans);
    }

}

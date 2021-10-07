public class Problem115 {
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
        Node root1 = new Node(20);
        root1.left = new Node(15);
        root1.right = new Node(25);
        root1.left.right = new Node(18);

        Node root2 = new Node(10);
        root2.left = new Node(5);
        root2.right = new Node(20);
        root2.left.left = new Node(2);
        root2.right.left = new Node(15);
        root2.right.right = new Node(25);
        root2.right.left.right = new Node(18);
        System.out.println(IsSubtree(root2,root1));

    }

    private static boolean IsSubtree(Node T, Node S) {
        if (S == null)
            return true;

        if (T == null)
            return false;

        /* Check the tree with root as current node */
        if (areIdentical(T, S))
            return true;

        /* If the tree with root as current node doesn't match then
           try left and right subtrees one by one */
        return IsSubtree(T.left, S) || IsSubtree(T.right, S);
    }

    private static boolean areIdentical(Node t, Node s) {
        if (t == null && s == null)
            return true;

        if (t == null || s == null)
            return false;
        if(t.data!=s.data)
            return false;
        return areIdentical(t.left,s.left)&&areIdentical(t.right,s.right);
    }
}

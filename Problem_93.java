public class Problem_93 {
    static int SIZE = 0;
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class NodeDetails{
        int min,max,size;
        boolean isBST;
        public NodeDetails(int min, int max, int size, boolean isBST) {
            this.min = min;
            this.max = max;
            this.size = size;
            this.isBST = isBST;
        }
    }

    public static void main(String[] args){
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(20);
        root.left.left = new Node(2);
        root.right.left = new Node(15);
        root.right.right = new Node(25);
        root.right.left.right = new Node(18);
        PostOrderTraversal(root);
        System.out.println("Size of largest BST in given tree is "+ SIZE);
    }

    private static NodeDetails PostOrderTraversal(Node root) {
        if(root==null){
            return new NodeDetails(Integer.MAX_VALUE,Integer.MIN_VALUE,0,true);
        }
        NodeDetails left = PostOrderTraversal(root.left);
        NodeDetails right = PostOrderTraversal(root.right);
        int cur_min = Math.min(root.data,Math.min(left.min,right.min));
        int cur_max = Math.max(root.data,Math.max(left.max,right.max));
        boolean cur_isBST = false;
        int cur_size=0;
        if(left.isBST&&right.isBST&&(left.max<root.data)&&(right.min>root.data)){
            cur_isBST = true;
            cur_size = left.size+ right.size+1;
        }
        NodeDetails current = new NodeDetails(cur_min,cur_max,cur_size,cur_isBST);
        SIZE = Math.max(SIZE,current.size);
        return current;
    }

}

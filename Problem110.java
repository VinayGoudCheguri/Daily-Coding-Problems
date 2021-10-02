import java.util.ArrayList;

public class Problem110 {
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
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        ArrayList<ArrayList<Integer>> al =  FindAllPaths(root);
        al.stream().forEach(l-> System.out.println(l));
    }

    private static ArrayList<ArrayList<Integer>> FindAllPaths(Node root) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        ArrayList<Integer> l = new ArrayList<>();
        FindAllPathsHelper(root,l,al);
        return al;
    }

    private static void FindAllPathsHelper(Node node, ArrayList<Integer> l, ArrayList<ArrayList<Integer>> al) {
        l.add(node.data);
        if(node.right==null&&node.left==null){
            al.add(l);
            return;
        }
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right= new ArrayList<>();
        for (int i:l){
            left.add(i);
            right.add(i);
        }
        FindAllPathsHelper(node.left,left,al);
        FindAllPathsHelper(node.right,right,al);
    }


}

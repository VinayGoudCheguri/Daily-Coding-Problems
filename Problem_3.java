import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem_3 {
	public static StringBuilder sb;
	public static class Node {
		int val;
	    Node left;
	    Node right;
	    Node(int x) { 
	    	val = x; 
	    	}
	}
	// serializes the tree into a string
    public static String serialize(Node root) {
        sb = new StringBuilder();
        serializeSolver(root);

        return sb.toString();
    }

    private static void serializeSolver(Node root) {
        if (root == null) {
            sb.append("null").append(",");
            return;
        }

        sb.append(root.val).append(",");
        serializeSolver(root.left);
        serializeSolver(root.right);
    }
	// deserializes the string into the tree
    public static Node deserialize(String s) {
        if (s.length() == 0) {
            return null;
        }

        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(s.split(",")));

        return deserializeSolver(queue);
    }
    private static Node deserializeSolver(Queue<String> queue) {
        String val = queue.remove();
        if (val.equals("null")) {
            return null;
        }

        Node node = new Node(Integer.parseInt(val));
        node.left = deserializeSolver(queue);
        node.right = deserializeSolver(queue);

        return node;
    }
    /////////////////////////////////
    public static void main(String args[])
    {
        Node node = new Node(2);
        node.left = new Node(3);
        node.right = new Node(4);
        node.left.left = new Node(5);
        node.left.right = new Node(6);
        node.left.right.left = new Node(7);
        node.left.right.right = new Node(8);
        // converts above binary tree to string
        String s = serialize(node);
        System.out.println("Serialized form of the binary tree is ");
        System.out.println(s);
        // converts string to binary tree
        Node node_2 = deserialize(s);
    }
}



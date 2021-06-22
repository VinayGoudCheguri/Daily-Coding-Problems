
public class Problem_8 {
	public static class Node {
		int value;
	    Node left;
	    Node right;
	    Node(int x) { 
	    	value = x; 
	    	left = null;
	    	right = null;
	    	}
	}
	
	public static class Count{
		int count=0;
	}
	
	public static boolean count_unival(Node node,Count c) {
		// if node is null
		if(node==null) {
			return true;
		}
		//checking for left and right subtrees
        boolean left = count_unival(node.left, c);
        boolean right = count_unival(node.right, c);
        // if values aren't same for parent and child nodes
		if(((node.left!=null)&&(node.value!=node.left.value))||((node.right!=null)&&(node.value!=node.right.value))) {
			return false;
		}
		if(left==true&&right==true) {
		c.count++;
		return true;
		}
		else {
			return false;
		}
	}
	
	public static int Solve(Node node) {
		Count c = new Count();
		boolean bool=count_unival(node,c);
		return c.count;
	}
	public static void main(String[] args) {
        Node node = new Node(0);
        node.left = new Node(1);
        node.right = new Node(0);
        node.right.left = new Node(1);
        node.right.right = new Node(0);
        node.right.left.left = new Node(1);
        node.right.left.right = new Node(1);
        int ans = Solve(node);
        System.out.println("The number of unival subtress is "+ans);
	}

}

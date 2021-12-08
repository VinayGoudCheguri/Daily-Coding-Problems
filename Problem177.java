public class Problem177 {
  static class Node{
    int data;
    Node next;
    public Node(int val) {
      this.data = val;
    }
  }

  public static void main(String[] args){
      Node root = CreateList(new int[]{7,7,3,5});
      Print(root);
      Node rotatedListroot = rotate(root,2);
      Print(rotatedListroot);
  }

  private static void Print(Node node) {
    while (node.next!=null){
      System.out.print(node.data+"->");
      node = node.next;
    }
    System.out.println(node.data);
  }

  private static Node rotate(Node root, int i) {
    Node tail = getLastElement(root);
    while (i>0){
      Node next = root.next; // taking first element
      root.next = null;
      tail.next = root; // adding first element after last node
      tail = tail.next;
      root = next;
      i--;
    }
    return root;
  }

  private static Node getLastElement(Node root) {
    while (root.next!=null){
      root = root.next;
    }
    return root;
  }

  private static Node CreateList(int[] arr) {
    Node head = null;
    Node node = null;
    for (int val : arr) {
      if (node == null)
        node = new Node(val);
      else {
        node.next = new Node(val);
        node = node.next;
      }
      if (head == null)
        head = node;
    }
    return head;
  }


}

public class Problem179 {
  static class Node
  {
    int data;
    Node left, right;

    Node(int data)
    {
      this.data = data;
      left = right = null;
    }
  }

    public static void main(String[] args){
      int arr[] = {2, 4, 3, 8, 7, 5};
      Node root = ReversePOT(arr);
      PostOrderTraversal(root);
    }

  private static void PostOrderTraversal(Node root) {
    if (root == null) {
      return;
    }
    PostOrderTraversal(root.left);
    PostOrderTraversal(root.right);
    System.out.print(root.data+" ");
  }

  private static Node ReversePOT(int[] arr) {
    Node root = new Node(arr[arr.length-1]);
    int index= arr.length-1;
    int start =0;
    ReversePOTHelper(arr,start,index,root);
    return root;
  }

  private static void ReversePOTHelper(int[] arr, int start, int index, Node root) {
    if(index==0){
      return;
    }
    for (int i=index-1;i>=start;i--){
      if(arr[i]<arr[index]){
        root.right = new Node(arr[index-1]);
        ReversePOTHelper(arr,i+1,index-1,root.right);
        root.left = new Node(arr[i]);
        ReversePOTHelper(arr,start,i,root.left);
        break;
      }
      if(i==start){
        root.right = new Node(arr[index-1]);
        ReversePOTHelper(arr,i+1,index-1,root.right);
      }
    }
  }
}

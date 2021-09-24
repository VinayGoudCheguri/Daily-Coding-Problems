import java.util.ArrayList;

public class Problem102 {
    public static void main(String[] args){
        int arr[] = {1, 2, 3, 4, 5};
        int K = 9;
        ArrayList<Integer> al = FindContiguousElements(arr,K);
        al.stream().forEach(x->System.out.print(x+" "));
    }

    private static ArrayList<Integer> FindContiguousElements(int[] arr, int k) {
        ArrayList<Integer> al = new ArrayList<>();
        int left =0,right=0;
        int sum = arr[0];
        while(left< arr.length-1&&right< arr.length){
            if(sum==k){
                break;
            }
            if(sum<k){
                right++;
                sum+= arr[right];
            }
            if(sum>k) {
                sum-=arr[left];
                left++;
            }
        }
        for(int i=left;i<=right;i++){
            al.add(arr[i]);
        }
        return al;
    }
}

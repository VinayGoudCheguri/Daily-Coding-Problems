import java.util.Arrays;

public class Problem147 {
    public static void main(String[] args){
        int arr[] = {3,6,5,1,2,4};
        Sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void Sort(int[] arr) {
        int left =0;
        int right = arr.length-1;
        while (left<right){
            for (int i =left;i<right;i++){
                if(arr[i]>arr[i+1]){
                    reverse(arr,i,i+1);
                }
            }
            right--;
            for (int i = right;i>left;i--){
                if(arr[i]<arr[i-1]){
                    reverse(arr,i-1,i);
                }
            }
            left++;
        }
    }

    private static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }
}

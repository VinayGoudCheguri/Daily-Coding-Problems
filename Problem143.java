public class Problem143 {
    public static void main(String[] args){
        int arr[] = {9, 12, 3, 5, 14, 10, 10};
        SplitList(arr,10);
        for (int i:arr){
            System.out.print(i+" ");
        }
    }

    private static void SplitList(int[] arr, int x) {
        int left = 0;
        int right = arr.length-1;
        int i=0;
        while (i< arr.length&&i<right) {
            if(arr[i]<x){
                Swap(arr,i,left);
                left++;
            }
            else if(arr[i]>x){
                Swap(arr,i,right);
                right--;
            }
            i++;
        }
    }

    private static void Swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

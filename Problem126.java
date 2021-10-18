public class Problem126 {
    public static void main(String[] args){
        int arr[] = {1, 2, 3, 4, 5, 6};
        int k = 2;
        RotateArray(arr,k);
        for (int i =0;i< arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
    }

    private static void RotateArray(int[] arr, int k) {
        int length = arr.length;
        for (int i =0;i< length-k;i++){
            Swap(arr,i%length,(i+k)%length);
        }
    }

    private static void Swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

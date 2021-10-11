public class Problem118 {
    public static void main(String[] args){
        int arr[] = {-9, -2, 0, 2, 3};
        int arr_sq[] = SquareElements(arr);
        for (int i:arr_sq){
            System.out.print(i+" ");
        }
    }

    private static int[] SquareElements(int[] arr) {
        int neg_num = 0;
        for (int i=0;i< arr.length;i++){
            if(arr[i]<0){
                neg_num++;
            }
            else {
                break;
            }
        }
        for (int i=0;i< arr.length;i++){
            arr[i] = arr[i]*arr[i];
        }
        int left = neg_num-1;
        int right = neg_num;
        int sq_arr[] = new int[arr.length];
        int i=0;
        while (left>=0 && right< arr.length){
            if(arr[left]<arr[right]){
                sq_arr[i] = arr[left];
                left--;
            }
            else {
                sq_arr[i] = arr[right];
                right++;
            }
            i++;
        }
        if(left>=0){
            while (i< arr.length){
                sq_arr[i] = arr[left];
                left--;
                i++;
            }
        }
        else {
            while (i< arr.length){
                sq_arr[i] = arr[right];
                right++;
                i++;
            }

        }
        return sq_arr;
    }
}

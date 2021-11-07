public class Problem144 {
    public static void main(String[] args){
        int arr[] = {4, 1, 3, 5, 6};
        int index =0;
        System.out.println(NextNearestLargestNumber(arr,index));
    }

    private static int NextNearestLargestNumber(int[] arr, int index) {
        int left = index-1;
        int right = index+1;
        while (left>0||right<arr.length){
            if(left>0&&arr[left]>arr[index]){
                return index-left;
            }
            if(right<arr.length&&arr[right]>arr[index]){
                return right-index;
            }
            left--;
            right++;
        }
        return -1;
    }
}

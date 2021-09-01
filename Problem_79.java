public class Problem_79 {
    private static boolean IsNonDecreasing(int[] arr) {
        int chances =1;
        for(int i=1;i< arr.length;i++){
            if(arr[i]<arr[i-1]){
                if(chances==1){
                    chances--;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        int arr[] = {10, 5, 1};
        if(IsNonDecreasing(arr)){
            System.out.println("True");
        }
        else {
            System.out.println("False");
        }
    }

}

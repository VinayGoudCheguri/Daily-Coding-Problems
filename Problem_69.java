public class Problem_69 {
    private static int MaxProduct(int[] arr) {
        int[] leftmax = new int[arr.length];
        int[] rightmax = new int[arr.length];
        int[] leftmin = new int[arr.length];
        int[] rightmin = new int[arr.length];
        Leftmax(arr,leftmax);
        Rightmax(arr,rightmax);
        Leftmin(arr,leftmin);
        Rightmin(arr,rightmin);
        int max = 0;
        for(int i=1;i<arr.length-1;i++){
            int temp1 = leftmax[i]*arr[i]*rightmax[i];
            int temp2 = leftmin[i]*arr[i]*rightmax[i];
            int temp3 = leftmax[i]*arr[i]*rightmin[i];
            int temp4 = leftmin[i]*arr[i]*rightmin[i];
            int tempmax1 = Math.max(temp1,temp2);
            int tempmax2 = Math.max(temp3,temp4);
            int tempmax = Math.max(tempmax1,tempmax2);
            max = Math.max(tempmax,max);
        }
        return max;
    }

    private static void Rightmin(int[] arr, int[] rightmin) {
        int n = arr.length;
        rightmin[n-1] = 0;
        rightmin[n-2]=arr[n-1];
        for (int i=n-3;i>=0;i--){
            rightmin[i] = Math.min(rightmin[i + 1], arr[i + 1]);
        }
    }

    private static void Leftmin(int[] arr, int[] leftmin) {
        leftmin[0] = 0;
        leftmin[1]=arr[0];
        for (int i=2;i<arr.length;i++){
            leftmin[i] = Math.min(leftmin[i - 1], arr[i - 1]);
        }
    }

    private static void Rightmax(int[] arr, int[] rightmax) {
        int n = arr.length;
        rightmax[n-1] = 0;
        rightmax[n-2]=arr[n-1];
        for (int i=n-3;i>=0;i--){
            rightmax[i] = Math.max(rightmax[i + 1], arr[i + 1]);
        }
    }

    private static void Leftmax(int[] arr, int[] leftmax) {
        leftmax[0] = 0;
        leftmax[1]=arr[0];
        for (int i=2;i<arr.length;i++){
            leftmax[i] = Math.max(leftmax[i - 1], arr[i - 1]);
        }
    }

    public static void main(String[] args){
        int[] arr = {-10, -10, 5, 2};
        int ans = MaxProduct(arr);
        System.out.println("Answer is "+ans);
    }
}

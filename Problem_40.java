
public class Problem_40 {
    private static int Solution(int[] arr) {
        int ans =0;
        int sum;
        // Considering 32 bits
        for(int i = 0; i <32; i++){
            int temp = 1<<i;// moving 1 in bit representation by i digits towards left
            sum = 0;// sum counts no of 1s in bit sum of all numbers at ith place
            for(int j = 0; j < arr.length; j++){
                if((arr[j]&temp)!=0){
                    sum++;
                }
            }
            sum = sum%3; // Only non repeating number contribution remains (0 or 1)
            if(sum==1){
                ans = ans|temp;
            }
        }
        return ans;
    }

    public static void main(String []args){
        int arr[] = {13, 19, 13, 13};
        int ans = Solution(arr);
        System.out.println("The non-duplicated integer is "+ans);
    }

}

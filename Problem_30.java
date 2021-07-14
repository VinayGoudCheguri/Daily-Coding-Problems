public class Problem_30 {

    private static int Trapped_water(int[] arr) {
        int ans = 0,temp;
        int size = arr.length;
        int[] lb = new int[size];
        int[] rb = new int[size];
        // finding left boundaries
        lb[0] = 0;
        for (int i = 1;i<size-1;i++){
            lb[i] = Math.max(lb[i-1],arr[i-1]);
        }
        // finding right boundaries
        rb[size-1]=0;
        for (int i = size-2;i>0;i--){
            rb[i] = Math.max(rb[i+1],arr[i+1]);
        }
        // calculating amount of water trapped
        for (int i = 1;i<size-1;i++){
            temp = Math.min(lb[i],rb[i])-arr[i];
            if(temp>0){
                ans+=temp;
            }
        }
        return ans;
    }

    public static void main(String []args) {
        int []arr = {3, 0, 1, 3, 0, 5};
        int ans = Trapped_water(arr);
        System.out.println("Amount of water trapped is "+ans+" units");
    }

}

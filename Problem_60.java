
public class Problem_60 {
    private static boolean CanBePartitioned(int[] arr) {
        int sum = 0;
        int n = arr.length;;
        for(int i:arr){
            sum+=i;
        }
        if (sum%2!=0){
            return false;
        }
        else {
            sum = sum/2;
            boolean[] Possibility = new boolean[sum+1];
            for(int i = 0; i <= sum; i++) {
                Possibility[i] = false;
            }

            for(int i = 0; i < n; i++)
            {
                for(int j = sum ; j >= arr[i]; j--)
                {
                    // we use left side element to find right side ones in table
                    // hence moving from right towards left as we are overriding rows to maintain single row
                    if (Possibility[j - arr[i]] == true || j == arr[i])
                        Possibility[j] = true;
                }
            }
            return Possibility[sum];
        }
    }

    public static void main(String[] args){
        int[] arr = {15, 5, 20, 10, 35, 15, 10};
        if(CanBePartitioned(arr)){
            System.out.println("Given array can be partitioned into two subsets whose sums are the same");
        }
        else {
            System.out.println("Given array can't be partitioned into two subsets whose sums are the same");
        }
    }

}

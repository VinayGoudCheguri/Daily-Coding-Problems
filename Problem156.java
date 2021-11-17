import java.util.Arrays;

public class Problem156 {
    public static void main(String[] args){
        int n = 13;
        System.out.println(SmallestSquaredIntegers(n));
    }

    private static int SmallestSquaredIntegers(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        for (int i =2;i<dp.length;i++){
            for (int j = 1;j<i;j++){
                if(j*j<=i){
                    dp[i] = Math.min(dp[i],dp[i-j*j]+1);
                }
            }
        }
        return dp[n];
    }
}

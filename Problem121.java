public class Problem121 {
    public static void main(String[] args){
        String str = "waterrfetawx";
        int k = 2;
        System.out.println(MakePalindrome(str,k));
    }

    private static boolean MakePalindrome(String str, int k) {
        int length = str.length();
        String rev_str = ReverseString(str);
        int dp[][] = new int[length+1][length+1];
        for (int i=0;i<=length;i++){
            dp[0][i] = i;
            dp[i][0] = i;
        }
        for(int i=1;i<=length;i++){
            for(int j=1;j<=length;j++){
                if(str.charAt(i-1)==rev_str.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else {
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+1;
                }
            }
        }
        if (dp[length][length]/2>k){
            return false;
        }
        else {
            return true;
        }
    }

    private static String ReverseString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.reverse();
        return sb.toString();
    }
}

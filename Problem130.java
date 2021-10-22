public class Problem130 {
    public static void main(String[] args){
        int k = 2;
        int stockPrices[] = {5, 2, 4, 0, 1};
        System.out.println(FindMaxProfit(stockPrices,k));
    }

    private static int FindMaxProfit(int[] stockPrices, int k) {
        int length = stockPrices.length;
        int profits[][] = new int[length][k+1];
        for (int i = 0; i <= k; i++){
            profits[0][i] = 0;
        }
        for (int i = 0; i < length; i++){
            profits[i][0] = 0;
        }
        for (int i = 1; i <= k; i++){
            for (int j = 1; j < length; j++){
                int max_profit = 0;
                for(int m =0;m<j;m++){
                    max_profit = Math.max(max_profit,profits[m][i-1]+stockPrices[j]-stockPrices[m]);
                    profits[j][i] = Math.max(max_profit,profits[j-1][i]);
                }
            }
        }
        return profits[length-1][k];
    }
}

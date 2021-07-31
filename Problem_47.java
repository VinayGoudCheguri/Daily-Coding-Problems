public class Problem_47 {
    private static int Max_Profit(int[] stock_prices) {
        int min = stock_prices[0];
        int cur_profit = 0;
        for(int i=1;i<stock_prices.length;i++){
            if(stock_prices[i]<min){
                min = stock_prices[i];
            }
            cur_profit = Math.max(cur_profit,stock_prices[i]-min);
        }
        return cur_profit;
    }

    public static void main(String[] args) {
        int[] stock_prices = {9, 11, 8, 5, 7, 10};
        int ans = Max_Profit(stock_prices);
        System.out.println("The maximum profit is " + ans);
    }
}

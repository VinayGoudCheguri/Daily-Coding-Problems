public class Problem122 {
    public static void main(String[] args){
        int matrix[][] = {{0,3,1,1},
                {2,0,0,4},
                {1,5,3,1}};
        System.out.println(MaxCoins(matrix));
    }

    private static int MaxCoins(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int coins[][] = new int[rows][columns];
        for (int i=0;i<rows;i++){
            coins[i][0] = matrix[i][0];
        }
        for (int i=0;i<columns;i++){
            coins[0][i] = matrix[0][i];
        }
        for (int i=1;i<rows;i++){
            for (int j=1;j<columns;j++){
                coins[i][j] = matrix[i][j] + Math.max(coins[i-1][j],coins[i][j-1]);
            }
        }
        return coins[rows-1][columns-1];
    }
}

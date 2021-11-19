public class Problem158 {
    public static void main(String[] args) {
        int[][] board = {
                { 0, 0, 1 },
                { 0, 0, 1 },
                { 1, 0, 0 } };
        System.out.println(countWays(board));
    }

    private static int countWays(int[][] board) {
        int height = board.length;
        int width = board[0].length;
        int ways[][] = new int[height][width];

        int way=1;
        for (int i = 0; i < height; i++) {
            if(board[i][0]==1){
                way = 0;
            }
            ways[i][0] = way;
        }

        way=1;
        for (int j = 0; j < width; j++) {
            if(board[0][j]==1){
                way = 0;
            }
            ways[0][j] = way;
        }

        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                if(board[i][j]==1){
                    ways[i][j]=0;
                }else {
                    ways[i][j] = ways[i-1][j]+ways[i][j-1];
                }
            }
        }
        return ways[height-1][width-1];
    }
}

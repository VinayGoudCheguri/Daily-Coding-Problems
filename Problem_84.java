public class Problem_84 {
    private static int NoOfIslands(int[][] matrix) {
        int ROW = matrix.length;
        int COL = matrix[0].length;
        boolean visited[][] = new boolean[ROW][COL];
        int islands = 0;
        for (int i = 0; i < ROW; ++i) {
            for (int j = 0; j < COL; ++j) {
                if (matrix[i][j] == 1 && !visited[i][j])
                {
                    DFS(matrix, i, j, visited);
                    islands++;
                }
            }
        }
        return islands;
    }

    private static void DFS(int[][] matrix, int i, int j, boolean[][] visited) {
        // Entire island is visited when DFS is implemented
        int x[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
        int y[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };
        visited[i][j] = true;
        for (int k = 0; k < 8; ++k) {
            if (isSafe(matrix, i + x[k], j + y[k], visited)) {
                DFS(matrix, i + x[k], j + y[k], visited);
            }
        }
    }

    static boolean isSafe(int matrix[][], int row, int col, boolean visited[][]) {
        int ROW = matrix.length;
        int COL = matrix[0].length;
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && (matrix[row][col] == 1 && !visited[row][col]);
    }
    public static void main(String[] args){
        int matrix[][] = new int[][] {{ 1, 0, 0, 0, 0 },
                { 0, 0, 1, 1, 0 },
                { 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0 },
                { 1, 1, 0, 0, 1 },
                { 1, 1, 0, 0, 1 }};
        int ans = NoOfIslands(matrix);
        System.out.println("The number of islands is "+ ans);
    }

}

public class Problem_64 {
    public static class Count{
        int count =0;
    }

    static boolean isSafe(int x, int y, int board[][],int N)
    {
        if (x >= 0 && x < N && y >= 0 && y < N && board[x][y] == 0){
            return true;
        }
        return false;
    }

    private static void Solve(int i, int j, int N,Count C) {
        int[][] board = new int[N][N];
        board[i][j]=1;
        Count C2 = new Count();
        C2.count = 1;
        if(SolveHelper(board,i,j,N,C)){
            C.count++;
        }
    }

    private static boolean SolveHelper(int[][] board, int i, int j,int N,Count C) {
        int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
        for (int l =0;l<8;l++){
            if(isSafe(xMove[l]+i,yMove[l]+j,board,N)){
                board[xMove[l]+i][yMove[l]+j]=1;
                if(SolveHelper(board,xMove[l]+i,yMove[l]+j,N,C)){
                    return true;
                }
            }
        }
        if (Verify(board,N)){
            return true;
        }
        else {
            return false;
        }
    }

    private static boolean Verify(int[][] board,int N) {
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                if(board[i][j]!=1){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        int N =8;
        Count C = new Count();
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                Solve(i,j,N,C);
            }
        }
        System.out.println("The number of Knight's tours is " + C.count);
    }

}

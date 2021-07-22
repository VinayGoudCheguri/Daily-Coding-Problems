import java.util.Scanner;

public class Problem_38 {
    private static boolean IsSafe(int[][] chess_board, int row, int col) {
        int i, j;
        // lying on same column
        for (i = 0; i < col; i++) {
            if (chess_board[row][i] == 1)
                return false;
        }
        // lying on upper left diagonal
        for (i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--) {
            if (chess_board[i][j] == 1)
                return false;
        }
        // lying on lower left diagonal
        for (i = row+1, j = col-1; j >= 0 && i < chess_board[0].length; i++, j--) {
            if (chess_board[i][j] == 1)
                return false;
        }
        return true;
    }

    private static int FindAllArrangements(int[][] chess_board, int row, int col) {
        int count = 0;
        int N = chess_board.length;
        for(int i = 0;i<N;i++){
            chess_board[i][0]=1;
            if(Solve(chess_board,1)){
                count++;
            }
            chess_board[i][0]=0;
        }
        return  count;
    }

    private static boolean Solve(int[][] chess_board, int col) {
        int N = chess_board.length;
        for(int i=0;i<N;i++){
            if(IsSafe(chess_board,i,col)) {
                if(col==N-1){
                    return true;
                }
                chess_board[i][col] = 1;
                if(Solve(chess_board,col+1)){
                    chess_board[i][col] = 0;
                    return true;
                }
                chess_board[i][col] = 0;
            }
        }
        return false;
    }

    public static void main(String []args){
        int N;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of N");
        N = sc.nextInt();
        int chess_board[][] = new int[N][N];
        int ans = FindAllArrangements(chess_board,0,0);
        System.out.println("The number of possible arrangements is "+ans);
    }
}

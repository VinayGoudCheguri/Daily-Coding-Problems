import java.util.Arrays;
import java.util.Scanner;

public class Problem_38 {
    public static class Count {
        int count = 0;
    }

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

    private static void FindAllArrangements(int[][] chess_board, Count ans,int row,int col) {
        int N = chess_board[0].length;
        if(row==N){
            if(col==0){
                return;
            }
            else {
                row = FindLastQueenRow(chess_board, col-1);
                chess_board[row][col-1]=0;
                FindAllArrangements(chess_board, ans, row+1, col - 1);
            }
        }
        // After each possible complete arrangement
        if(IsSafe(chess_board,row,col)){
            chess_board[row][col]=1;
            if(col==N-1){
                ans.count++;
                row = FindLastQueenRow(chess_board,0);
                Initialize(chess_board);
                FindAllArrangements(chess_board,ans,row+1,0);
            }
            else{
                FindAllArrangements(chess_board,ans,0,col+1);
            }
        }
        else{// If Queen cannot be added
            if(row<N-1){
                FindAllArrangements(chess_board,ans,row+1,col);
            }
            else if(row==N-1){
                if(col==0){
                    return;
                }
                int pre_row = FindLastQueenRow(chess_board,col-1);
                chess_board[pre_row][col-1]=0;// Previous queen is removed
                FindAllArrangements(chess_board,ans,pre_row+1,col-1);
            }
        }

    }

    private static void Initialize(int[][] chess_board) {
        for (int[] row : chess_board)
            Arrays.fill(row, 0);
    }

    private static int FindLastQueenRow(int[][] chess_board, int col) {
        for(int i = 0;i<chess_board[0].length;i++){
            if(chess_board[i][col]==1){
                return i;
            }
        }
        return chess_board[0].length-1;
    }


    public static void main(String []args){
        int N;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of N");
        N = sc.nextInt();
        int chess_board[][] = new int[N][N];
        Count ans = new Count();
        FindAllArrangements(chess_board,ans,0,0);
        System.out.println("The number of possible arrangements is "+ans.count);
    }

}

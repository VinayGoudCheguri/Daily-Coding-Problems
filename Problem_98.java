public class Problem_98 {
    public static void main(String[] args){
        char[][] board = {
        {'A','B','C','E'},
        {'S','F','C','S'},
        {'A','D','E','E'}};
        System.out.println(exists(board, "ABCB"));
    }

    private static boolean exists(char[][] board, String str) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if(existsHelper(board,visited,i,j,str)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean existsHelper(char[][] board, boolean[][] visited, int i, int j, String str) {
        if(i<0||j<0||i>=board.length||j>=board[0].length){
            return false;
        }
        if(str==null||str.length()==0){
            return true;
        }
        char first_letter = str.charAt(0);
        if(first_letter==board[i][j]&&!visited[i][j]){
            visited[i][j]=true;
            if(existsHelper(board,visited,i+1,j,str.substring(1))){
                return true;
            }
            if(existsHelper(board,visited,i-1,j,str.substring(1))){
                return true;
            }
            if(existsHelper(board,visited,i,j+1,str.substring(1))){
                return true;
            }
            if(existsHelper(board,visited,i,j-1,str.substring(1))){
                return true;
            }
            visited[i][j]=false;
        }
        return false;
    }
}
public class Problem151 {
    static char[][] matrix = {
            {'B','B','W'},
            {'W','W','W'},
            {'W','W','W'},
            {'B','B','B'},
    };
    public static void main(String[] args){
        ReplaceColour(matrix,2,2);
        for (char[] row:matrix){
            for (char c:row){
                System.out.print(c+" ");
            }
            System.out.println();
        }
    }

    private static void ReplaceColour(char[][] matrix, int x, int y) {
        char colour = matrix[x][y];
        matrix[x][y] = 'G';
        if(IsValid(x+1,y)&&matrix[x+1][y]==colour){
            ReplaceColour(matrix,x+1,y);
        }
        if(IsValid(x-1,y)&&matrix[x-1][y]==colour){
            ReplaceColour(matrix,x-1,y);
        }
        if(IsValid(x,y+1)&&matrix[x][y+1]==colour){
            ReplaceColour(matrix,x,y+1);
        }
        if(IsValid(x,y-1)&&matrix[x][y-1]==colour){
            ReplaceColour(matrix,x,y-1);
        }
    }

    private static boolean IsValid(int i, int y) {
        if(0<=i&&i<matrix.length
        &&0<=y&&y<matrix[0].length){
            return true;
        }
        return false;
    }

}

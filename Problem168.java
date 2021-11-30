import java.util.Arrays;

public class Problem168 {
    public static void main(String[] args){
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };
        RotateBy90Degrees(matrix);
        for (int[] row : matrix)
            System.out.println(Arrays.toString(row));

    }

    private static void RotateBy90Degrees(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        // flipping horizontally
        for(int i =0;i<rows;i++){
            for (int j=0,l=columns-1;j<l;j++,l--){
                Swap(matrix,i,j,i,l);
            }
        }
        // flipping diagonally
        for (int i=0;i<columns;i++){
            int rowup=i;
            int rowdown = rows-1;
            int colup = 0;
            int coldown = columns-i-1;
            while (rowup>=0){
                Swap(matrix,rowup--,colup++,rowdown--,coldown++);
            }
        }

    }

    private static void Swap(int[][] matrix, int i, int j, int i1, int l) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[i1][l];
        matrix[i1][l]=temp;
    }
}

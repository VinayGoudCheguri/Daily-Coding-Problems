public class Problem136 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 0, 0},
                {1, 0, 1, 1},
                {1, 0, 1, 1},
                {0, 1, 0, 0}};
        System.out.println(AreaOfLargestRectangle(matrix));
    }

    private static int AreaOfLargestRectangle(int[][] matrix) {
        int max_area = 0;
        int[] histogram =  new int[matrix[0].length]; // no of columns
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0)
                    histogram[col] = 0;
                else
                    histogram[col]++;
            }

            max_area = Math.max(max_area, CalculateArea(histogram));
        }
        return max_area;
    }

    private static int CalculateArea(int[] histogram) {
        int area = 0;
        for (int i = 0;i<histogram.length;i++){
            if(histogram[i]!=0){
                int height = histogram[i];
                int j = i+1;
                while (j<histogram.length&&histogram[j]>0){
                    height = Math.min(height,histogram[j]);
                    area = Math.max(area,height*(j-i+1));
                    j++;
                }
                if(j==i+1){
                    area = Math.max(area,1);
                }
            }
        }
        return area;
    }
}

public class Problem_65 {
    private static void PrintSpiral(int[][] arr) {
        int m = arr.length; // no of rows
        int n = arr[0].length; // no of columns
        int horiz_left = 0, horiz_right = n-1;
        int vert_low = 0, vert_high = m-1;
        while (horiz_left!=horiz_right&&vert_high!=vert_low){
            for(int i =horiz_left;i<=horiz_right;i++){
                System.out.println(arr[vert_low][i]);
            }
            vert_low++;
            for(int i =vert_low;i<=vert_high;i++){
                System.out.println(arr[i][horiz_right]);
            }
            horiz_right--;
            for(int i =horiz_right;i>=horiz_left;i--){
                System.out.println(arr[vert_high][i]);
            }
            vert_high--;
            for(int i =vert_high;i>=vert_low;i--){
                System.out.println(arr[i][horiz_left]);
            }
            horiz_left++;
        }
    }

    public static void main(String[] args){
        int[][] arr = {{1,  2,  3,  4,  5},
                {6,  7,  8,  9,  10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}};
        PrintSpiral(arr);
    }
}

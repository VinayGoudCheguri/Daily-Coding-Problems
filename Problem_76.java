public class Problem_76 {
    public static void main(String[] args){
        char[][] arr = {{'c','b','a'},
                {'d','a','f'},
                {'g','h','i'}};
        int ans = RemoveColumns(arr);
        System.out.println(ans+" columns are removed");
    }

    private static int RemoveColumns(char[][] arr) {
        int ans =0;
        for(int col=0;col<arr.length;col++){
            for(int row=1;row<arr.length;row++){
                if(arr[row][col]<arr[row-1][col]){ //checks if each column is lexographic
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }

}

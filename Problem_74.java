public class Problem_74 {
    private static int[][] CreateTable(int N) {
        int[][] table = new int[N][N];
        for(int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                table[i][j] = (i+1)*(j+1);
            }
        }
        return table;
    }

    private static int FindX(int[][] table, int X, int N) {
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (table[i][j] == X) {
                    ans = ans + 2;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if (table[i][i] == X) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        int N = 6,X =12;
        int[][] table = CreateTable(N);
        int ans = FindX(table,X,N);
        System.out.println(X + " appears "+ ans +" times in the table");
    }
}

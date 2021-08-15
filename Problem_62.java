public class Problem_62 {
    public static class Count{
        int count =0;
    }

    private static void FindPaths(int n, int m, int i, int j,Count C) {
            if(i==n-1||j==m-1){
                C.count++;
            }
            else{
                FindPaths(n, m, i+1, j, C);
                FindPaths(n, m, i, j+1, C);
            }
    }

    public static void main(String[] args){
        int n=5,m=5;
        Count C = new Count();
        FindPaths(n,m,0,0,C);
        System.out.println("Total number of paths is "+ C.count);
    }

}

public class Problem_12 {

    static int countWays(int n, int[] X)
    {
    	int A[] = new int[n+1];
        A[0] = 1;
        A[1] = 1;
        int m = X.length;
        for (int i = 2; i <n+1; i++) {
            A[i] = 0;
            for (int j = 0; j <m && X[j]<= i; j++) {
                A[i]+= A[i - X[j]];
            }
        }
        return A[n];
    }
 
    public static void main(String[] args)
    {
        int n = 4; // no of steps
        int X[] = {1,2}; //steps at a time
        System.out.println("Number of unique ways = "+ countWays(n, X));
    }
}


public class Problem_9 {

	public static int Solver(int[] A) {
		int incl = A[0];
		int excl = 0;
		int n = A.length;
		int excl_updated;
        for (int i = 1; i < n; i++)
        {
            excl_updated = Math.max(incl, excl);
            incl = excl +A[i];
            excl = excl_updated;
        }
        return Math.max(incl, excl);
	}
	public static void main(String[] args) {
		int A[] = new int[]{5, 1, 1, 5};
		int max_sum = Solver(A);
		System.out.println("largest sum of non-adjacent numbers is "+max_sum);

	}

}

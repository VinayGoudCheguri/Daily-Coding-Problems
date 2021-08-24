import java.util.Scanner;
public class Problem_2{
    static void Solver(int A[],int n){
        if (n == 1) {
			System.out.print(0);
			return;
		}
	int left[] = new int[n]; // contains product of left side elements
	int right[] = new int[n];// contains product of right side elements
	int ans[] = new int[n]; // required array
	left[0] = 1;
	right[n-1] = 1;
	for (int i = 1; i < n; i++){ // creating left array
		left[i] = A[i - 1] * left[i - 1];
	}
	for (int i = n - 2; i >= 0; i--){ // creating right array
		right[i] = A[i + 1] * right[i + 1];
	}
	for (int i = 0; i < n; i++){ // creating answer array
		ans[i] = left[i]*right[i];
	}
	// Displaying array
	for (int i = 0; i < n; i++){
		System.out.print(ans[i] + " ");
	}
	return;
    }
     public static void main(String []args){
        /*int A[] = { 1, 2, 3, 4, 5};
	int n = A.length;
	*/
	Scanner scnr = new Scanner(System.in);
	System.out.println("Enter the size of input array");
	int n = scnr.nextInt();
	int[] A = new int[n];
	System.out.println("Enter the input array");
	for(int i = 0;i<n;i++){
		A[i] = scnr.nextInt();
	}
	System.out.println("The product array is : ");
	Solver(A,n);
     }
}

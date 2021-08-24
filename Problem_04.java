import java.util.Scanner;

public class Problem_4 {
	// Solver1 pushes negative integers to left side
	// and returns count of negative numbers
	public static int Solver1(int A[],int size) {
		int count =0;
		int temp;
		for(int i=0;i<size;i++) {
			if(A[i]<0) {
				temp = A[count];
				A[count] = A[i];
				A[i] = temp;
				count++;
			}
		}
		return count;
	}
	
	// Solver2 finds the first missing positive integer
	public static int Solver2(int A[],int size,int count) {
		for(int i=0;i<count;i++) {
			A[i] = -A[i];
		}	
		for(int i=count;i<size;i++) {
			if((A[i]<=size)&&(A[i]>0)) {
				A[A[i]-1]=-A[A[i]-1];
			}
		}
		for(int i=0;i<size;i++) {
			if(A[i]>0) {
				return i+1;
			}
		}
		return size+1;
	}
	
	public static void main(String[] args) {
		// taking input array
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array");
		int size = sc.nextInt();
		int[] A = new int[size];
		for(int i=0;i<size;i++) {
			A[i] = sc.nextInt();
		}
		
		// Calling Solver1 to separate negative integers
		int count = Solver1(A,size);
		// Calling Solver2 to find the missing number
		int ans = Solver2(A,size,count);
		System.out.println("The missing number is "+ans);
	}

}

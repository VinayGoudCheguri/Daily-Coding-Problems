import java.util.Deque;
import java.util.LinkedList;

public class Problem_18 {
	public static void printmaxvalues(int arr[],int k) {
		Deque<Integer> dq = new LinkedList<Integer>();
		// dq can hold max of k values
		//dq contains leftmost value as index of max value in each subarray
		int n = arr.length;
		for(int i =0;i<n;i++) {
			dq.addLast(i);
			// when leftmost value comes out of sliding window, it is removed
			// when arr[i]>arr[leftmost value in dq], it is removed
			while((!dq.isEmpty()) && (dq.peek() <=(i - k))||(arr[dq.peek()]<arr[i])) {
				dq.removeFirst();
			}
			// Prints the max value of each sub array
			if(i>=k-1) {
				System.out.println(arr[dq.peek()]);
			}
		}
	}
	public static void main(String[] args) {
		int arr[] = {10, 5, 2, 7, 8, 7,10};
		int k =3;
		System.out.println("maximum values of each subarray are ");
		printmaxvalues(arr,k);
	}
}

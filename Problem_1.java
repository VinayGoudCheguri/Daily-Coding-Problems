import java.io.*;
import java.util.HashSet;

class Problem_1
{
    public static boolean Solve(int A[],int k){
        HashSet<Integer> h = new HashSet<Integer>();
        int temp;
        for (int i =0;i<A.length ; i++) {
            temp = k - A[i];
            if(h.contains(temp)){
                return true;
            }
            else{
                h.add(A[i]);
            }
        }
        return false;
    }
	public static void main(String[] args) {
		int A[] = {10, 15, 3, 7};
		int k = 17;
		System.out.println(Solve(A,k));
	}
}

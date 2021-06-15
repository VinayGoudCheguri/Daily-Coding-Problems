import java.io.*;
import java.util.HashSet;
import java.util.Scanner;

public class Problem_1
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
		/*
		int A[] = {10, 15, 3, 7};
		int k = 17;   */
		///////////////////
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter the size of input array");
		int size = scnr.nextInt();
		int[] A = new int[size];
		System.out.println("Enter the input array");
		for(int i = 0;i<size;i++){
			A[i] = scnr.nextInt();
		}
		System.out.println("Enter the target sum");
		int k = scnr.nextInt();
		///////////////////////
		System.out.println(Solve(A,k));
	}
}

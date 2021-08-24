import java.util.Scanner;

public class Problem_7 {
	// Solve finds the no of ways by recursion
	public static int Solve(char[] A,int n) {
		int count=0;
        if (n == 0 || n == 1) {
            return 1;
        }
        //Considering last digit as 1 alphabet
        //If the last digit is non zero
        if (A[n - 1] > '0') {
            count = Solve(A, n - 1);
        }
        //Considering last 2 digits as 1 alphabet
        if((A[n-2]=='1')||(A[n-2]=='2'&&A[n-1]<='6')) {
        	count+= Solve(A, n - 2);
        }
		return count;
	}
	public static void main(String[] args) {
		System.out.println("Enter the message to be decoded");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        int ans;
        char[] A = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            A[i] = str.charAt(i);
        }
        int n = str.length();
        if(n==0||(n==1&&A[0]==0)) {
        	ans = 0;
        }
        else {
        	ans = Solve(A,n);
        }
        System.out.println("The number of ways message is decoded is "+ans);
	}

}

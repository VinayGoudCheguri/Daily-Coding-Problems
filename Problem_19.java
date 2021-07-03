
public class Problem_19 {
	public static int Solve(int cost[][]) {
		int N = cost.length; // no of houses
		int k = cost[0].length;
		int min_cost[][] = new int[N][k];
		for(int j =0;j<k;j++) {
			min_cost[0][j] = cost[0][j]; // min cost matrix stores min cost till now
		}
		for(int i =1;i<N;i++) {
			for(int j =0;j<k;j++) {
			int temp= Integer.MAX_VALUE;
			//Calculating the minimum value in i-1 row in min_cost matrix excluding jth column
				for(int m =0;m<k;m++) {
					if(m!=j) {
						temp = Math.min(temp,min_cost[i-1][m]);
					}
				}
				// adding cost of ith house, jth colour to previous minimum sum
				min_cost[i][j] = cost[i][j]+temp; 	
			}
		}
		int ans = Integer.MAX_VALUE;
		for(int j=0;j<k;j++) {
			ans = Math.min(ans,min_cost[N-1][j]);
			
		}
		return ans;
	}

	public static void main(String[] args) {
		int cost[][] = { { 14, 2, 10 },{ 10, 14, 4 },{ 12, 13, 10 } };
		int ans = Solve(cost);
		System.out.println("Minimum cost which achieves the required goal is "+ans);
	}

}

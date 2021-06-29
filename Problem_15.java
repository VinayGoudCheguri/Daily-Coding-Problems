import java.util.Random;

public class Problem_15 {
	static int rand = 0; 
	static int count = 0; 
	static int selectRandom(int x)
	{
		count++; 
		if (count == 1)
			rand = x;
		else
		{
			// Generates a random number from 0 to count - 1
			Random r = new Random();
			int i = r.nextInt(count);
			//chance of i = count-1 is 1/count
			if(i == count - 1)
				rand = x;
		}
		return rand;
	}

	public static void main(String[] args) {
		int stream[] = {1, 2, 3, 4,5,6,7,8,9};
		int n = stream.length;
		for(int i = 0; i < n-1; i++) {
			System.out.println("Random number from first " + (i+1) +
							" numbers from stream is " + selectRandom(stream[i]));		
		}
		System.out.println("Final Random number from entire stream is " + selectRandom(stream[n-1]));
	}

}

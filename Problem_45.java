import java.util.Random;

public class Problem_45 {
    static int rand5() {
        int min = 1;
        int max = 5;
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    private static int rand7() {
        int a,b,sum;
        a = rand5();
        b = rand5();
        sum = a+5*(b-1);
        while(sum>21){
            a = rand5();
            b = rand5();
            sum = a+5*(b-1);
        }
        int ans = sum%7+1;
        return ans;
    }

    public static void main(String[] args)
    {
        int ans = rand7();
        System.out.println("Random number from integers from 1 to 7 is "+ans);
    }

}

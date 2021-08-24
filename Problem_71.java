import java.util.Random;

public class Problem_71 {
    public static int rand7(){
        int min = 1;
        int max = 7;
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
    private static int rand5() {
        int n = 5,sum=0;
        do {
            sum = 7*(rand7()-1)+7; // uniform probability for 1 to 49
        }while (sum>45); // uniform probability for 1 to 45 (45 is multiple of 5)
        return sum%5 +1;
    }

    public static void main(String[] args){
        int rand = rand5();
        System.out.println(rand);
    }

}

public class Problem124 {
    public static void main(String[] args){
        int n =100;
        System.out.println(NoOfRounds(n));
    }

    private static int NoOfRounds(int n) {
        int rounds = 0;
        while(n>1){
            n = n/2;
            rounds++;
        }
        return rounds;
    }
}

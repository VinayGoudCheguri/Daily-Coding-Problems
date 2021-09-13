import java.util.HashSet;

public class Problem_90 {
    public static void main(String[] args){
        int n = 100;
        int[] l = {1,4,6,9};
        int rand = GenerateRandom(n,l);
        System.out.println("Generated random number is "+ rand);
    }

    private static int GenerateRandom(int n, int[] l) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i:l){
            hs.add(i);
        }
        int rand = (int)(Math.random()*n);
        while (hs.contains(rand)){
            rand = (int)(Math.random()*n);
        }
        return rand;
    }
}

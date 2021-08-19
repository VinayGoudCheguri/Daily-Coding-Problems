import java.util.Random;

public class Problem_66 {
    // This method return head 75% of the times
    public static String toss_biased(){
        if(Math.random()>0.75){
            return "head";
        }
        else {
            return "tail";
        }
    }

    public static String toss_unbiased(){
        String s1 = toss_biased();
        String s2 = toss_biased();
        while (s1==s2){
            s1 = toss_biased();
            s2 = toss_biased();
        }
        // Now s1 and s2 are different
        // s1 has equal chance to be head or tail
        return s1;
    }

    public static void main(String[] args){
        String  ans = toss_unbiased();
        System.out.println(ans);
    }
}

import java.util.ArrayList;
import java.util.List;

public class Problem167 {
    public static void main(String[] args){
        String[] words = { "code", "edoc", "da", "d" };
        List<Combination> combinations = FindCombinations(words);
        combinations.stream().forEach(c-> System.out.println(c.x+" "+c.y));
    }

    private static List<Combination> FindCombinations(String[] words) {
        List<Combination> combinations = new ArrayList<>();
        for (int i =0;i<words.length;i++){
            for (int j=i+1;j< words.length;j++){
                if(IsPalindrome(words[i].concat(words[j]))){
                    combinations.add(new Combination(i,j));
                }
                if(IsPalindrome(words[j].concat(words[i]))){
                    combinations.add(new Combination(j,i));
                }
            }
        }
        return combinations;
    }

    private static boolean IsPalindrome(String str) {
        for (int i=0,j=str.length()-1;i<j;i++,j--){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
        }
        return true;
    }

    public static class Combination{
        int x,y;
        public Combination(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

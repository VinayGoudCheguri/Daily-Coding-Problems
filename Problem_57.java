import java.util.ArrayList;
import java.util.List;

public class Problem_57 {
    private static List<String> Split(String s, int k) {
        String[] words = s.split(" ");
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (String word:words){
            if(word.length()>k){
                return null;
            }
            else if(sb.length()==0){
                sb = new StringBuilder(word);
            }
            else if(sb.length()+1+word.length()<=k){
                sb.append(" ").append(word);
            }
            else{
                ans.add(sb.toString());
                sb = new StringBuilder(word);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> ans = Split("the quick brown fox jumps over the lazy dog", 10);
        for(String str:ans){
            System.out.println(str);
        }
    }

}

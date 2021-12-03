import java.util.ArrayList;
import java.util.Arrays;

public class Problem172 {

    public static void main(String[] args){
        String s = "dogcatcatcodecatdog";
        String[] words = {"cat", "dog"};
        int[] indices = FindWords(s,words);
        Arrays.stream(indices).forEach(i->System.out.print(i+" "));
    }

    private static int[] FindWords(String s, String[] words) {
        ArrayList<Integer> al = new ArrayList<>();
        for (String word:words){
            int index = FindIndex(word,s);
            if(index!=-1){
                al.add(index);
            }
        }
        return al.stream().mapToInt(i->i).toArray();
    }

    private static int FindIndex(String word, String s) {
        int index = s.indexOf(word);
        if(index==-1){
            return -1;
        }
        else{
            while (s.indexOf(word,index+word.length())==index+word.length()){
                index = s.indexOf(word,index+2*word.length());
            }
            return index;
        }
    }
}

import java.util.ArrayList;

public class Problem111 {
    static int MAX = 256;
    public static void main(String[] args){
        String S = "abxaba";
        String w = "ab";
        ArrayList<Integer> al = FindAnagrams(S,w);
        al.forEach(x->System.out.print(x+" "));
    }

    private static ArrayList<Integer> FindAnagrams(String s, String w) {
        int[] arr_s = new int[MAX];
        int[] arr_w = new int[MAX];
        for (int i=0;i<w.length();i++){
            arr_w[w.charAt(i)]++;
        }
        int l = w.length();
        for (int i=0;i<l-1;i++){
            arr_s[s.charAt(i)]++;
        }
        
        int start_index =0;
        int end_index= l-1;
        ArrayList<Integer> al = new ArrayList<>();
        while (end_index<s.length()){
            arr_s[s.charAt(end_index)]++;
            if(IsEqual(arr_s,arr_w)){
                al.add(start_index);
            }
            arr_s[s.charAt(start_index)]--;
            start_index++;
            end_index++;
        }
        return al;
      }

    private static boolean IsEqual(int[] arr_s, int[] arr_w) {
        for (int i=0;i<MAX;i++){
            if(arr_s[i]!=arr_w[i]){
                return false;
            }
        }
        return true;
    }
}

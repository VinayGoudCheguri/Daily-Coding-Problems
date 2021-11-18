import java.util.HashMap;
import java.util.Map;

public class Problem157 {
    public static void main(String[] args){
        String str = "carrace";
        System.out.println(CanBePalindrome(str));
    }

    private static boolean CanBePalindrome(String str) {
        int length = str.length();
        Map<Character,Integer> hm = new HashMap<>();
        for(char c:str.toCharArray()){
            int count = hm.getOrDefault(c,0);
            hm.put(c,count+1);
        }

        if(length%2==0){
            for(Map.Entry<Character,Integer> entry:hm.entrySet()){
                if(entry.getValue()%2!=0){
                    return false;
                }
            }
        }else {
            int odd_chars = 0;
            for(Map.Entry<Character,Integer> entry:hm.entrySet()){
                if(entry.getValue()%2!=0){
                    odd_chars++;
                }
            }
            if(odd_chars==1){
                return true;
            }
        }
        return true;
    }
}

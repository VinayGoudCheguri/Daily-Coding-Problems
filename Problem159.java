import java.util.HashSet;

public class Problem159 {
    public static void main(String[] args){
        String str = "acbbac";
        System.out.println(FindRecurringCharacter(str));
    }

    private static Character FindRecurringCharacter(String str) {
        HashSet<Character> hs = new HashSet<>();
        for (char c:str.toCharArray()){
            if(hs.contains(c)){
                return c;
            }else {
                hs.add(c);
            }
        }
        return null;
    }
}

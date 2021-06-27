import java.util.HashSet;
import java.util.Set;

public class Problem_13 {
    public static final int CHAR_RANGE = 128;

    public static String Solver(String str, int k)
    {
        int left = 0, right = 0;
        Set<Character> set = new HashSet<>();
        int[] freq = new int[CHAR_RANGE];
        int low = 0;
        for (int high = 0; high < str.length(); high++)
        {
            set.add(str.charAt(high));
            freq[str.charAt(high)]++;
            // when no of elements exceeds k
            while (set.size() > k){
                if (--freq[str.charAt(low)] == 0) {
                    set.remove(str.charAt(low));
                }
 
                low++;
            }
            // updates new substring
            if (right - left < high - low){
                right = high;
                left = low;
            }
        }
        return str.substring(left, right + 1);
    }
 
    public static void main(String[] args)
    {
        String str = "abcba";
        int k = 2;
        System.out.print(Solver(str, k));
 
    }
}
import java.util.HashMap;
import java.util.HashSet;

public class Problem_99 {
    public static void main(String[] args){
        int arr[] = {100, 4, 200, 1, 3, 2};
        int ans = LongestSubsequence(arr);
        System.out.println("The length of longest subsequence is "+ans);
    }

    private static int LongestSubsequence(int[] arr) {
        int LongestSubSeqLength = 0;
        int temp = 0;
        HashSet<Integer> hs = new HashSet<>();
        for (int i:arr){
            hs.add(i);
        }
        for (int i:arr){
            if(!hs.contains(i-1)){
                int j=0;
                while(hs.contains(i+j)){
                    j++;
                }
                LongestSubSeqLength = Math.max(j,LongestSubSeqLength);
            }
        }
        return LongestSubSeqLength;
    }
}

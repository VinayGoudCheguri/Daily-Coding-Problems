import java.util.HashMap;
import java.util.Map;

public class Problem155 {
    public static void main(String[] args){
        int[] arr = {1, 2, 1, 1, 3, 4, 0};
        System.out.println(FindMajorityElement(arr));
    }

    private static int FindMajorityElement(int[] arr) {
        int majorityElement = -1;
        Map<Integer,Integer> hm = new HashMap<>();
        for (int i:arr){
            if(majorityElement==-1||hm.getOrDefault(i,0)>hm.getOrDefault(i,0)+1){
                majorityElement=i;
            }
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
     return majorityElement;
    }
}

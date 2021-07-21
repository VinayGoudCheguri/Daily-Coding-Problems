import java.util.ArrayList;
import java.util.List;

public class Problem_37 {
    private static List<List<Integer>> PowerSet(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        int array_size = arr.length;
        int powersetsize = (int)Math.pow(2,array_size);
        // We consider array_size digits in binary representation of i
        // if jth digit is 1, arr[j] is put in subset
        for(int i=0;i<powersetsize;i++){
            List<Integer> temp = new ArrayList<>();
            for(int j=0;j<array_size;j++){
                //checking jth bit in binary code of i
                if((i&(1<<j))!=0){
                    temp.add(arr[j]);
                }
            }
            list.add(temp);
        }
        return list;
    }

    public static void main(String []args){
        int arr[] = {1,2,3};
        List<List<Integer>> ans = PowerSet(arr);
        System.out.println("The power set of given set is");
        for(List<Integer> ar:ans){
            System.out.println(ar);
        }
    }
}

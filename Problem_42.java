import java.util.Deque;
import java.util.LinkedList;

public class Problem_42 {

    private static boolean FindSubset(int[] arr, Deque<Integer> stack, int i, int k) {
        if (k == 0)
            return true;
        if (k < 0 || i >= arr.length)
            return false;

        for (; i < arr.length; i++) {
            stack.push(arr[i]);
            if (FindSubset(arr, stack,i+1, k - arr[i])) {
                return true;
            }
            // if above path doesn't work
            stack.pop();
        }

        return false;
    }

    public static void main(String []args){
       int arr[] = {12, 1, 61, 5, 9, 2};
       int k = 24;
       Deque<Integer> stack = new LinkedList<>();
        if(FindSubset(arr,stack,0,k)) {
            int subset[] = stack.stream().mapToInt(Integer::intValue).toArray();
            System.out.print("The required subset is ");
            for(int i:subset){
                System.out.print(i+" ");
            }
        }

    }

}

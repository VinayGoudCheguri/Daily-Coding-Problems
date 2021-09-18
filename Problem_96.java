import java.util.ArrayList;
import java.util.Arrays;

public class Problem_96 {
    public static void main(String[] args){
        int arr[] = {1,2,3};
        ArrayList<ArrayList<Integer>> list = FindPermutations(arr);
        for (ArrayList<Integer> l:list) {
            System.out.println(l);
        }
    }

    private static ArrayList<ArrayList<Integer>> FindPermutations(int[] arr) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> elements = new ArrayList<>();
        Arrays.stream(arr).forEach(x ->elements.add(x));
        ArrayList<Integer> permutation = new ArrayList<>();
        FindPermutationsHelper(permutation,elements,list);
        return list;
    }

    private static void FindPermutationsHelper(ArrayList<Integer> permutation, ArrayList<Integer> elements, ArrayList<ArrayList<Integer>> list) {
        if(elements.size()==0){
            list.add(permutation);

        }
        else {
            for (int i = 0; i < elements.size(); i++) {
                int temp = elements.get(i);
                ArrayList<Integer> new_elements = new ArrayList<>();
                elements.stream().forEach(x->new_elements.add(x));
                ArrayList<Integer> new_permutation = new ArrayList<>();
                permutation.stream().forEach(x->new_permutation.add(x));
                new_permutation.add(temp);
                new_elements.remove(i);
                FindPermutationsHelper(new_permutation, new_elements, list);
            }
        }
    }
}

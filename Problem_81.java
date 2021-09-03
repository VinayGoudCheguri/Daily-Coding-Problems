import java.util.*;

public class Problem_81 {
    private static void PrintCombinations(HashMap<Integer,char[]> hm, String num) {
        int arr[] = new int[num.length()];
        for(int i=0; i<num.length(); i++) {
            arr[i] = Integer.parseInt(String.valueOf(num.charAt(i)));
        }
        List<String> stringList = new ArrayList<>();
        AddWords(hm,arr, arr.length, 0, "",stringList);
        for(String str:stringList){
            System.out.print(str+" ");
        }
    }

    private static void AddWords(HashMap<Integer, char[]> hm, int[] arr,
                                          int length, int index, String s, List<String> stringList) {
        if(length == index)
        {
            stringList.add(s);
        }
        else {
            int num = arr[index];
            char[] letters = hm.get(num);
            for(int i=0;i<letters.length;i++){
                String temp = s.concat(String.valueOf(letters[i]));
                AddWords(hm,arr, arr.length, index+1, temp,stringList);
            }
        }

    }

    public static void main(String[] args){
        HashMap<Integer,char[]> hm = new HashMap<>();
        hm.put(2, new char[]{'a', 'b', 'c'});
        hm.put(3, new char[]{'d', 'e', 'f'});
        String num = "23";
        PrintCombinations(hm,num);
    }

}

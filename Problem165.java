import java.util.Arrays;

public class Problem165 {
    public static void main(String[] args){
        int arr[] = {3, 4, 9, 6, 1};
        int[] newArr = NewArray(arr);
        Arrays.stream(newArr).forEach(i->System.out.print(i+" "));
    }

    private static int[] NewArray(int[] arr) {
        int newArr[] = new int[arr.length];
        for (int i =arr.length-1;i>=0;i--){
            int count = 0;
            for (int j=i+1;j< arr.length;j++){
                if(arr[j]<arr[i]){
                    count++;
                }
            }
            newArr[i]=count;
        }
        return newArr;
    }
}

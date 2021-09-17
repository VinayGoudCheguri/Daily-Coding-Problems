import java.util.Arrays;
public class Problem_95 {
    public static void main(String[] args){
        int arr[] = {3,2,1};
        int new_arr[] = FindNextPermutation(arr);
        System.out.print("Next permutation is ");
        Arrays.stream(new_arr).forEach(x -> System.out.print(x+" "));
    }

    private static int[] FindNextPermutation(int[] arr) {
        int i= 0;
        // if number is the maximum, reverse it
        for(int j=arr.length-1;j> 0;j--){
            if(arr[j]>arr[j-1]){
                break;
            }
            if(j==1){
                reverse(arr);
                return arr;
            }
        }
        // Otherwise do swappings from rightmost until arr[i]<arr[i+1]
        while (arr[arr.length-i%arr.length-1]<arr[arr.length-(i+1)%arr.length-1]){
            swap(arr,arr.length-i%arr.length-1,arr.length-(i+1)%arr.length-1);
            i++;
        }
        swap(arr,arr.length-i%arr.length-1,arr.length-(i+1)%arr.length-1);
        return arr;
    }

    private static void reverse(int[] arr) {
        if (arr == null || arr.length < 2)
        { return; }
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }

    }

    public static void swap(int arr[],int x,int y){
        int temp = arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }
}

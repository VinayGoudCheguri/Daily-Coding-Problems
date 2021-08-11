
public class Problem_58 {
    private static Integer FindIndex(int[] arr, int element, int left, int right) {
        if(left==right){
            if(element==arr[left]){
                return left;
            }
            else {
                return null;
            }
        }
        int mid = (left+right)/2;
        if((arr[left]<element&&arr[mid]>=element)||(arr[left]>arr[mid]&&element<=arr[mid])){
            return FindIndex(arr,element,left,mid);
        }
        else {
            //System.out.println("mid= "+ mid);
            return FindIndex(arr,element,mid+1,right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {13, 18, 25, 2, 8, 10};
        int element = 8;
        int ans = FindIndex(arr,element,0,arr.length-1);
        System.out.println("Required index is "+ ans);
        }

}

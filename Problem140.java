public class Problem140 {
    public static void main(String[] args){
        int arr[] = {2, 4, 6, 8, 10, 2, 6, 10};
        int uniqueElements[] = FindUniqueElements(arr);
        for (int i:uniqueElements){
            System.out.print(i+" ");
        }
    }

    private static int[] FindUniqueElements(int[] arr) {
        int uniqueElements[] = new int[2];
        int sum = 0;
        for (int i:arr){
            sum = sum^i;
        }
        sum = (sum & -sum); // sum & 2's compliment of sum
        int sum1 =0,sum2 =0;
        for (int i:arr){
            if((sum&i)==0){
                sum1 = sum1^i;
            }
            else {
                sum2 = sum2^i;
            }
        }
        uniqueElements[0] = sum1;
        uniqueElements[1] = sum2;
        return uniqueElements;
    }
}

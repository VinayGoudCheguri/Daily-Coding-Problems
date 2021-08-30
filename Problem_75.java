public class Problem_75 {
    private static int FindLongestIncSubSeq(int[] arr) {
        int n = arr.length,ans=0;
        int lis[] = new int[n];
        for (int i=0;i<n;i++){
            lis[i]=1;
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    int temp = lis[j]+1;
                    lis[i] = Math.max(lis[i],temp);
                }
            }
            ans = Math.max(ans,lis[i]);
        }
        return ans;
    }

    public static void main(String[] args){
        int[] arr = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        int length = FindLongestIncSubSeq(arr);
        System.out.println("longest increasing subsequence has length "+length);
    }

}

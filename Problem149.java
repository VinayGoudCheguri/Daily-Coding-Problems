public class Problem149 {
    public static void main(String[] args){
        int L[] = {1, 2, 3, 4, 5};
        Solution s = new Solution(L);
        int sum = s.sum(1,3);
        System.out.println(sum);
    }
    public static class Solution{
        int L[];
        int sumList[];
        public Solution(int[] l) {
            L = l;
            sumList = new int[l.length];
            preProcess();
        }

        private void preProcess() {
            sumList[0] = L[0];
            for (int i=1;i<L.length;i++){
                sumList[i] = sumList[i-1]+L[i];
            }
        }


        public int sum(int i, int j) {
            return sumList[j]-sumList[i]-L[j]+L[i];
        }
    }
}

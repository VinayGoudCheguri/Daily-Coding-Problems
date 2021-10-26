import java.util.HashMap;

public class Problem134 {
    public static void main(String[] args){
        SparseArray sa = new SparseArray();
        int arr[] = {0,0,0,0,8,0,0,0,0,0,0,0,0,0,0,3,7,0,0,0,0,0,0,0};
        int size = arr.length;
        sa.init(arr, size);
        sa.set(10, 20);
        System.out.println(sa.get(4));
    }
    public static class SparseArray{
        int size;
        HashMap<Integer,Integer> hm = new HashMap<>();
        public void init(int[] arr, int size) {
            this.size = size;
            for(int i=0;i< arr.length;i++){
                if(arr[i]!=0) {
                    hm.put(i, arr[i]);
                }
            }
        }

        public void set(int i, int val) {
            if(val!=0){
                hm.put(i,val);
            }
        }

        public int get(int i) {
            return hm.getOrDefault(i,0);
        }
    }
}

public class Problem137 {
    public static void main(String[] args){
        BitArray ba = new BitArray();
        ba.init(10);
        ba.set(5, 0);
        System.out.println(ba.get(5));
    }

    public static class BitArray{
        static final int MAX_BITS = 8;
        int[] bitArray;
        public void init(int size){
            int bitArray_size = size/MAX_BITS +(size % MAX_BITS == 0 ? 0 : 1);
            this.bitArray = new int[bitArray_size];
        }
        public void set(int i, int val){
            if(val==1){
                bitArray[getArrayIndex(i)] |= (1 << i % MAX_BITS); // placing 1 at the req position
            }else {
                bitArray[getArrayIndex(i)] &= ~(1 << i % MAX_BITS); // placing 0 at the req position
            }
        }

        private int getArrayIndex(int i) {
            return i/MAX_BITS;
        }

        public int get(int i) {
            int num = bitArray[getArrayIndex(i)]&(1<<i % MAX_BITS);
            if(num>0){
                return 1;
            }
            else {
                return 0;
            }
        }
    }
}

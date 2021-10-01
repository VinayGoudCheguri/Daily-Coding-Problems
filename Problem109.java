public class Problem109 {
    public static void main(String[] args){
        System.out.println(Integer.toBinaryString(Swap(Integer.parseInt("10101010",2))));
    }

    private static int Swap(int i) {
        // shift all even bits to right by 1
        // and odd bits lo left by 1
        return (i & 0b10101010) >> 1 | (i & 0b01010101) << 1;
    }
}

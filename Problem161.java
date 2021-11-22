public class Problem161 {
    public static void main(String[] args){
        String binaryNumber = "11110000111100001111000011110000";
        long number = Long.parseLong(binaryNumber,2);
        long reverseBinary = ReverseBinaryNumber(number);
        System.out.println(Long.toBinaryString(reverseBinary));
    }

    private static long ReverseBinaryNumber(long number) {
        long i=1L;
        long j = 1L<<31;
        while(i<j){
            if((number&i)!=(number&j)) {
                number = (long) ((number & ~i) & (number & ~j) | (~number & i) | (~number & j));
            }
            i<<=1;
            j>>=1;
        }
        return number;
    }
}

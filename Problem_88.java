public class Problem_88 {
    public static void main(String[] args){
        int a=60,b=7;
        long quotient = divide(a,b);
        System.out.println("Quotient is "+quotient);
    }

    private static long divide(long a, long b) {
        long quotient =0,num=0;
        // a = rem + b*(b31*2^31 + b30*2^30+...+b0)
        // b0,b1,..b32 can be 0 or 1
        // quo = sum of co-efficients
        for (int i = 31; i >= 0; --i)
        {
            if (num + (b << i) <= a)
            {
                num += b << i;
                quotient += 1L << i;
            }
        }
        return quotient;
    }
}

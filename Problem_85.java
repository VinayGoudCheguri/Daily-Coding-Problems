public class Problem_85 {
    private static int XorY(int x, int y, int b) {
        return x*b+y*Math.abs(b-1);
    }

    public static void main(String[] args){
        System.out.println(XorY(13,26,0));
    }

}

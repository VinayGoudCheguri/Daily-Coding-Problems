public class Problem129 {
    public static void main(String[] args){
        System.out.println(SquareRoot(9));
    }

    private static int SquareRoot(int n) {
        return SquareRootHelper(0,n,n);
    }

    private static int SquareRootHelper(int i1, int i2,int n) {
        int mid = (i1+i2)/2;
        if((mid*mid<=n)&&(mid+1)*(mid+1)>n){
            return mid;
        }
        else if(mid*mid>n){
            return SquareRootHelper(i1,mid,n);
        }
        else {
            return SquareRootHelper(mid,i2,n);
        }
    }
}

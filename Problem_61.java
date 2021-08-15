public class Problem_61 {
    private static int pow(int x, int y) {
        if(x==1||y==0){
            return 1;
        }
        else if(x==0){
            return 0;
        }
        else if(y%2==0){
            int temp = pow(x,y/2);
            return temp*temp;
        }
        else {
            int temp = pow(x,y/2);
            return x*temp*temp;
        }
    }

    public static void main(String[] args){
        int x =2,y=10;
        int ans = pow(x,y);
        System.out.println("Answer is "+ans);
    }

}

public class Problem_70 {
    private static int PerfectNumber(int n) {
        int num = 1;
        while (n>0){
            if(IsPerfct(num)){
                n--;
            }
            num++;
        }
        return num-1;
    }

    private static boolean IsPerfct(int num) {
        int sum=0;
        while(num>0){
            sum+= num%10;
            num = num/10;
        }
        if(sum==10){
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args){
        int n =2;
        int ans = PerfectNumber(n);
        System.out.println(n+"th perfect number is "+ans);
    }
}

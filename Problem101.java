public class Problem101 {
    public static void main(String[] args){
        int num = 100;
        int arr[] = FindPrimes(num);
        System.out.println("The two prime numbers are "+arr[0]+" and "+arr[1]);
    }

    private static int[] FindPrimes(int num) {
        int arr[] = new int[2];
        for(int i=num/2; i>=2;i--){
            if(IsPrime(i)&&IsPrime(num-i)){
                arr[0] = i;
                arr[1] = num-i;
                return arr;
            }
        }
        return arr;
    }

    private static boolean IsPrime(int i) {
        if(i<2){
            return false;
        }
        int sqrt = (int)Math.sqrt(i);
        for(int j=2;j<=sqrt;j++){
            if (i%j==0){
                return false;
            }
        }
        return true;
    }
}

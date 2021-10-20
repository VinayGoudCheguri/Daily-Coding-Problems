public class Problem128 {
    public static void main(String[] args){
        int n = 3;
        TowerOfHanoi(n,1,3,2);
    }

    private static void TowerOfHanoi(int n, int i1, int i2, int i3) {
        if(n==1){
            System.out.println("Move "+ i1 + " to " + i2 );
        }
        else {
            TowerOfHanoi(n-1,i1,i3,i2);
            System.out.println("Move "+ i1 + " to " + i2 );
            TowerOfHanoi(n-1,i3,i2,i1);
        }
    }
}

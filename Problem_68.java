import java.util.ArrayList;

public class Problem_68 {
    public static class coordinates{
        private int x,y;

        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }

        public coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int Solve(ArrayList<coordinates> list) {
        int n = list.size();
        int ans =0;
        for (int i=0;i<n;i++){
            int x1 = list.get(i).getX();
            int y1 = list.get(i).getY();
            for(int j=i+1;j<n;j++){
                int x2 = list.get(j).getX();
                int y2 = list.get(j).getY();
                if(Math.abs(x1-x2)==Math.abs(y1-y2)){
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args){
        int m=5,n=4;
        ArrayList<coordinates> list = new ArrayList<coordinates>(n);
        coordinates b1 = new coordinates(0,0);
        list.add(b1);
        coordinates b2 = new coordinates(1,2);
        list.add(b2);
        coordinates b3 = new coordinates(2,2);
        list.add(b3);
        coordinates b4 = new coordinates(4,0);
        list.add(b4);
        int ans = Solve(list);
        System.out.println(ans + " pairs of bishops attack each other");
    }
}

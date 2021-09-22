import java.util.ArrayList;

public class Problem100 {
    public static class Point{
        int x,y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
    public static void main(String[] args){
        ArrayList<Point> Input = new ArrayList<>();
        Input.add(new Point(0,0));
        Input.add(new Point(1,1));
        Input.add(new Point(1,1));
        System.out.println("Minimum number of steps in "+MinSteps(Input));
    }

    private static int MinSteps(ArrayList<Point> input) {
        int total_steps = 0;
        Point source = input.get(0);
        int length = input.size();
        for (int i=1;i<length;i++){
            Point dest = input.get(i);
            total_steps+= CalculateSteps(source,dest);
            source = dest;
        }
        return total_steps;
    }

    private static int CalculateSteps(Point source, Point dest) {
        int x1 = source.x;
        int y1 = source.y;
        int x2 = dest.getX();
        int y2 = dest.getY();
        return Math.max(Math.abs(x1-x2),Math.abs(y1-y2));
    }
}

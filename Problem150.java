import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Problem150 {
    public static void main(String[] args){
        Point p1 = new Point(0,0);
        Point p2 = new Point(5,4);
        Point p3 = new Point(3,1);
        Point centre = new Point(1,2);
        ArrayList<Point> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        int k = 2;
        ArrayList<Point> nearestPoints = FindNearestPoints(list,centre,k);
        for (Point p:nearestPoints){
            System.out.println(p.x+" "+p.y);
        }
    }

    private static ArrayList<Point> FindNearestPoints(ArrayList<Point> list, Point centre, int k) {
        for(Point p:list){
            p.sqDistanceFromCentre = CalculateSquareDistance(p,centre);
        }
        Collections.sort(list,new sortByDistance());
        ArrayList<Point> kNearestPoints = new ArrayList<>();
        for (int i=0;i<k;i++){
            kNearestPoints.add(list.get(i));
        }
        return kNearestPoints;
    }

    private static int CalculateSquareDistance(Point p1,Point p2){
        return (p1.x-p2.x)^2+(p1.y-p2.y)^2;
    }
    public static class Point{
        int x;
        int y;
        int sqDistanceFromCentre;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class sortByDistance implements Comparator<Point>{
        public int compare(Point a,Point b){
            return a.sqDistanceFromCentre-b.sqDistanceFromCentre;
        }
    }
}


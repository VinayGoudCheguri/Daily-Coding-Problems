import java.util.ArrayList;
import java.util.Arrays;

public class Problem119 {
    public static class Interval{
        private int start;
        private int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }
    public static void main(String[] args){
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0,3));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(3,4));
        intervals.add(new Interval(6,9));
        Interval ans = FindMinInterval(intervals);
        System.out.println(ans.getStart()+" "+ ans.getEnd());
    }

    private static Interval FindMinInterval(ArrayList<Interval> intervals) {
        int[] start_indices = new int[intervals.size()];
        int[] end_indices = new int[intervals.size()];
        int i=0;
        for (Interval in:intervals){
            start_indices[i] = in.getStart();
            end_indices[i] = in.getEnd();
            i++;
        }
        Arrays.sort(start_indices);
        Arrays.sort(end_indices);
        int start_index = 0;
        int end_index = end_indices.length-1;
        for (int j=0;j<start_indices.length;j++){
            if(start_indices[j]>end_indices[0]){
                start_index =j-1;
                break;
            }
        }
        for (int j=start_indices.length-1;j>=0;j--){
            if(start_indices[start_indices.length-1]>end_indices[j]){
                end_index =j+1;
                break;
            }
        }
        return new Interval(start_indices[start_index],end_indices[end_index]);
    }
}

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Problem_77 {
    public static class interval{
        int start_time;
        int end_time;
        public interval(int start_time, int end_time) {
            this.start_time = start_time;
            this.end_time = end_time;
        }
    }

    private static ArrayList<interval> ModifyList(ArrayList<interval> al) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        ArrayList<Integer> start_time = new ArrayList<>();
        ArrayList<Integer> end_time = new ArrayList<>();
        // adding intervals to treemap
        for(interval inter:al){
            tm.put(inter.start_time,inter.end_time);
        }
        // Iterating intervals arranged in increasing order
        for (Map.Entry map_element: tm.entrySet()){
            start_time.add((int)map_element.getKey());
            end_time.add((int)map_element.getValue());
        }
        ArrayList<interval> al_new = new ArrayList<>();
        interval temp;
        int size = start_time.size();
        int i=0,j=0;
        int start=start_time.get(i);
        int end = end_time.get(j);
        while (i<size&&j<size){
            if(i==size-1){
                end = Math.max(end,end_time.get(i));
                temp = new interval(start,end);
                al_new.add(temp);
                break;
            }
            if(j==size-1){
                temp = new interval(start,end);
                al_new.add(temp);
                break;
            }
            if(start_time.get(i+1)>end){
                temp = new interval(start,end);
                al_new.add(temp);
                i++;
                j++;
                start = start_time.get(i);
                end = end_time.get(j);
            }
            else{
                j++;
                end = Math.max(end,end_time.get(j));
                i++;
            }
        }
        return al_new;
    }

    public static void main(String[] args){
        ArrayList<interval> al = new ArrayList<>();
        interval temp = new interval(1,3);
        al.add(temp);
        temp = new interval(5,8);
        al.add(temp);
        temp = new interval(4,10);
        al.add(temp);
        temp = new interval(20,25);
        al.add(temp);
        ArrayList<interval> new_al = ModifyList(al);
        int size = new_al.size();
        for (int i=0;i<size;i++){
            System.out.println(new_al.get(i).start_time+" "+new_al.get(i).end_time);
        }
    }

}

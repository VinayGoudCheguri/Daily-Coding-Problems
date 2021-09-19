import java.util.*;

public class Problem_97 {
    public static class TimeMap{
        Map<Integer, TreeMap<Integer,Integer>> tm = new HashMap<>();

        public void set(int key, int value, int time) {
            if(!tm.containsKey(key)){
                TreeMap<Integer,Integer> TV = new TreeMap<>();
                TV.put(time,value); // TimeValue treemap
                tm.put(key,TV);
            }
            TreeMap<Integer,Integer> TV = tm.get(key);
            TV.put(time,value);
        }

        public void get(int key, int time) {
            TreeMap<Integer,Integer> TV = tm.get(key);
            int t = -1;
            for (Map.Entry<Integer, Integer>  entry : TV.entrySet()){
                if(entry.getKey()<=time){
                    t = entry.getKey();
                }
            }
            if(t==-1){
                System.out.println("value is not defined");
            }
            else {
                int value = TV.get(t);
                System.out.println("value is "+value);
            }
        }
    }
    public static void main(String[] args){
        TimeMap map = new TimeMap();
        map.set(1, 1, 0);
        map.set(1, 2, 2);
        map.get(1, 1) ;
        map.get(1,3);
//        map.set(1, 1, 5);
//        map.get(1, 0);
//        map.get(1, 10);
//        map.set(1, 1, 0);
//        map.set(1, 2, 0);
//        map.get(1, 0);
    }
}

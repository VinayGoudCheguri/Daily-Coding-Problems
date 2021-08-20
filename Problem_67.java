import java.util.Iterator;
import java.util.LinkedHashMap;

public class Problem_67 {
    public static LinkedHashMap<Integer, CacheElement > Cache = new LinkedHashMap();
    static int cachesize = 3;
    public static class CacheElement{
        private String d1;
        private int d2;
        public String getD1() {
            return d1;
        }
        public void setD1(String d1) {
            this.d1 = d1;
        }
        public int getD2() {
            return d2;
        }
        public void setD2(int d2) {
            this.d2 = d2;
        }
    }
    // Hash map is iterated from start and the cache element
    // with least frequency value is replaced
    private static void set(int i, CacheElement temp) {
        if(Cache.size()<cachesize){
            Cache.put(i,temp);
        }
        else {
            Iterator it = Cache.keySet().iterator();
            Object tempkey = it.next();
            Object keytoberemoved = tempkey;
            int freq = Cache.get(tempkey).getD2();
            int minfreq = freq;
            while (it.hasNext()){
                tempkey = it.next();
                freq = Cache.get(tempkey).getD2();
                if(freq<minfreq){
                    minfreq = freq;
                    keytoberemoved = tempkey;
                }
            }
            Cache.remove(keytoberemoved);
            Cache.put(i,temp);
        }
    }
    // returns the d1 element in cache element
    // d2 is frequency which need not be passed
    private static String get(int i) {
        if(!Cache.containsKey(i)){
            return null;
        }
        else {
            CacheElement c = Cache.get(i);
            return c.getD1();
        }
    }

    public static void main(String[] args){
        CacheElement temp = new CacheElement();
        temp.setD1("Avatar");
        temp.setD2(100);
        set(1,temp);
        temp = new CacheElement();
        temp.setD1("Infinity War");
        temp.setD2(120);
        set(2,temp);
        temp = new CacheElement();
        temp.setD1("Titanic");
        temp.setD2(90);
        set(3,temp);
        temp = new CacheElement();
        temp.setD1("Fast and Furious");
        temp.setD2(105);
        set(4,temp);
        String ans = get(1);
        System.out.println(ans);
    }
}
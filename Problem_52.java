import java.util.LinkedHashMap;
import java.util.Map;

public class Problem_52 {
    public static final class Cache<Key, Val> {
        private final Map<Key, Val> map = new LinkedHashMap<>();
        private final int maxSize;

        public Cache(int maxSize) {
            this.maxSize = maxSize;
        }

        public void set(Key key, Val value) {
            if (map.containsKey(key)) {
                map.remove(key);
            }
            else if (map.size() == maxSize) {
                map.remove(map.keySet().iterator().next());
            }
            map.put(key, value);
        }

        public Val get(Key key) {
            if (!map.containsKey(key))
                return null;

            Val value = map.remove(key);
            map.put(key, value);
            return value;
        }
    }

    public static void main(String[] args){
        Cache<String, Double> cache = new Cache<>(4);
        // Cache stores tv show name and its rating
        cache.set("Breaking Bad", 9.5);
        cache.set("Dexter", 9.0);
        cache.set("Narcos", 8.5);
        cache.set("Money Heist", 8.5);
        cache.set("Arrow", 8.0);
        System.out.println(cache.get("Dexter"));
        System.out.println(cache.get("Game Of Thrones"));
    }
}

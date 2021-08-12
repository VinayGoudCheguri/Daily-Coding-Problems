import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Problem_55 {
    public static Map<String, String> map = new HashMap<>();
    public static Random random = new Random();
    private static String restore(String shorturl) {
        if(map.containsKey(shorturl)){
            return map.get(shorturl);
        }
        else {
            return null;
        }
    }

    private static String shorten(String url) {
        String shorturl = RandomString(url);
        while (map.containsKey(shorturl)){
            shorturl = RandomString(url);
        }
        map.put(shorturl,url);
        return shorturl;
    }

    private static String RandomString(String url) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<6;i++){
            if (random.nextBoolean()){
                char c = random.nextBoolean() ? 'A' : 'a';
                c += random.nextInt(26);
                sb.append(c);
            }
            else {
                sb.append(random.nextInt(10));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        String url = "www.youtube.com";
        String shorturl = shorten(url);
        System.out.println("Shorturl for "+url+" is "+shorturl);
        String restoredurl = restore(shorturl);
        System.out.println("Restored url of "+shorturl+" is "+restoredurl);
    }
}

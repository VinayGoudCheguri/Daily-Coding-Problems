import java.util.HashMap;
import java.util.Map;

public class Problem_41 {
    private static void PrintJourney(Map<String, String> flights,String sp) {
        Map<String, String> flightsReverse = new HashMap<String, String>();
        int count = 0;
        // flightsReverse : endpoint, starting point
        for (Map.Entry<String,String> entry: flights.entrySet()) {
            flightsReverse.put(entry.getValue(), entry.getKey());
            count++;
        }
        String from = sp;
        String ep = flights.get(sp);
        System.out.print(sp+" to ");
        count--;
        while(count>1){
            sp = ep;
            ep = flights.get(sp);
            System.out.print(sp+" to ");
            count--;
        }
        sp = ep;
        ep = flights.get(sp);
        System.out.print(sp + " to " +ep);
    }

    public static void main(String []args){
        Map<String, String> flights = new HashMap<String, String>();
        // flights : starting point,end point
        flights.put("SFO", "HKO");
        flights.put("YYZ", "SFO");
        flights.put("YUL", "YYZ");
        flights.put("HKO", "ORD");
        PrintJourney(flights,"YUL");
    }

}

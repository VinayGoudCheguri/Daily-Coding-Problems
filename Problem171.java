import java.util.ArrayList;

public class Problem171 {
    public static void main(String[] args){
        DataEntry d1 = new DataEntry(1526579928,3,"enter");
        DataEntry d2 = new DataEntry(1526580382,2,"exit");
        DataEntry d3 = new DataEntry(1526580582,1,"exit");
        ArrayList<DataEntry> al = new ArrayList<>();
        al.add(d1);
        al.add(d2);
        al.add(d3);
        DataEntry[] period = FindBusiestPeriod(al);
        System.out.println(period[0].timestamp+" "+period[1].timestamp);
    }

    private static DataEntry[] FindBusiestPeriod(ArrayList<DataEntry> al) {
        DataEntry[] period = new DataEntry[2];
        int max_members = Integer.MIN_VALUE;
        for (int i=1;i< al.size();i++){
            if(al.get(i).type.equals("exit")&&al.get(i-1).type.equals("enter")){
                if(max_members < al.get(i-1).count- al.get(i).count){
                    max_members = al.get(i-1).count- al.get(i).count;
                    period[0]=al.get(i-1);
                    period[1]=al.get(i);
                }
            }
        }
        return period;
    }

    public static class DataEntry{
        long timestamp;
        int count;
        String type;

        public DataEntry(long timestamp, int count, String type) {
            this.timestamp = timestamp;
            this.count = count;
            this.type = type;
        }
    }
}

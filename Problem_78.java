import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Problem_78 {
    private static LinkedList<Integer> Merge(List<LinkedList<Integer>> lists) {
        int temp = Integer.MAX_VALUE;
        int temp2 = 0;
        LinkedList<Integer> ll = new LinkedList<>();
        Iterator<Integer>[] its = lists.stream().map(List::iterator).toArray(Iterator[]::new);
        int[] values = new int[lists.size()];
        for(int i=0;i<values.length;i++){
            values[i]=-1;
        }
        int count = values.length;
        while(true){
            for(int i=0;i<values.length;i++){
                if(its[i].hasNext()){
                    if(values[i]==-1){
                        values[i]=its[i].next();
                    }
                }
                else {
                    if(values[i]==-1){
                        count--;
                    }
                }
                if(values[i]<temp&&values[i]!=-1){
                    temp=values[i];
                    temp2 = i;
                }
            }
            if (count==0) {
                break;
            }
            values[temp2]=-1;
            temp2=0;
            ll.add(temp);
            temp = Integer.MAX_VALUE;
            count = values.length;
        }
        return ll;
    }

    public static void main(String[] args){
        LinkedList<Integer> ll1 = new LinkedList<>();
        ll1.add(2);
        ll1.add(4);
        ll1.add(6);
        LinkedList<Integer> ll2 = new LinkedList<>();
        ll2.add(1);
        ll2.add(3);
        ll2.add(7);
        LinkedList<Integer> ll3 = new LinkedList<>();
        ll3.add(5);
        ll2.add(8);
        List<LinkedList<Integer>> lists = new ArrayList<LinkedList<Integer>>();
        lists.add(ll1);
        lists.add(ll2);
        lists.add(ll3);
        LinkedList<Integer> ans = Merge(lists);
        Iterator<Integer> it = ans.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
    }
}

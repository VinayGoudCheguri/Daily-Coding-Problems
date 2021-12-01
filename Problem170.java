import java.util.*;

public class Problem170 {
    public static void main(String[] args){
        Set<String> dictionary = new HashSet<>();
        dictionary.add("dot");
        dictionary.add("dop");
        dictionary.add("dat");
        dictionary.add("cat");
        String start = "dog";
        String end = "cat";
        List<String> moves = findSequence(start, end, dictionary);
        System.out.println(Arrays.toString(moves.toArray()));
    }

    private static List<String> findSequence(String start, String end, Set<String> dictionary) {
        List<String> sequence = new ArrayList<>();
        if(start.equals(end)){
            sequence.add(start);
            return sequence;
        }else {
            Set<String> nextMoves = FindNextMoves(start,dictionary);
            List<String> AfterStart = FindRemainingItems(nextMoves,end,dictionary);
            if(AfterStart.isEmpty()){
                return Collections.emptyList();
            }else {
                sequence.add(start);
                sequence.addAll(AfterStart);
                return sequence;
            }
        }
    }

    private static List<String> FindRemainingItems(Set<String> nextMoves, String end, Set<String> dictionary) {
        List<String> AfterStart = Collections.emptyList();
        for(String item:nextMoves){
            Set<String> subDictionary = new HashSet<>(dictionary);
            subDictionary.remove(item);
            List<String> list = findSequence(item,end,subDictionary);
            if(list.isEmpty()){
                continue;
            }
            if(AfterStart.isEmpty()||AfterStart.size()>list.size()){
                AfterStart = list;
            }
        }
        return AfterStart;
    }

    private static Set<String> FindNextMoves(String start, Set<String> dictionary) {
        Set<String> nextMoves = new HashSet<>();
        for (String item : dictionary) {
            int diff = 0;

            for (int i = 0; i < item.length(); i++) {
                if (item.charAt(i) != start.charAt(i))
                    diff++;
            }

            if (diff == 1)
                nextMoves.add(item);
        }
        return nextMoves;
    }
}

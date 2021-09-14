import java.util.*;

public class Problem_92 {
    public static void main(String[] args){
        HashMap<String, HashSet<String>> hm = AddCourses();
        ArrayList<String> l = sort(hm);
        System.out.println("Sorted order of courses is:");
        System.out.println(l);
    }

    private static HashMap<String, HashSet<String>> AddCourses() {
        HashMap<String, HashSet<String>> hm = new HashMap<>();
        hm.put("CSC200", new HashSet<>(Arrays.asList("CSC100")));
        hm.put("CSC300", new HashSet<>(Arrays.asList("CSC100", "CSC200")));
        hm.put("CSC100", new HashSet<String>());
        return hm;
    }
    
    private static ArrayList<String> sort(HashMap<String, HashSet<String>> hm) {
        HashSet<String> visited = new HashSet<>();
        ArrayList<String> sorted_list = new ArrayList<>();
        for (String courseId : hm.keySet())
            dfs(courseId, hm, visited, sorted_list);

        return sorted_list;
    }

    private static void dfs(String courseId, HashMap<String, HashSet<String>> hm, HashSet<String> visited, ArrayList<String> sorted_list) {
        if (visited.contains(courseId)) {
            return;
        }else {
            visited.add(courseId);
        }

        for (String id : hm.getOrDefault(courseId, new HashSet<String>()))
            dfs(id, hm, visited, sorted_list);

        sorted_list.add(courseId);
    }

}

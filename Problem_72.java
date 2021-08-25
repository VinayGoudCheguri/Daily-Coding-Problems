import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class Problem_72 {
    public static class Graph {
        private LinkedList<Integer> adjLists[];
        private boolean visited[];
        Graph(int vertices) {
            adjLists = new LinkedList[vertices];
            visited = new boolean[vertices];

            for (int i = 0; i < vertices; i++)
                adjLists[i] = new LinkedList<Integer>();
        }
        // Adding edges edges
        void addEdge(int src, int dest) {
            adjLists[src].add(dest);
        }
        // DFS algorithm returns the list of integers in path
        void DFS(LinkedList<Integer> ll, int vertex) {
            visited[vertex] = true;
            ll.add(vertex);
            Iterator<Integer> it = adjLists[vertex].listIterator();
            while (it.hasNext()) {
                int adj = it.next();
                if (!visited[adj])
                    DFS(ll,adj);
            }
        }
    }

    // Calulates the largest value by finding the value of each path
    private static int LargestValue(Graph g, String str,int v) {
        LinkedList<Integer> ll = new LinkedList<>();
        int ver =0,ans=0;
        do {
            g.DFS(ll,ver);
            ans = Math.max(ans,CalculateValue(ll,str));
            ll = new LinkedList<>();
            ver++;
        }while (ver<v);
        return ans;
    }

    // Calculates the value of each path using hasmap
    private static int CalculateValue(LinkedList<Integer> ll,String str) {
        HashMap<Character,Integer> hm = new HashMap<>(); // stores char,frequency
        int num;
        char c;
        Iterator<Integer> it = ll.listIterator();
        while (it.hasNext()) {
            num = it.next();
            c = str.charAt(num);
            if(hm.containsKey(c)){
                hm.put(c, hm.get(c) + 1);
            }
            else {
                hm.put(c,1);
            }
        }
        Iterator hmIterator = hm.entrySet().iterator();
        int ans = 0;
        while (hmIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry)hmIterator.next();
            ans = Math.max(ans,(int)mapElement.getValue());
        }
        return ans;
    }

    public static void main(String args[]) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        String str = "ABACA";
        int ans = LargestValue(g,str,5);
        System.out.println("Largest value is "+ans);
    }

}
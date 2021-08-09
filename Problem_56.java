public class Problem_56 {
    private static boolean FindPossibility(int[][] graph, int k) {
        int no_of_colours = graph[0].length;
        int[] colours = new int[no_of_colours];
        for(int i=0;i<no_of_colours;i++){
            colours[i]=0;
        }
        if(!Solve(graph,k,colours,0)){
            return false;
        }
        return true;
    }
    //Method to be called recursively
    private static boolean Solve(int[][] graph, int k, int[] colours, int vert) {
        int no_of_colours = graph[0].length;
        if(vert==no_of_colours){
            return true;
        }
        for (int col=0;col<=k;col++){
            if(IsSafe(graph,colours,vert,col)){
                colours[vert] = col;
                if(Solve(graph,k,colours,vert+1)){
                    return true;
                }
                else {
                    colours[vert] = 0;
                }
            }
        }
        return false;
    }
    // verifies any vertex with same colour or not
    private static boolean IsSafe(int[][] graph, int[] colours, int vert, int col) {
        int no_of_colours = graph[0].length;
        for (int i=0;i<no_of_colours;i++){
            if(graph[vert][i]==1&&colours[i]==col){
                return false;
            }
        }
        return true;
    }

    public static void main(String args[])
    {
        int graph[][] = {
                { 0, 1, 1, 0 },
                { 1, 0, 1, 0 },
                { 1, 1, 0, 1 },
                { 0, 0, 1, 0 },
        };
        int k = 3; // no of colors
        if(FindPossibility(graph,k)){
            System.out.println("It is possible with at most "+k+ " colours");
        }
        else{
            System.out.println("It is not possible with "+k+ " colours");
        }
    }

}

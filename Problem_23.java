import java.util.LinkedList;
import java.util.Queue;

public class Problem_23 {
    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean isEqual(Point point) {
            return x == point.x && y == point.y;
        }
    }
    // Node stores coordinates and distance from starting point
    static class Node
    {
        Point pt;
        int dist;

        public Node(Point pt, int dist)
        {
            this.pt = pt;
            this.dist = dist;
        }
    }

    public static boolean IsValidMove(boolean[][] board,int x, int y){
        int m = board.length;//no of rows
        int n = board[0].length; // no of columns

        if((x>=0&&x<m&&y>=0&&y<n)&&(!board[x][y])){
            return true;
        }
        else {
            return false;
        }
    }

    private static int findMinimumPathLength(boolean[][] board, Point point1, Point point2) {
        int m = board.length;//no of rows
        int n = board[0].length; // no of columns
        boolean[][] visited = new boolean[m][n];
        Queue<Node> Q = new LinkedList<>();
        Node sp = new Node(point1,0);
        visited[point1.x][point1.y] = true;
        Q.add(sp);
        Point np = point1;
        Node newNode = sp;
        //BFS is implemented 
        while (!Q.isEmpty())
        {
            Node currNode = Q.peek();
            Point currPoint = currNode.pt;
            Q.remove();
            // If we reach endpoint
            if(point2.isEqual(currPoint)){
                return currNode.dist;
            }
            // Neighbouring points
            // top,bottom,right and left
            if(IsValidMove(board, currPoint.x+1, currPoint.y)&&!visited[currPoint.x+1][currPoint.y]){
                np = new Point(currPoint.x+1,currPoint.y);
                visited[currPoint.x+1][currPoint.y] = true;
                newNode = new Node(np, currNode.dist+1);
                Q.add(newNode);
            }
            if(IsValidMove(board, currPoint.x-1, currPoint.y)&&!visited[currPoint.x-1][currPoint.y]){
                np = new Point(currPoint.x-1,currPoint.y);
                visited[currPoint.x-1][currPoint.y] = true;
                newNode = new Node(np, currNode.dist+1);
                Q.add(newNode);
            }
            if(IsValidMove(board, currPoint.x, currPoint.y+1)&&!visited[currPoint.x][currPoint.y+1]){
                np = new Point(currPoint.x,currPoint.y+1);
                visited[currPoint.x][currPoint.y+1] = true;
                newNode = new Node(np, currNode.dist+1);
                Q.add(newNode);
            }
            if(IsValidMove(board, currPoint.x, currPoint.y-1)&&!visited[currPoint.x][currPoint.y-1]){
                np = new Point(currPoint.x,currPoint.y-1);
                visited[currPoint.x][currPoint.y-1] = true;
                newNode = new Node(np, currNode.dist+1);
                Q.add(newNode);
            }
        }
        return -1;
    }

    public static void main(String []args){
        // board matrix in which true indicates wall
        boolean[][] board = {{false, false, false, false},
                {true, true, false, true}, {false, false, false, false},
                {false, false, false, false}};
        int ans = findMinimumPathLength(board, new Point(3, 0), new Point(0, 0));
        System.out.println("Minimum number of required steps are "+ans);
    }

}

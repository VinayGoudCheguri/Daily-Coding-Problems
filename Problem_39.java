import java.util.Objects;

public class Problem_39 {
    private static void ConwaysGame(char[][] pre_arr, int N, int steps) {
        for(int k=1;k<=steps;k++){
            char[][] arr = RunConwaysGame(pre_arr,N);
            // Printing the board state
            System.out.println("Board state after "+ k +"th step is");
            for (int i=0;i<N;i++){
                for (int j=0;j<N;j++){
                    System.out.print(arr[i][j]+ " ");
                }
                System.out.println("");
            }
            pre_arr = arr;
        }
    }

    private static char[][] RunConwaysGame(char[][] pre_arr, int N) {
        char[][] arr = pre_arr;
        for (int i=1;i<N-1;i++){
            for (int j=1;j<N-1;j++){
                int alive_neighbours = FindAliveNeighbours(pre_arr, i, j, N);
                // For live cell
                if(Objects.equals(pre_arr[i][j], '*')){
                    if(alive_neighbours<2||alive_neighbours>3){
                        arr[i][j]='.';
                        //System.out.println(alive_neighbours);
                    }
                }
                // for dead cells
                else {
                    if(alive_neighbours==3){
                        arr[i][j]='*';
                    }
                }
            }
        }
        return arr;
    }

    private static int FindAliveNeighbours(char[][] pre_arr, int i, int j, int N) {
        int ans = 0;
        char temp;
        for (int l = -1; l <2; l++) {
            for (int m = -1; m < 2; m++) {
                temp=pre_arr[i + l][j + m];
                if (temp=='*') {
                    ans= ans+1;
                }
            }
        }
        if(pre_arr[i][j]=='*'){
            ans=ans-1;
        }
        return ans;
    }

    public static void main(String []args){
        int N = 6;
        int steps = 4;
        // '.' represent dead cells
        // '*' represent live cells
        // Initializing board
        char arr[][] = {{'.','.','.','.','.','.'},
                {'.','*','*','.','.','.'},
                {'.','.','*','.','.','.'},
                {'.','*','.','*','.','.'},
                {'.','*','*','.','*','.'},
                {'.','.','.','.','.','.'}};
        // Printing initial state of board
        System.out.println("Initial board state is");
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println("");
        }
        ConwaysGame(arr,N,steps);
    }

}

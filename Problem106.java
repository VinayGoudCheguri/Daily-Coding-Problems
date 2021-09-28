public class Problem106 {
    public static void main(String[] args){
        int arr[] = {2, 0, 1, 0};
        System.out.println(IsPossible(arr));
        System.out.println(IsPossible(new int[] {1, 1, 0, 1}));
    }

    private static boolean IsPossible(int[] arr) {
        boolean bool[] = new boolean[arr.length];
        bool[arr.length-1]=true;
        int index = arr.length-2;
        while (index>=0){
            if(arr[index]+index >= arr.length-1){
                bool[index]=true;
            }
            else {
                for (int i=index+1;i<index+1+arr[index];i++){
                    if(bool[i]==true){
                        bool[index]=true;
                    }
                }
            }

            index--;
        }
        return bool[0];
    }
}

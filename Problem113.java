public class Problem113 {
    public static void main(String[] args){
        String str = "hello world here";
        System.out.println(ReverseWords(str.toCharArray()));
    }

    private static String ReverseWords(char[] arr) {
        int i,j=0;
        for(i=0;i<arr.length;i++){
            if(arr[i]==' '){
                ReverseWord(arr,j,i-1);
                j=i+1;
            }
            else {
                if(i== arr.length-1){
                    ReverseWord(arr,j,i);
                }
            }
        }
        ReverseWord(arr,0, arr.length-1);
        return String.valueOf(arr);
    }

    private static void ReverseWord(char[] arr, int j, int i) {
        while (j<i){
            swap(arr,j,i);
            j++;
            i--;
        }
    }

    private static void swap(char[] arr, int j, int i) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

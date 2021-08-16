public class Problem_63 {
    private static boolean FindTargetWord(char[][] matrix, String target_word) {
        for(int i = 0;i<=matrix[0].length;i++){
            for(int j = 0;j<=matrix[0].length;j++){
                Boolean bool1 =HorizontalCheck(matrix,target_word,i,j);
                Boolean bool2 = VerticalCheck(matrix,target_word,i,j);
                if(bool1||bool2){
                    return true;
                }
            }
        }
        return false;
    }

    private static Boolean VerticalCheck(char[][] matrix, String target_word, int i, int j) {
        if(j+target_word.length()>matrix[0].length){
            return false;
        }
        for(int k =0;k<target_word.length();k++){
            if(matrix[i][j+k]!=target_word.charAt(k)){
                return false;
            }
        }
        return true;
    }

    private static Boolean HorizontalCheck(char[][] matrix, String target_word, int i, int j) {
        if(i+target_word.length()>matrix[0].length){
            return false;
        }
        for(int k =0;k<target_word.length();k++){
            if(matrix[i+k][j]!=target_word.charAt(k)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        char[][] matrix = {{'F', 'A', 'C', 'I'},
                {'O', 'B', 'Q', 'P'},
                {'A', 'N', 'O', 'B'},
                {'M', 'A', 'S', 'S'}};
        String target_word = "FOAM";
        if(FindTargetWord(matrix,target_word)){
            System.out.println("Target word is present");
        }
        else {
            System.out.println("Target word is absent");
        }
    }
}

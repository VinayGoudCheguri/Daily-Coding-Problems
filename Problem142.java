public class Problem142 {
    public static void main(String[] args){
        String str = "(*)";
        System.out.println(IsBalanced(str));
    }

    private static boolean IsBalanced(String str) {
        int stars = 0;
        int opened_brackets = 0;
        int length = str.length();
        for (int i=0;i<length;i++){
            if(str.charAt(i)=='('){
                opened_brackets++;
            }
            else if(str.charAt(i)==')'){
                if(opened_brackets>0){
                    opened_brackets--;
                }
                else if(stars>0){
                    stars--;
                }
                else {
                    return false;
                }
            }
            else {
                stars++;
            }
        }
        if(stars>=opened_brackets){
            return true;
        }
        else {
            return false;
        }
    }
}

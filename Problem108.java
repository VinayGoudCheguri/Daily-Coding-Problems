public class Problem108 {
    public static void main(String[] args){
        String A ="abc";
        String B = "acb";
        System.out.println(CanBeShifted(A,B));
    }

    private static boolean CanBeShifted(String a, String b) {
        if(a.length()!=b.length()){
            return false;
        }
        else {
            for (int i=0;i<a.length();i++){
                String c = Rotate(a,i);
                if(c.equals(b)){
                    return true;
                }
            }
        }
        return false;
    }

    private static String Rotate(String a, int n) {
        int length = a.length();
        char strtochar[] = new char[length];
        for (int i=0;i<length;i++){
            strtochar[(i+n)%length]= a.charAt(i);
        }
        a = null;
        for (int i=0;i<length;i++){
            if(a==null){
                a = String.valueOf(strtochar[0]);
            }
            else {
                a = a.concat(String.valueOf(strtochar[i]));
            }
        }
        return a;
    }
}

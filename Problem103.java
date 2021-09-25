public class Problem103 {
    public static void main(String[] args){
        String str = "figehaeci";
        String characters = "aeci";
        String substring = ShortestSubString(str,characters);
        System.out.println("The shortest substring is "+substring);
    }

    private static String ShortestSubString(String str, String characters) {
        int arr[] = new int[256];
        int sp=0,ep=0;
        int left=0,right=0;
        int count = 0;
        int sunstr_length = Integer.MAX_VALUE;
        for (int i=0;i<characters.length();i++){
            arr[characters.charAt(i)]++;
            count++;
        }
        while(right<str.length()){
            arr[str.charAt(right)]--;
            if(arr[str.charAt(right)]==0){
                count--;
            }
            if(count==0){
                while (count==0){
                    if(sunstr_length>right-left+1){
                        sunstr_length= Math.min(right-left+1,sunstr_length);
                        sp = left;
                        ep = right;
                    }
                    arr[str.charAt(left)]++;
                    if (arr[str.charAt(left)]>0){
                        count++;
                    }
                    left++;
                }
            }
            right++;
        }
        return str.substring(sp,ep+1);
    }
}

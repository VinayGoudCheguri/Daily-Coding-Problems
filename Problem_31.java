public class Problem_31 {
    static int editDist(String str1, String str2)
    {
        int[] arr = new int[26];
        // arr[i] is increased by 1 if arr[i] is present in str1
        for (int i = 0; i < str1.length(); i++) {
            arr[str1.charAt(i) - 'a']++;
        }
        // arr[i] is decreased by 1 if arr[i] is present in str2
        for (int i = 0; i < str2.length(); i++) {
            arr[str2.charAt(i) - 'a']--;
        }
        int temp1 = 0;
        int temp2 = 0;

        for (int i=0;i<26;i++) {
            if(arr[i] > 0)
                temp1+= arr[i];
            if(arr[i] < 0)
                temp2-= arr[i];
        }

        return Math.max(temp1,temp2);
    }

    public static void main(String args[])
    {
        String str1 = "kitten";
        String str2 = "sitting";
        System.out.println("Edit distance is "+editDist(str1, str2));
    }
}

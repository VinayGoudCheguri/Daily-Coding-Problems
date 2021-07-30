public class Problem_46 {
    private static String LongestPalindromicSubstring(String str) {
        int len = str.length();
        boolean table[][] = new boolean[len][len];
        int maxLength = 1;
        // All diagonal elements are substrings
        for (int i = 0; i < len; i++) {
            table[i][i] = true;
        }

        int start = 0;
        // 2 letter palindrome
        for (int i = 0; i < len - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                table[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }
        // lengths greater than 2.
        for (int k = 3; k <= len; k++) {
            // i is starting index
            for (int i = 0; i < len - k + 1; i++) {
                int j = i + k - 1; // ending index
                if (table[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
                    table[i][j] = true;
                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
        return str.substring(start,start + maxLength);
    }

    public static void main(String[] args) {
        String ans = LongestPalindromicSubstring("aabcdcb");
        System.out.println("Longest palindromic substring is "+ans);
    }
}

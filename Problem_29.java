public class Problem_29 {
    public static String encode(String str) {
        StringBuilder sb = new StringBuilder();
        char ch = '\0';
        int length = 0;
        for (int i = 0; i < str.length(); i++) {
            if (ch == '\0' || ch == str.charAt(i)) {
                ch = str.charAt(i);
                length++;
            }
            else {
                sb.append(length).append(ch);
                ch = str.charAt(i);
                length = 1;
            }
        }
        sb.append(length).append(ch);
        return sb.toString();
    }

    public static String decode(String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            int length = str.charAt(i++) - '0';
            char ch = str.charAt(i++);
            for (int j = 0; j < length; j++) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String []args) {
        System.out.println(encode("AAAABBBCCDAA"));
        System.out.println(decode("4A3B2C1D2A"));
    }
}

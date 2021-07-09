public class Problem_25 {
    private static boolean isMatches(String str, int i, String reg_exp, int j) {
        if (j >= reg_exp.length()) {
            return i >= str.length();
        }
        if (i >= str.length()) {
            return j >= reg_exp.length();
        }
        // * matches zero or more of the preceding element
        if (reg_exp.charAt(j) == '*') {
            // if * is last in reg_exp return true
            if (j + 1 == reg_exp.length()) {
                return true;
            }
            // if * is not the last element
            // if * matches 0 elements
            if (isMatches(str, i, reg_exp, j + 1)) {
                return true;
            }
            // if * matches more than 0 elements
            for (int k = 1; k < str.length(); k++) {
                if (isMatches(str, i + k, reg_exp, j + 1))
                    return true;
            }
        }
        // . can match any single element
        else if (str.charAt(i) == reg_exp.charAt(j) || reg_exp.charAt(j) == '.')
            return isMatches(str, i + 1, reg_exp, j + 1);

        return false;
    }

    public static void main(String []args) {
        System.out.println(isMatches("raymond",0, "ra.",0));    // false
        System.out.println(isMatches("ray", 0,"ra.",0));        // true
        System.out.println(isMatches("chat", 0,"*.at",0));      // true
        System.out.println(isMatches("chats",0, "*.at",0));     // false
    }
}
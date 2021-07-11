import java.util.Stack;

public class Problem_27 {
    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{')
                stack.push(ch);
            else {
                if (stack.isEmpty())
                    return false;

                char prv = stack.pop();

                if ((prv == '(' && ch != ')')||(prv == '[' && ch != ']')||(prv == '{' && ch != '}')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String... args) {
        System.out.println(isBalanced("([])[]({})"));   // true
        System.out.println(isBalanced("([)]"));         // false
    }
}
import java.util.Stack;

public class Problem_86 {
    public static void main(String[] args){
        String str = "()())()";
        int ans = MakeValidString(str);
        System.out.println("Minimum number of parentheses to be removed is "+ans);
    }

    private static int MakeValidString(String str) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c=='('||c=='{'||c=='['){
                stack.add(c);
            }
            else {
                if(c==')'){
                    if(!stack.empty()&&stack.peek()=='('){
                        stack.pop();
                    }
                    else {
                        count++;
                    }
                }
                else if(c=='}'){
                    if(!stack.empty()&&stack.peek()=='{'){
                        stack.pop();
                    }
                    else {
                        count++;
                    }
                }
                else {
                    if(!stack.empty()&&stack.peek()=='['){
                        stack.pop();
                    }
                    else {
                        count++;
                    }
                }
            }
        }
        count+=stack.size();
        return count;
    }
}

import java.util.ArrayList;
import java.util.Stack;

public class Problem163 {
    public static void main(String[] args){
        Object[] objects = new Object[] { 15, 7, 1, 1, '+', '-', '/', 3, '*', 2, 1, 1, '+', '+', '-' };
        System.out.println(EvaluateReversePolishNotation(objects));
    }

    private static double EvaluateReversePolishNotation(Object[] objects) {
        Stack<Double> stack = new Stack<>();
        for (Object obj:objects){
            if(obj instanceof Number){
                stack.add(((Number) obj).doubleValue());
            }else {
                Double rightOperand = stack.pop();
                Double leftOperand = stack.pop();
                if ((Character) obj == '+')
                    stack.push(leftOperand + rightOperand);
                else if ((Character) obj == '-')
                    stack.push(leftOperand - rightOperand);
                else if ((Character) obj == '/')
                    stack.push(leftOperand/rightOperand);
                else if ((Character) obj == '*')
                    stack.push(leftOperand*rightOperand);
            }
        }
        return stack.pop();
    }
}

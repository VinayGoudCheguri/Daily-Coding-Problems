public class Problem_43 {
    static int size = 20;
    public static class Stack{
        static int[] values;
        static int[] cur_max;
        static int count;
        public Stack() {
            values = new int[size];
            cur_max = new int[size];
            count = -1;
        }
        public void push(int x){
            count++;
            values[count] = x;
            if(count==0){
                cur_max[count]=x;
            }
            else{
                cur_max[count] = Math.max(values[count],cur_max[count-1]);
            }
        }
        public int max(){
            return cur_max[count];
        }
        public int pop(){
            count--;
            return values[count+1];
        }
    }

    public static void main(String []args){
        Stack stack = new Stack();
        int temp;
        stack.push(9);
        temp = stack.max();
        System.out.println("current maximum value is "+temp);
        stack.push(5);
        temp = stack.max();
        System.out.println("current maximum value is "+temp);
        stack.push(10);
        temp = stack.max();
        System.out.println("current maximum value is "+temp);
        temp = stack.pop();
        System.out.println("Topmost element is "+temp);

    }
}

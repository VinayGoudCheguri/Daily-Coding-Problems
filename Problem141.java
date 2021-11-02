public class Problem141 {
    static int LIST_SIZE = 100;
    public static void main(String[] args){
        stack self = new stack();
        self.init(self);
        self.push(self,1,0);
        self.push(self,2,1);
        self.push(self,3,2);
        System.out.println(self.pop(self,0));
        System.out.println(self.pop(self,1));
        System.out.println(self.pop(self,2));
    }

    public static class stack{
        int[] list;
        int pointer1,pointer2,pointer3;
        public void init(stack stack) {
            stack.list = new int[LIST_SIZE];
            this.pointer1 = 0;
            this.pointer2 = LIST_SIZE/3;
            this.pointer3 = 2*LIST_SIZE/3;
        }

        public int pop(stack stack,int stack_number) {
            int pointer;
            if(stack_number==0){
                pointer=pointer1;
                pointer1--;
            }
            else if(stack_number==1){
                pointer=pointer2;
                pointer2--;
            }
            else {
                pointer=pointer3;
                pointer3--;
            }
            return stack.list[pointer];
        }

        public void push(stack stack,int item,int stack_number) {
            if(stack_number==0){
                pointer1++;
                stack.list[pointer1] = item;
            }
            else if(stack_number==1){
                pointer2++;
                stack.list[pointer2] = item;
            }
            else {
                pointer3++;
                stack.list[pointer3] = item;
            }
        }
    }
}

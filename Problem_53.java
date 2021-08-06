import java.util.Deque;
import java.util.LinkedList;

public class Problem_53 {
    public static class Queue<Val> {
        private final Deque<Val> stack1 = new LinkedList<>();
        private final Deque<Val> stack2 = new LinkedList<>();
        Val ans;
        // directly add to stack1
        public void enqueue(Val value) {
            stack1.push(value);
        }

        //
        public Val dequeue() {
            // shift all elements to stack 2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.remove());
            }
            ans = stack2.remove();
            // Again shift to stack1
            while (!stack2.isEmpty()) {
                stack1.push(stack2.remove());
            }
            return ans;
        }
    }

    public static void main(String[] args){
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println(queue.dequeue() + " is removed from the queue");
        System.out.println(queue.dequeue() + " is removed from the queue");
        System.out.println(queue.dequeue() + " is removed from the queue");
        System.out.println(queue.dequeue() + " is removed from the queue");
        System.out.println(queue.dequeue() + " is removed from the queue");
    }
}

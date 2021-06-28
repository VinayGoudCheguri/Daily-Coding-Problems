import java.util.Timer;
import java.util.TimerTask;

public class Problem_10 {
	// class containing method f to be called
    public static class Command{
    	int n;
    	public void f() {
    		System.out.println("f is called after "+n+" milliseconds");
        }
    }
    // solution is the job scheduler
    // calls f after n milliseconds
    public static void solution(Command command, int n) {
    	new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                command.f();
            }
        }, n);
    }
    
	public static void main(String args[]) {
		int n = 3000;// milliseconds
		System.out.println("Program started");
		Command c =new Command();
		c.n =n;
        solution(c, n);
    }
}

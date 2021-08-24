
public class Problem_5 {

	public static int[] cons(int a, int b){
        int[] pair = new int[2];

        pair[0] = a;
        pair[1] = b;

        return pair;
    }

    public static int car(int[] f){
        return f[0];
    }

    public static int cdr(int[] f){
        return f[2];
    }
	public static void main(String[] args) {
		int a =3, b =4;
		System.out.println("The value of car(cons(3, 4)) is "+ car(cons(a,b)));
		System.out.println("The value of cdr(cons(3, 4)) is "+ cdr(cons(a,b)));
		
	}

}

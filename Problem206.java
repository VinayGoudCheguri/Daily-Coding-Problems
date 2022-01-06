package DCP;

import java.util.Arrays;

public class Problem206 {
    public static void main(String[] args) {
        char[] A = {'a','b','c'};
        int[] P = {2,1,0};
        char[] B = FindPermutaions(A,P);
        System.out.println(Arrays.toString(A));
    }

    private static char[] FindPermutaions(char[] a, int[] p) {
        for (int i = 0; i< p.length/2; i++) {
            if(p[i]!=i){
                swap(a,i,p[i]);
            }
        }
        return a;
    }

    private static void swap(char[] A, int i, int i1) {
        char temp = A[i1];
        A[i1] = A[i];
        A[i] = temp;
    }
}


import java.util.Arrays;

public class Problem_51 {
    private static void Shuffle(int[] arr) {
        int max = 52;
        int min = 1;
        int range = max - min + 1;
        for (int i = 0; i < 10; i++) {
            int rand = (int) (Math.random() * range) + min;
            int temp = arr[i];
            arr[i]= arr[rand-1];
            arr[rand-1] = temp;
        }
        System.out.println("Deck of cards after shuffling is ");
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args){
        // arr represents deck of cards
        int[] arr = new int[52];
        for(int i=0;i<52;i++){
            arr[i] = 1+i;
        }
        System.out.println("Deck of cards before shuffling is ");
        System.out.println(Arrays.toString(arr));
        Shuffle(arr);
    }

}

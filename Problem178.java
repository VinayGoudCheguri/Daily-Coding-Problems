public class Problem178 {
    public static void main(String[] args){
        double prob1 = gameA();
        double prob2 = gameB();
        if(prob1>prob2){
            System.out.println("Alice should play game A");
        }else {
            System.out.println("Alice should play game B");
        }
    }

    private static double gameB() {
        double count =0;
        int throw1=0,throw2=0;
        while (!(throw1==5&&throw2==5)){
            throw1 = throw2;
            if(throw1==5){
                throw2 = throwDice();
                count++;
            }else {
                throw1 = throwDice();
                throw2 = throwDice();
                count+=2;
            }
        }
        System.out.println("It takes to roll "+ (int)count +" times in game B");
        return 1/count;
    }

    private static double gameA() {
        double count =0;
        int throw1=0,throw2=0;
        while (!(throw1==5&&throw2==6)){
            throw1 = throw2;
            if(throw1==5){
                throw2 = throwDice();
                count++;
            }else {
                throw1 = throwDice();
                throw2 = throwDice();
                count+=2;
            }
        }
        System.out.println("It takes to roll "+ (int)count +" times in game A");
        return 1/count;
    }

    private static int throwDice() {
        return (int )(Math.random() * 6 + 1);
    }
}

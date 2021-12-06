public class Problem175 {
  static int count_a=0;
  static int count_b=0;
  static int count_c=0;
  public static void main(String[] args){
    char startingStage ='a';
    int noOfSteps = 5000;
    MarkovChain(startingStage,noOfSteps);
    System.out.println("a: "+count_a+"\t"+"b: "+count_b+"\t"+"c: "+count_c);
  }

  private static void MarkovChain(char startingStage, int noOfSteps) {
    if(noOfSteps==0){
      return;
    }
    double rand = Math.random();
    if(startingStage=='a'){

      if(rand<=0.9){
        count_a++;
        MarkovChain('a',noOfSteps-1);
      }else if(rand<=0.975){
        count_b++;
        MarkovChain('b',noOfSteps-1);
      }else {
        count_c++;
        MarkovChain('c',noOfSteps-1);
      }

    }else if(startingStage=='b'){

      if(rand<=0.15){
        count_a++;
        MarkovChain('a',noOfSteps-1);
      }else if(rand<=0.95){
        count_b++;
        MarkovChain('b',noOfSteps-1);
      }else {
        count_c++;
        MarkovChain('c',noOfSteps-1);
      }

    }else {

      if(rand<=0.25){
        count_a++;
        MarkovChain('a',noOfSteps-1);
      }else if(rand<=0.5){
        count_b++;
        MarkovChain('b',noOfSteps-1);
      }else {
        count_c++;
        MarkovChain('c',noOfSteps-1);
      }

    }
  }

}

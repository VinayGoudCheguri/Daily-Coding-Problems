public class Problem120 {
    public static void main(String[] args){
        System.out.println(SampleClass.getInstance().instance);
        System.out.println(SampleClass.getInstance().instance);
    }
    public static class SampleClass{
        String instance;
        public static SampleClass odd = new SampleClass("first instance");
        public static SampleClass even = new SampleClass("second instance");
        static boolean ODD= true;

        public static SampleClass getInstance(){
            if(ODD){
                ODD = false;
                return odd;
            }
            else {
                return even;
            }
        }
        public SampleClass(String instance) {
            this.instance = instance;
        }
    }
}

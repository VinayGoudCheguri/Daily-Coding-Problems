import java.util.ArrayList;

public class Problem148 {
    public static void main(String[] args){
        int n = 2;
        ArrayList<String> grayArr = Gray(n);
        for (int i = 0 ; i < grayArr.size(); i++)
        {
            System.out.println(grayArr.get(i));
        }
    }

    private static ArrayList<String> Gray(int n) {
        if (n <= 0)
        {
            ArrayList<String> temp = new ArrayList<String>(){
                {add("0");}};
            return temp;
        }else if(n == 1)
        {
            ArrayList<String> temp =
                    new ArrayList<String>(){{add("0");add("1");}};
            return temp;
        }

        ArrayList<String> prev = Gray(n-1);
        ArrayList<String> curr = new ArrayList<>();
        for (String str:prev){
            curr.add("0".concat(str));
        }
        for (String str:prev){
            curr.add("1".concat(str));
        }
        return curr;
    }
}

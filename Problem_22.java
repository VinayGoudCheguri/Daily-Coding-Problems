import java.util.HashSet;
import java.util.Set;

public class Problem_22 {
    public static boolean wordBreak(String word,String ans,Set<String> Dictionary)
    {
        int size = word.length();
        // base case
        if (size == 0) {
            System.out.println(ans);
            return true;
        }

        //else check for all words
        int i =1;
        while (i <= size) {
            if (Dictionary.contains(word.substring(0,i)) &&
                    wordBreak(word.substring(i,size),ans+" "+word.substring(0,i),Dictionary))
                return true;
            i++;
        }
        return false;
    }

    public static void main(String []args)
    {
        String dictionary[] = {"quick","brown","the","fox",
                "bed","bath","bedbath","beyond"};
        Set<String> Dictionary = new HashSet<>();
        for (String temp :dictionary)
        {
            Dictionary.add(temp);
        }
        String ans="";
        wordBreak("thequickbrownfox",ans,Dictionary);
    }
}

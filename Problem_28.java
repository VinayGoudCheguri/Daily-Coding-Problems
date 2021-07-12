import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_28 {
    public static List<String> add_words(List<String> words, int k) {
        List<String> line = new ArrayList<>();
        List<String> lines = new ArrayList<>();
        int length = 0; // size of text in each line excluding spaces
        for (String word : words) {
            // if text size + spaces+ new word size > K
            if (length + line.size() + word.length() > k) {
                lines.add(adjust(line, length, k));
                line.clear();
                length = 0;
            }
            line.add(word);
            length += word.length();
        }
        // adding last line
        if (!line.isEmpty()) {
            lines.add(adjust(line, length, k));
        }
        return lines;
    }
    // this method adjusts spaces in each line
    private static String adjust(List<String> words, int length, int k) {
        int[] spaces = new int[words.size() - 1];
        // adding spaces uniformly
        while (length < k) {
            for (int i = 0; i < spaces.length && length < k; i++) {
                spaces[i]++;
                length++;
            }
        }

        int i = 0;
        StringBuilder str = new StringBuilder();

        for (String word : words) {
            // adding text to string
            str.append(word);
            // adding spaces to string
            if (i < spaces.length) {
                for (int j = 0; j < spaces[i]; j++)
                    str.append(' ');

                i++;
            }
        }

        return str.toString();
    }

    public static void main(String... args) {
        List<String> ans = new ArrayList<>();
        ans = add_words(Arrays.asList("the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"),16);
        for(String str:ans){
            System.out.println(str);
        }
    }
}
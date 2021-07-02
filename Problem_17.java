
public class Problem_17 {
	public static int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        String[] tokens = input.split("\n");
        int[] dirs = new int[tokens.length]; // to store path until just before file name
        int max = 0;
        for (int i = 0; i < tokens.length; i ++) {
            String s = tokens[i];
            // count is no of \ts present in s
            int count = s.lastIndexOf("\t") + 1;
            //System.out.println(count);
            s = s.substring(count);
            // now \ts are removed
            if (s.indexOf(".") != -1) {
                //if s is a file
                int curr = s.length();
                if (count != 0) {
                    curr = dirs[count - 1] + s.length();
                }
                max = Math.max(max, curr);
            }
            else {
                //in case of folder
                dirs[count] = s.length() + 1; // 1 is extra as / is added to path
                if (count != 0) {
                    dirs[count] += dirs[count - 1];// path includes previous line also
                }
            }
        }
        return max;
    }
	public static void main(String[] args) {
		String str = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
		int ans = lengthLongestPath(str);
		System.out.println("The length of the longest path is "+ans);
		
	}
}

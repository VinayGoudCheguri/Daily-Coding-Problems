public class Problem_49 {
    private static int MaxSum(int[] arr) {
        int size = arr.length;
        int max = Integer.MIN_VALUE;
        int curr_max = 0;

        for (int i = 0; i < size; i++)
        {
            curr_max = curr_max + arr[i];
            if (max < curr_max)
                max = curr_max;
            if (curr_max < 0)
                curr_max = 0;
        }
        return max;
    }

    public static void main (String[] args)
    {
        int[] arr = {34, -50, 42, 14, -5, 86};
        int ans = MaxSum(arr);
        System.out.println("Maximum sum is " + ans);
    }

}

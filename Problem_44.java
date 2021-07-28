public class Problem_44 {
    private static int Count_Merge(int[] arr, int l, int m, int r) {
        int swaps = 0;
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1]; // left array
        int[] R = new int[n2]; // right array

        System.arraycopy(arr, l, L, 0, n1);
        System.arraycopy(arr, m+1, R, 0, n2);
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else { // Here swapping is done
                arr[k] = R[j];
                swaps += (m+1) - (l+i);
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
        return swaps;
    }

    private static int Count_Sort(int[] arr, int l, int r) {
        int count = 0;
        if (l < r) {
            int m = (l + r) / 2;
            count += Count_Sort(arr, l, m);
            count += Count_Sort(arr, m + 1, r);
            count += Count_Merge(arr, l, m, r);
        }
        return count;
    }

    public static void main(String[] args)
    {
        int[] arr = { 5, 4, 3, 2, 1};
        int ans = Count_Sort(arr, 0, arr.length - 1);
        System.out.println("The number of inversions is "+ans);
    }

}

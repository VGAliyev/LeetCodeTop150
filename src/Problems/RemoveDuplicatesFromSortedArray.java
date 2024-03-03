package Problems;

public class RemoveDuplicatesFromSortedArray {
    //https://leetcode.com/problems/remove-duplicates-from-sorted-array/submissions/1192792350?envType=study-plan-v2&envId=top-interview-150
    // 3 ms Beats 11.05% / 44.46 MB Beats 88.39%
    public int removeDuplicates(int[] numbers) {
        int k = numbers.length;
        int i = 0;
        int r = numbers[0];
        while(i < numbers.length - 1) {
            if (numbers[i + 1] == r) {
                numbers[i + 1] = -101;
                i++;
                k--;
            } else {
                r = numbers[i + 1];
                i++;
            }
        }
        for (int j = 0; j < k; j++) {
            if (numbers[j] == -101) {
                numbers[j] = findNextVal(numbers, j);
            }
        }
        return k;
    }

    private int findNextVal(int[] numbers, int index) {
        int result = -101;
        for (int i = index + 1; i < numbers.length; i++) {
            if (numbers[i] != -101) {
                result = numbers[i];
                numbers[i] = -101;
                return result;
            }
        }
        return result;
    }
}

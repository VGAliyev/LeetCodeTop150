package Problems;

public class RemoveElement {
    // https://leetcode.com/problems/remove-element/submissions/1192730550?envType=study-plan-v2&envId=top-interview-150
    // 0 ms Beats 100.00% / 41.77 MB Beats 67.50%
    public int removeElement(int[] numbers, int val) {
        int numsEqValCount = numbers.length;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == val) {
                numsEqValCount--;
                numbers[i] = findNextNotVal(numbers, i, val);
            }
        }
        for (int i = 0; i < numsEqValCount; i++) {
            if(numbers[i] == -1) {
                numbers[i] = findNextNotVal(numbers, i, val);
            }
        }
        return numsEqValCount;
    }

    private int findNextNotVal(int[] numbers, int index, int val) {
        int result = -1;
        for (int i = index; i < numbers.length; i++) {
            if(numbers[i] != val && numbers[i] != -1) {
                result = numbers[i];
                numbers[i] = -1;
                return result;
            }
        }
        return result;
    }
}

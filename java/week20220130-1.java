import java.util.Arrays;

class Solution {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        while (true) {
            int search = Arrays.binarySearch(nums, original);
            if (search < 0) {
                break;
            } else {
                original *= 2;
            }
        }

        return original;
    }
}
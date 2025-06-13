import java.util.Arrays;

class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums[nums.length - 1] - nums[0];

        while (left < right) {
            int mid = (left + right) / 2;
            if (canFormPairs(nums, mid, p)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canFormPairs(int[] nums, int maxDiff, int p) {
        int count = 0;
        int i = 0;

        while (i + 1 < nums.length) {
            if (nums[i + 1] - nums[i] <= maxDiff) {
                count++;
                i += 2; // use this pair
            } else {
                i += 1;
            }
        }

        return count >= p;
    }
}

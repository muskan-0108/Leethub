class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = potions.length;
        int[] ans = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            int spell = spells[i];
            long minPotion = (success + spell - 1) / spell; // ceil(success / spell)

            int idx = binarySearch(potions, minPotion);
            ans[i] = n - idx; // count of successful potions
        }
        return ans;
    }

    // Find the first potion >= target using binary search
    private int binarySearch(int[] potions, long target) {
        int left = 0, right = potions.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (potions[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
        
    }
}
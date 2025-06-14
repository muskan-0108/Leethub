class Solution {
    public int minMaxDifference(int num) {
        String s = String.valueOf(num);

        // For maximum value: replace first non-9 digit with 9
        char toMax = ' ';
        for (char c : s.toCharArray()) {
            if (c != '9') {
                toMax = c;
                break;
            }
        }
        String maxStr = (toMax == ' ') ? s : s.replace(toMax, '9');
        int maxVal = Integer.parseInt(maxStr);

        // For minimum value: replace first digit with 0
        char toMin = s.charAt(0);
        String minStr = s.replace(toMin, '0');
        int minVal = Integer.parseInt(minStr);

        return maxVal - minVal;
    }
}

class Solution {
    public int maxDiff(int num) {
        String s = String.valueOf(num);

        // Build maximum number a
        char x = 0;
        for (char c : s.toCharArray()) {
            if (c != '9') {
                x = c;
                break;
            }
        }
        String a = (x == 0) ? s : s.replace(x, '9');

        // Build minimum number b
        char y = s.charAt(0) != '1' ? s.charAt(0) : 0;
        if (y == 0) {
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) != '0' && s.charAt(i) != '1') {
                    y = s.charAt(i);
                    break;
                }
            }
        }
        String b = (y == 0) ? s : s.replace(y, y == s.charAt(0) ? '1' : '0');

        return Integer.parseInt(a) - Integer.parseInt(b);
    }
}

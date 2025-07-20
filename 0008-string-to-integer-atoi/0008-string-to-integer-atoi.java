class Solution {
    public int myAtoi(String s) {
    int i = 0, n = s.length();
    int sign = 1;
    long result = 0;

    // Step 1: Skip leading whitespaces
    while (i < n && s.charAt(i) == ' ') {
        i++;
    }

    // Step 2: Handle optional '+' or '-' sign
    if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
        sign = (s.charAt(i) == '-') ? -1 : 1;
        i++;
    }

    // Step 3: Convert digits to number
    while (i < n && Character.isDigit(s.charAt(i))) {
        result = result * 10 + (s.charAt(i) - '0');

        // Step 4: Clamp to int range
        if (sign == 1 && result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (sign == -1 && -result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        i++;
    }

    return (int) (sign * result);
}

        
    }
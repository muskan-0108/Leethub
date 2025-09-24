class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        // Handle divide by zero (LeetCode won't give denom==0, but keep safe)
        if (denominator == 0) return "";

        // Important fix: if numerator is 0, result must be "0" (no "-0")
        if (numerator == 0) return "0";

        StringBuilder result = new StringBuilder();

        // Handle sign (safe now because numerator != 0)
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // Integer part
        result.append(num / den);
        num %= den;

        // If no fractional part
        if (num == 0) {
            return result.toString();
        }

        result.append(".");
        Map<Long, Integer> map = new HashMap<>();

        // Fractional part with remainder-position mapping
        while (num != 0) {
            if (map.containsKey(num)) {
                int idx = map.get(num);
                result.insert(idx, "(");
                result.append(")");
                break;
            }
            map.put(num, result.length());
            num *= 10;
            result.append(num / den);
            num %= den;
        }

        return result.toString();
    }
}

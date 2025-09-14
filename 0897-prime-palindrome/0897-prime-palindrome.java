class Solution {
    public int primePalindrome(int n) {
        // Special case: only even-length prime palindrome is 11
        if (n <= 2) return 2;
        if (n <= 3) return 3;
        if (n <= 5) return 5;
        if (n <= 7) return 7;
        if (n <= 11) return 11;

        // Generate odd-length palindromes only
        for (int len = 1; len <= 9; len++) {
            int start = (int)Math.pow(10, len - 1);
            int end = (int)Math.pow(10, len);

            for (int half = start; half < end; half++) {
                String s = Integer.toString(half);
                String palindromeStr = s + new StringBuilder(s.substring(0, s.length() - 1)).reverse();
                int palindrome = Integer.parseInt(palindromeStr);

                if (palindrome >= n && isPrime(palindrome)) {
                    return palindrome;
                }
            }
        }
        return -1; // should never reach because problem guarantees an answer
    }

    // Standard primality check
    private boolean isPrime(int num) {
        if (num < 2) return false;
        if (num % 2 == 0) return num == 2;
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }
}

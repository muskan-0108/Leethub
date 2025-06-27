class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        List<Character> chars = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            int count = freq[c - 'a'] / k;
            for (int i = 0; i < Math.min(count, 8); i++) {
                chars.add(c);
            }
        }

        String[] res = {""};
        dfs(chars, "", s, k, res);
        return res[0];
    }

    void dfs(List<Character> chars, String path, String s, int k, String[] res) {
        if (path.length() > res[0].length() || 
           (path.length() == res[0].length() && path.compareTo(res[0]) > 0)) {
            if (isValid(path, s, k)) {
                res[0] = path;
            }
        }

        if (path.length() >= 7) return;

        for (char c = 'z'; c >= 'a'; c--) {
            int count = Collections.frequency(chars, c);
            if (count == 0) continue;
            chars.remove((Character)c);
            dfs(chars, path + c, s, k, res);
            chars.add(c);
        }
    }

    boolean isValid(String t, String s, int k) {
        String target = t.repeat(k);
        int i = 0;
        for (char c : s.toCharArray()) {
            if (i < target.length() && c == target.charAt(i)) i++;
        }
        return i == target.length();
    }
}

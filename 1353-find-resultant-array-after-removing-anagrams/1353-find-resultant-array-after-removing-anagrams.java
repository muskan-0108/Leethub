class Solution {
    public List<String> removeAnagrams(String[] words) {
         List<String> result = new ArrayList<>();
        String prev = "";

        for (String word : words) {
            if (!isAnagram(prev, word)) {
                result.add(word);
                prev = word;
            }
        }

        return result;
    }

    private boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;

        int[] count = new int[26];
        for (char c : a.toCharArray()) count[c - 'a']++;
        for (char c : b.toCharArray()) count[c - 'a']--;

        for (int i : count) {
            if (i != 0) return false;
        }

        return true;
        
    }
}
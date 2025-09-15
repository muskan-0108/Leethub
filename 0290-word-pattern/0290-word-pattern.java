class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(words.length!=pattern.length()) return false;
        Map<Character, String> m = new HashMap<>();
        Set<String> used = new HashSet<>();

        for(int i=0;i<pattern.length();i++){
            char c= pattern.charAt(i);
            String word = words[i];

            if(m.containsKey(c)){
                if(!m.get(c).equals(word)) return false;
            }else {
                if(used.contains(word)) return false;
                m.put(c,word);
                used.add(word);
            } 
        }
        return true;
    }
}
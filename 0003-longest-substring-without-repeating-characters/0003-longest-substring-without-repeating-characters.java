class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set=new HashSet<>();
        int L=0;
        int R=0;
        int max=0;
        while(R<s.length()){
            if(!set.contains(s.charAt(R))){
                set.add(s.charAt(R));
                max=Math.max(max,R-L+1);
                R++;
            }else{
                set.remove(s.charAt(L));
                L++;
            }
        }
        return max;
    }
}
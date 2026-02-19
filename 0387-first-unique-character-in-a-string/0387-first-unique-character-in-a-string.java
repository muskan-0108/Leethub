class Solution {
    public int firstUniqChar(String s) {
        int[] freq=new int[26];
        for(char ch:s.toCharArray()){
            int index=ch-'a';
            freq[index]++;
        }
        for(int i=0;i<s.length();i++){
            if(freq[s.charAt(i)-'a']==1) return i; 
        }
        return -1;
    }
}
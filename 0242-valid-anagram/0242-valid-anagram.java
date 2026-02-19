class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freq1=new int[26];
        int[] freq2=new int[26];
        if(s.length()==t.length()){
            for(int i=0;i<s.length();i++){
                int idx=s.charAt(i)-'a';
                freq1[idx]++;
            }
            for(int i=0;i<t.length();i++){
                int idx=t.charAt(i)-'a';
                freq2[idx]++;
            }
            for(int i=0;i<=25;i++){
            if(freq1[i]!=freq2[i]){
                return false;
            }
            }
            return true;
        }
        return false;
        
    }
}
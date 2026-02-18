class Solution {
    public boolean isPalindrome(String s) {
        String ls = s.toLowerCase();
        char[] la=ls.toCharArray();
        int i=0;
        int j=la.length-1;
        while(i<j){
            if(!Character.isLetterOrDigit(la[i])){
                i++;
            }else if(!Character.isLetterOrDigit(la[j])){
                j--;
            }else if(la[i]!=la[j]){
                return false;
            }else {
                i++;
                j--;
            }
        }
        return true;
    }
}
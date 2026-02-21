class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        char[] f = strs[0].toCharArray();
        char[] l = strs[strs.length-1].toCharArray();

        int i=0;
        while(i<f.length && i<l.length){
            if(f[i]!=l[i]){
                break;
            }
            i++;
        }
        return strs[0].substring(0,i);
    }
}
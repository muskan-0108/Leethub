class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String s = "";
        int n=strs.length;
        StringBuilder sb = new StringBuilder();
        char[] left = strs[0].toCharArray();
        char[] right = strs[n-1].toCharArray();
        if(n==0){
            return "";
        }
        int i =0,j=0;
        while(i<left.length && j<right.length){
        if(left[i]==right[j]){
            sb.append(left[i]);
            i++;
            j++;
        }else{
            break;
        }
        }
        return sb.toString();
    }
}
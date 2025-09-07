class Solution {
    public int[] sumZero(int n) {
        int result[] = new int[n];
        int idx=0;
        for(int i=1;i<=n/2;i++){
            result[idx++]=i;
            result[idx++]=-i;
        }
        return result;  
    }
}
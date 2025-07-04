class Solution {
    public boolean isPowerOfTwo(int n) {
        int x=1;
        int count=0;
        while(x>0 && x<=n){
            count+=((n&x)!=0) ? 1:0;
            x<<=1;
        }
        return count==1;
    }
}
class Solution {
    public int longestSubarray(int[] nums) {
        int l=0,zerocount=0,mLen=0;
        for(int r=0;r<nums.length;r++){
            if(nums[r]==0) zerocount++;
        while(zerocount>1){
            if(nums[l]==0) zerocount--;
            l++;
        }
        mLen=Math.max(mLen,r-l);
        }
        return mLen;
    }
}
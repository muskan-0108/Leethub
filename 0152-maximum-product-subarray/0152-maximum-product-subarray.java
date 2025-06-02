class Solution {
    public int maxProduct(int[] nums) {
        int curProd =1, max_prod = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            curProd *= nums[i];
            max_prod = Math.max(curProd,max_prod);

            if(curProd==0){
                curProd =1;
            }
        }
        curProd=1;
        for(int i=nums.length-1;i>=0;i--){
            curProd *= nums[i];
            max_prod = Math.max(curProd,max_prod);

            if(curProd==0){
                curProd =1;
            }
        }
        

        return max_prod;
        
    }
}
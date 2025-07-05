class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> m = new HashMap<>(); //num2[i],ng
        Stack<Integer> s = new Stack<>();

        for(int i=nums2.length-1;i>=0;i--){
            while(s.size()>0 && s.peek()<=nums2[i]){
                s.pop();
            }
            if(s.isEmpty()){
                m.put(nums2[i],-1);
            }else{
                m.put(nums2[i],s.peek());
            }
            s.push(nums2[i]);
        }
        int[] ans = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            ans[i]=m.get(nums1[i]);
        }
        return ans;
    }
}
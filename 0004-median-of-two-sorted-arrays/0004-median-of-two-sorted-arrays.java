class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int[] nums = new int[n+m];

        int i=0;
        int j=0;
        int idx=0;

        while(i<n && j<m){
            if(nums1[i]>nums2[j]){
                nums[idx]=nums2[j];
                j++;
                idx++;
            }else{
                nums[idx]=nums1[i];
                i++;
                idx++;

            }
        }
        while(i<n){
            nums[idx]=nums1[i];
            i++;
            idx++;
        }
        while(j<m){
            nums[idx]=nums2[j];
            j++;
            idx++;
        }

        int l=0;
        int r=nums.length-1;
        int mid=(l+r)/2;

        if(nums.length%2==0){
            return (nums[mid]+nums[mid+1])/2.0;
        }else{
            return nums[mid];
        }
        
    }
}
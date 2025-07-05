class Solution {
    public int trap(int[] a) {
        int l=0;
        int r=a.length-1;
        int lmax=0;
        int rmax=0;
        int ans=0;
        while(l<r){
        lmax=Math.max(lmax,a[l]);
        rmax=Math.max(rmax,a[r]);

        if(rmax>lmax){
          ans+= lmax-a[l];
          l++;
        }else{
            ans+=rmax-a[r];
            r--;
        }

        }
        return ans;
        
    }
}
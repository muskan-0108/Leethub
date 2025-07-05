class Solution {
    public int trap(int[] a) {
        int n=a.length;
        int[] lmax = new int[n];
        int[] rmax = new int[n];
        int ans=0;

        lmax[0]=a[0];
        rmax[n-1]=a[n-1];

        for(int i=1;i<n;i++){
            lmax[i]=Math.max(lmax[i-1],a[i]);
        }
        for(int i=n-2;i>=0;i--){
            rmax[i]=Math.max(a[i],rmax[i+1]);
        }
        for(int i=0;i<n;i++){
            ans+=Math.min(lmax[i],rmax[i])-a[i];
        }
        return ans;
        
    }
}
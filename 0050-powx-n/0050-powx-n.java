class Solution {
    public double myPow(double x, int n) {
        if(n==0) return 1;
        double pow = myPow(x,n/2);

        if(n<0){
            x=1/x;

            if(n==Integer.MIN_VALUE){
                return x*myPow(x,Integer.MAX_VALUE);
            }
            n=-n;
        }

        if(n%2==0){
            return pow*pow;
        }
        return pow*pow*x;
    }
}
class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;

        int num=x;
        int rev=0;
        

        while(num>0){
            int last_digit =num%10;
            rev = (rev*10)+last_digit;
            num = num/10;
        }
        if(x==rev){
            return true;
        }else{
            return false;
        }
        
    }
}
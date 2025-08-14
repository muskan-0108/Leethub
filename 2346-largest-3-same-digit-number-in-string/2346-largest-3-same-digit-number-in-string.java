class Solution {
    public String largestGoodInteger(String num) {
        for (char d = '9'; d >= '0'; d--) {
            String triplet = "" + d + d + d;
            if (num.contains(triplet)) {
                return triplet;
            }
        }
        return "";
    }
}

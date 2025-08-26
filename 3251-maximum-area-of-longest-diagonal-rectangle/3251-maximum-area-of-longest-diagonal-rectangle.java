class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        long bestD2 = -1;
        int bestArea = 0;
        for (int[] d : dimensions) {
            long w = d[0], h = d[1];
            long d2 = w*w + h*h;
            int area = (int)(w * h);
            if (d2 > bestD2) {
                bestD2 = d2;
                bestArea = area;
            } else if (d2 == bestD2 && area > bestArea) {
                bestArea = area;
            }
        }
        return bestArea;
        
    }
}
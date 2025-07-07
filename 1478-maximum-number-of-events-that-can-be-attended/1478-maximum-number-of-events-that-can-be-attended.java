class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0])); 
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        int i = 0, n = events.length;
        int res = 0;
        
        int day = 1;
        int lastDay = 0;
        for (int[] e : events) {
            lastDay = Math.max(lastDay, e[1]);
        }

        while (day <= lastDay) {
            while (i < n && events[i][0] == day) {
                minHeap.add(events[i][1]);
                i++;
            }
            
            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }
            
            if (!minHeap.isEmpty()) {
                minHeap.poll();
                res++;
            }
            
            day++;
        }
        
        return res;
    }
}

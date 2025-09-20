import java.util.*;

class Router {
    private int memoryLimit;
    private Deque<int[]> packetQueue; // FIFO buffer: [source, destination, timestamp]
    private Set<String> uniqueSet;    // detect duplicates quickly
    private Map<Integer, List<Integer>> destTimestamps; // destination -> timestamps
    private Map<Integer, Integer> processedIndex;       // destination -> index of forwarded

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.packetQueue = new ArrayDeque<>();
        this.uniqueSet = new HashSet<>();
        this.destTimestamps = new HashMap<>();
        this.processedIndex = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String key = source + "#" + destination + "#" + timestamp;
        if (uniqueSet.contains(key)) {
            return false; // duplicate packet
        }

        // If buffer is full, forward the oldest one
        if (packetQueue.size() == memoryLimit) {
            forwardPacket();
        }

        // Add packet
        packetQueue.offer(new int[]{source, destination, timestamp});
        uniqueSet.add(key);
        destTimestamps.computeIfAbsent(destination, k -> new ArrayList<>()).add(timestamp);
        processedIndex.putIfAbsent(destination, 0);

        return true;
    }

    public int[] forwardPacket() {
        if (packetQueue.isEmpty()) {
            return new int[0]; // nothing to forward
        }

        int[] pkt = packetQueue.poll(); // oldest packet
        int src = pkt[0], dest = pkt[1], ts = pkt[2];
        String key = src + "#" + dest + "#" + ts;

        uniqueSet.remove(key);
        // Move forward pointer for this destination
        processedIndex.put(dest, processedIndex.getOrDefault(dest, 0) + 1);

        return pkt;
    }

    public int getCount(int destination, int startTime, int endTime) {
        if (!destTimestamps.containsKey(destination)) {
            return 0;
        }
        List<Integer> tsList = destTimestamps.get(destination);
        int idx = processedIndex.getOrDefault(destination, 0);

        // Binary search for range
        int lo = lowerBound(tsList, startTime, idx);
        int hi = upperBound(tsList, endTime, idx);

        return hi - lo;
    }

    // First index >= target
    private int lowerBound(List<Integer> arr, int target, int start) {
        int l = start, r = arr.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr.get(mid) < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    // First index > target
    private int upperBound(List<Integer> arr, int target, int start) {
        int l = start, r = arr.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr.get(mid) <= target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}

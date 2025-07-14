import java.util.*;

class Solution {

    class Pair {
        int node, cost;
        Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    class Tuple {
        int stops, node, totalCost;
        Tuple(int stops, int node, int totalCost) {
            this.stops = stops;
            this.node = node;
            this.totalCost = totalCost;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Step 1: Create adjacency list
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] flight : flights) {
            int u = flight[0], v = flight[1], price = flight[2];
            adj.get(u).add(new Pair(v, price));
        }

        // Step 2: Distance array
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Step 3: BFS queue - (stops, node, totalCost)
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, src, 0));

        while(!q.isEmpty()) {
            Tuple current = q.poll();
            int stops = current.stops;
            int node = current.node;
            int cost = current.totalCost;

            // Don't explore beyond k stops
            if(stops > k) continue;

            for(Pair neighbor : adj.get(node)) {
                int nextNode = neighbor.node;
                int priceToNext = neighbor.cost;

                if(cost + priceToNext < dist[nextNode]) {
                    dist[nextNode] = cost + priceToNext;
                    q.add(new Tuple(stops + 1, nextNode, dist[nextNode]));
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}

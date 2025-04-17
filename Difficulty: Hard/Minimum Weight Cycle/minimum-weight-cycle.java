//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int V = Integer.parseInt(sc.nextLine());
            int E = Integer.parseInt(sc.nextLine());

            List<int[]> edgeList = new ArrayList<>();

            for (int i = 0; i < E; i++) {
                String[] parts = sc.nextLine().split(" ");
                int u = Integer.parseInt(parts[0]);
                int v = Integer.parseInt(parts[1]);
                int w = Integer.parseInt(parts[2]);
                edgeList.add(new int[] {u, v, w});
                edgeList.add(new int[] {v, u, w});
            }

            int[][] edges = new int[edgeList.size()][3];
            for (int i = 0; i < edgeList.size(); i++) {
                edges[i] = edgeList.get(i);
            }

            Solution obj = new Solution();
            int res = obj.findMinCycle(V, edges);

            System.out.println(res);
        }

        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    public int findMinCycle(int V, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

        int minCycle = Integer.MAX_VALUE;

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            removeEdge(adj, u, v, w);
            int dist = dijkstra(u, v, adj, V);
            if (dist != Integer.MAX_VALUE) {
                minCycle = Math.min(minCycle, dist + w);
            }
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }
        return (minCycle == Integer.MAX_VALUE) ? -1 : minCycle;
    }

    private void removeEdge(List<List<int[]>> adj, int u, int v, int w) {
        adj.get(u).removeIf(e -> e[0] == v && e[1] == w);
        adj.get(v).removeIf(e -> e[0] == u && e[1] == w);
    }
    private int dijkstra(int src, int target, List<List<int[]>> adj, int V) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{src, 0});
        dist[src] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0], d = curr[1];

            if (u == target) return d;

            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0], w = neighbor[1];
                if (dist[v] > d + w) {
                    dist[v] = d + w;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }

        return Integer.MAX_VALUE;
    }
}



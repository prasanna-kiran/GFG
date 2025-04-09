//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.articulationPoints(V, edges);
            Collections.sort(ans);
            for (int val : ans) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution 
{
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) 
    {
         ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) 
        {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) 
        {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];
        boolean[] isArticulationPoint = new boolean[V];
        Arrays.fill(parent, -1);
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        int time = 0;
        for (int i = 0; i < V; i++) 
        {
            if (!visited[i]) 
            {
                dfs(i, visited, disc, low, parent, graph, isArticulationPoint, time);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < V; i++) 
        {
            if (isArticulationPoint[i]) 
            {
                result.add(i);
            }
        }
        if (result.isEmpty()) 
        {
            result.add(-1);
        }
        
        return result;
    }
    static void dfs(int u, boolean[] visited, int[] disc, int[] low, int[] parent, 
                    ArrayList<ArrayList<Integer>> graph, boolean[] isArticulationPoint, int time) {
        visited[u] = true;
        disc[u] = low[u] = ++time;
        int children = 0;
        for (int v : graph.get(u)) 
        {
            if (!visited[v]) 
            {
                parent[v] = u;
                children++;
                dfs(v, visited, disc, low, parent, graph, isArticulationPoint, time);
                low[u] = Math.min(low[u], low[v]);
                if (parent[u] == -1 && children > 1) 
                {
                    isArticulationPoint[u] = true;
                }
                if (parent[u] != -1 && low[v] >= disc[u]) 
                {
                    isArticulationPoint[u] = true;
                }
            } 
            else if (v != parent[u]) 
            { 
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}
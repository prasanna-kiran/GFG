//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
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
            boolean ans = obj.isCycle(V, edges);
            System.out.println(ans ? "true" : "false");
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    public boolean isCycle(int V, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int[]edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] visited=new boolean[V];
        for(int i=0; i<V; i++){
            if(!visited[i]){
                if(dfs(i, -1, visited,adj)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(int node, int parent, boolean[]visited, List<List<Integer>> adj){
        visited[node]=true;
        for(int neighbor:adj.get(node)){
            if(!visited[neighbor]){
                if(dfs(neighbor, node, visited, adj)){
                    return true;
                }
            }
            else if(neighbor!=parent){
                return true;
            }
        }
        return false;
    }
}
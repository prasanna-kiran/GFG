from collections import defaultdict
class Solution:
    def isBridge(self, V, edges, c, d):
        graph = defaultdict(list)
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)

        visited = [False] * V
        tin = [-1] * V
        low = [-1] * V
        self.timer = 0
        self.bridge_found = False

        def dfs(u, parent):
            visited[u] = True
            tin[u] = low[u] = self.timer
            self.timer += 1

            for v in graph[u]:
                if v == parent:
                    continue
                if not visited[v]:
                    dfs(v, u)
                    low[u] = min(low[u], low[v])
                    if low[v] > tin[u]:
                        if (u == c and v == d) or (u == d and v == c):
                            self.bridge_found = True
                else:
                    low[u] = min(low[u], tin[v])

        for i in range(V):
            if not visited[i]:
                dfs(i, -1)

        return self.bridge_found


#{ 
 # Driver Code Starts
import sys

sys.setrecursionlimit(10**7)
if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        V = int(input())
        E = int(input())
        adj = [[] for _ in range(V)]
        edges = []

        for _ in range(E):
            u, v = map(int, input().split())
            adj[u].append(v)
            adj[v].append(u)
            edges.append([u, v])

        c = int(input())
        d = int(input())

        obj = Solution()
        l = obj.isBridge(V, edges, c, d)

        if l:
            print("true")
        else:
            print("false")

        print("~")

# } Driver Code Ends
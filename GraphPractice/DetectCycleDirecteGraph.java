package GraphPractice;

import java.util.ArrayList;
import java.util.List;

// Detect Cycle in Directed Graph
// Given directed graph
//       return whether it contains a directed cycle.
// Two approaches both solution here:
//       DFS+recursion stack classic — O(V+E).
//       Kahns algorithm(topological sort)—if topological order includes all nodes→no cycle;otherwise cycle exists.

// solution 1 : DFS+recursion stack classic — O(V+E).

public class DetectCycleDirecteGraph {
    public static boolean isCycle(int V, List<Integer>[] adj) {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, recStack)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(int u, List<Integer>[] adj, boolean[] visited, boolean[] recStack) {
        visited[u] = true;
        recStack[u] = true;

        for (int v : adj[u]) {
            if (!visited[v]) {
                if (dfs(v, adj, visited, recStack)) {
                    return true;
                }
            } else if (recStack[v]) {
                return true;
            }
        }

        recStack[u] = false;
        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        List<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        // edges: 0->1, 1->2, 2->0 cycle
        adj[0].add(1);
        adj[1].add(2);
        adj[2].add(0);
        System.out.println("Cycle is exist : " + isCycle(V, adj)); // true

        // acyclic example

        List<Integer>[] adj2 = new ArrayList[3];
        for (int i = 0; i < 3; i++) {
            adj2[i] = new ArrayList<>();
        }
        adj2[0].add(1);
        adj2[1].add(2);
        System.out.println("Cycle is exist : " + isCycle(3, adj2)); // false
    }
}

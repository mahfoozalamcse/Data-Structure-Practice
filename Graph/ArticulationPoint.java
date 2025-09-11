package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

// Articulation Points Cut Vertices  
// Idea.
//     A vertex u in an undirected graph is an articulation point if removing u (and its incident edges)increases the number of connected components.

//     DFS-based algorithm  Tarjan-style  run -> DFS and maintain
//     disc[u]=discovery time of u
//     low[u]= earliest discovered vertex reachable from subtree rooted at u by the help back-edges
//     For non-root u,
//            if there exists a child v with low[v]>=disc[u],then u is an articulation point.
//     For root,
//           if it has two or more children,it'san articulation point


public class ArticulationPoint {
    
    private int V;
    private LinkedList<Integer>[] adj;
    private int time;

    public ArticulationPoint(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++){
            adj[i] = new LinkedList<>();
             time = 0;
        }
    }

    public void addEdge(int u, int v) { // undirected
        adj[u].add(v);
        adj[v].add(u);
    }

    private void apDfs(int u, boolean[] visited, int[] disc, int[] low, int parent, boolean[] isAP) {
        visited[u] = true;
        disc[u] = low[u] = ++time;
        int children = 0;

        for (int v : adj[u]) {
            if (!visited[v]) {
                children++;
                apDfs(v, visited, disc, low, u, isAP);
                low[u] = Math.min(low[u], low[v]);

                // If u is not root and low value of one of its children is more than discovery
                // value of u.
                if (parent != -1 && low[v] >= disc[u])
                    isAP[u] = true;
            } else if (v != parent) {
                // Back edge found
                low[u] = Math.min(low[u], disc[v]);
            }
        }
        

        // If u is root and has two or more children.
        if (parent == -1 && children > 1)
            isAP[u] = true;
    }

    public Set<Integer> findArticulationPoints() {
        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        boolean[] isAP = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i])
                apDfs(i, visited, disc, low, -1, isAP);
        }

        Set<Integer> aps = new HashSet<>();
        for (int i = 0; i < V; i++)
            if (isAP[i])
                aps.add(i);
        return aps;
    }

    // Example
    public static void main(String[] args) {
        ArticulationPoint g = new ArticulationPoint(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        System.out.println();
        Set<Integer> aps = g.findArticulationPoints();
        System.out.println("Articulation points: " + aps);
        // Expected: 0 and 3 (i.e., [0, 3])
    }
}



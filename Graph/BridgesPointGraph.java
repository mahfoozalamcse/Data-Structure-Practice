package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BridgesPointGraph {
    private int V;
    private LinkedList<Integer>[] adj;
    private int time;

    public BridgesPointGraph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList<>();
        time = 0;
    }

    public void addEdge(int u, int v) { // undirected
        adj[u].add(v);
        adj[v].add(u);
    }

    private void bridgeDfs(int u, boolean[] visited, int[] disc, int[] low, int parent, List<int[]> bridges) {
        visited[u] = true;
        disc[u] = low[u] = ++time;

        for (int v : adj[u]) {
            if (!visited[v]) {
                bridgeDfs(v, visited, disc, low, u, bridges);
                low[u] = Math.min(low[u], low[v]);

                if (low[v] > disc[u]) {
                    bridges.add(new int[] { u, v }); // u - v is a bridge
                }
            } else if (v != parent) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    public List<int[]> findBridges() {
        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        List<int[]> bridges = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i])
                bridgeDfs(i, visited, disc, low, -1, bridges);
        }
        return bridges;
    }

    // Example
    public static void main(String[] args) {
        BridgesPointGraph g = new BridgesPointGraph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        List<int[]> bridges = g.findBridges();
        System.out.println();
        System.out.println("Bridges point :");
        for (int[] b : bridges)
            System.out.println(b[0] + " - " + b[1]);
        // Expected bridges: 0-3 and 3-4
    }
}

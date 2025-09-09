package Graph;

import java.util.LinkedList;

public class CycleDirectedGraph {
    private int V;
    private LinkedList<Integer>[] adj;

    CycleDirectedGraph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int u, int v) {
        adj[u].add(v);
    }

    // helper method DFS
    boolean dfs(int node, boolean[] visited, boolean[] recStack){
      if (recStack[node]) {
         return true;
      }
      if (visited[node]) {
        return false;
      }

      visited[node] = true;
      recStack[node] = true;

      for(int neighour : adj[node]){
        if (dfs(neighour, visited, recStack)) {
            return true;
        }
      }

      recStack[node] = false;
      return false;
    }

    boolean isCycle(){
        boolean visited[] = new boolean[V];
        boolean recStack[] = new boolean[V];

        for(int i=0; i<V; i++){
            if (dfs(i, visited, recStack)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        CycleDirectedGraph g = new CycleDirectedGraph(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0); // cycle point
        g.addEdge(2, 3);

        System.out.println();
        System.out.println("Cycle is present : " + g.isCycle());
     
    }
}

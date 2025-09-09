package Graph;

import java.util.LinkedList;

public class CycleUndirected {
    private int V;
    private LinkedList<Integer>[] adjList;

    CycleUndirected(int v){
        V = v;
        adjList = new LinkedList[v];

        for(int i=0; i<v; i++){
            adjList[i] = new LinkedList<>();
        }
    }

    // add edge
    void addEdge(int u, int v){
        adjList[u].add(v);
        adjList[v].add(u);

    }

    // Helper method for cycle detection DFS
    boolean dfs(int node, int parent, boolean[] visited){
        visited[node] = true;
        
        for(int neighour : adjList[node]){
            if (!visited[neighour]) {
              if (dfs(neighour, node, visited)) {
                return true;
              }
            }else if (neighour != parent) {
                return true; // found back edge
            }
        }

        return false;
    }

    // check cycle
    boolean isCycle(){
        boolean visited[] = new boolean[V];
        for(int i=0; i<V; i++){
           if (!visited[i] && dfs(i, -1, visited)) {
             return true;
           }
        }

        return false;
    }

    public static void main(String[] args) {
         CycleUndirected g = new CycleUndirected(4);
          g.addEdge(0, 1);
          g.addEdge(1, 2);
          g.addEdge(2, 3);
          g.addEdge(0, 3);

        System.out.println("Cycle is present : " + g.isCycle());
      
    }
}

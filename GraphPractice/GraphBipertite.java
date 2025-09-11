package GraphPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Given undirected graph adj list, determine if its bipartite if nodes can be colored with 2 colors so no edge has same-colored ends.

// BFS use here you also do DFS
//   time O(V+E).Space O(V).

public class GraphBipertite {
    public static boolean isBipertite(int V, List<Integer>[] adj){
        int color[] = new int[V];
        Arrays.fill(color, -1);

        for(int i=0; i<V; i++){
            if (color[i] == -1) {
                if (!bfsChecked(i, adj, color)) {
                    return false;
                }
            }
        }

        return true;
    }

    // check next vertex
    private static boolean bfsChecked(int src, List<Integer>[] adj, int color[]){
      Queue<Integer> q = new LinkedList<>();
      color[src] = 0;
      q.add(src);

      while (!q.isEmpty()) {
         int u = q.poll();
         for(int v : adj[u]){
             if (color[v] == -1) {
                color[v] = 1-color[u];
                q.add(v);

             }else if (color[v] == color[u]) {
                return false;
             }
         }
      }

      return true;

    }
    public static void main(String[] args) {
       int V = 4;
       List<Integer>[] adj = new ArrayList[V];
       
       for(int i=0; i<V; i++){
        adj[i] = new ArrayList<>();
       }

       // edges: 0-1, 1-2, 2-3, 3-0 => even cycle -> bipartite
       adj[0].add(1);
       adj[1].add(0);
       adj[1].add(2);
       adj[2].add(1);
       adj[2].add(3);
       adj[3].add(2);
       adj[3].add(0);
       adj[0].add(3);


       
       System.out.println("  Is Bipertite : "+isBipertite(V, adj)); // true

       // add edge 0-2 => makes odd cycle
       adj[0].add(2);
       adj[2].add(0);
       System.out.println("Is Bipertite : "+isBipertite(V, adj)); // false
    }
}

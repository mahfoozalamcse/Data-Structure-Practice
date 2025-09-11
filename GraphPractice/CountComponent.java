package GraphPractice;

import java.util.ArrayList;
import java.util.List;

public class CountComponent {
    public static int countComponents(int V, List<Integer>[] adj){
        boolean visited[] = new boolean[V];
        int count = 0;
        
        for(int i=0; i<V; i++){
            if (!visited[i]) {
                count++;
                dfs(i, adj, visited);
            }
        }

        return count;
    }
    public static void dfs(int u, List<Integer>[] adj, boolean[] visited){
        visited[u] = true;
        for(int v : adj[u]){
           if (!visited[v]) {
              dfs(v, adj, visited);
           }
        }
    }
    public static void main(String[] args) {
      int V = 6;
      List<Integer>[] adj = new ArrayList[V];
      
      for(int i=0; i<V; i++){
        adj[i] = new ArrayList<>();
      }
      // add component
      // conent componenet 0-1-2
      adj[0].add(1);
      adj[1].add(0);
      adj[1].add(2);
      adj[2].add(1);

      // conect component 3-4
      adj[3].add(4);
      adj[4].add(3);

      // componenet 5 is isolated

      // print no. of connectected componenet
      System.out.println("Total connected component "+ countComponents(V, adj));

    }
}

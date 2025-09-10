package Graph;

import java.util.LinkedList;
import java.util.Stack;

// Topological Sort Use Stack + BFS approch 
//   Why ->
//        Ordering of tasks where some tasks must be done before others.
//        Example:
//               Course Schedule,Build Systems,Job Scheduling.
//               Works only on DAGs -> Directed Acyclic Graphs.

//  approach 1 ->
//        DFS+Stack
//        Push nodes into stack after visiting all neighbors.

public class TopologicalSort {
    int V;
    LinkedList<Integer>[] adj;

    TopologicalSort(int v){
        V = v;
        adj = new LinkedList[v];

        for(int i=0; i<v; i++){
            adj[i] = new LinkedList<>();
        }
    }

    // add edge
    void addEdge(int u, int v){
      adj[u].add(v);
    }

    // dfs
    void dfs(int node, boolean[] visited, Stack<Integer> st){
       visited[node] = true;
       for(int neighbors : adj[node]){
          if (!visited[neighbors]) {
             dfs(neighbors, visited, st);
          }
       }

       st.push(node);
    }

    // main method topo sort
    void topoSortDFS(){
        Stack<Integer> st = new Stack<>();
        boolean visited[] = new boolean[V];

        for(int i=0; i<V; i++){
            if (!visited[i]) {
                dfs(i, visited, st);
            }
        }

        System.out.print("Topological sort order DFS : ");
        while (!st.isEmpty()) {
            System.out.print(st.pop()+" ");
        }
    }

   public static void main(String[] args) {
       TopologicalSort g = new TopologicalSort(6);
       g.addEdge(5, 2);
       g.addEdge(5, 0);
       g.addEdge(4, 0);
       g.addEdge(4, 1);
       g.addEdge(2, 3);
       g.addEdge(3, 1);

       g.topoSortDFS();
   } 
}

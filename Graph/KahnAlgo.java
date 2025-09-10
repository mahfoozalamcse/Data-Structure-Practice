package Graph;

import java.util.LinkedList;
import java.util.Queue;

//    Kahns Algorithm for topological order-> BFS+In-degree
//       Use queue of nodes with in-degree=0.

public class KahnAlgo {
    int V;
    LinkedList<Integer>[] adjList;

    KahnAlgo(int v){
        V = v;
        adjList = new LinkedList[V];

        for(int i=0; i<v; i++){
            adjList[i] = new LinkedList<>();
        }
    }

    // add edge
    void addEdge(int u, int v){
        adjList[u].add(v);
    }

    // topological sort method
    int count = 0;
    void topologicalSort(){
        int[] inDegree = new int[V];

        for(int i=0; i<V; i++){
            for (int neighbors : adjList[i]) {
                inDegree[neighbors]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<V; i++){
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        System.out.println("Topological sort Kahn : ");
        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node +" ");
            count++;

            for(int neighbors : adjList[node]){
                if (--inDegree[neighbors] == 0) {
                    q.add(neighbors);
                }
            }
        }
        if (count != V) {
            System.out.println(" Cycle detectected topological sort not possible");
        }
    }
  public static void main(String[] args) {
      KahnAlgo g = new KahnAlgo(6);
      g.addEdge(5, 2);
      g.addEdge(5, 0);
      g.addEdge(4, 0);
      g.addEdge(4, 1);
      g.addEdge(2, 3);
      g.addEdge(3, 1);

      g.topologicalSort();
  }  
}

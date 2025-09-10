package Graph;

import java.util.Arrays;

// Shortest Path Algorithms
/*
Bellman-Ford Algorithm
       Works on graphs with negative weights.
       Can detect negative weight cycles.
        Time complexity: O(V * E).
  Idea:
     Relax all edges V-1 times.
     If after that, we can still relax an edge → negative cycle exists.
 */


public class BellmanFordAlgo {
    static class Edge{
        int src, des, weight;
        Edge(int s, int d, int w){
            src = s;
            des = d;
            weight = w;
        }
    }
    
    int V, E;
    Edge[] edges;

    BellmanFordAlgo(int v, int e){
        V = v;
        E = e;

        edges = new Edge[e];
    }

    // Bellman ford algo main method
    void bellmanFord(int src){
        int dist[] = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // relex edge in v-1 times
        for(int i=1; i<V; i++){
            for(int j=0; j<E; j++){
               int u = edges[j].src;
               int v = edges[j].des;
               int w = edges[j].weight;

               if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                   dist[v] = dist[u] + w;
               }
            }
        }

        // check negative cycle
        for(int j=0; j<E; j++){
            int u = edges[j].src;
            int v = edges[j].des;
            int w = edges[j].weight;

            if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                System.out.println(" Graph contain negative weight cycle : "); // voilet output
                return;
            }
        }

        // easily print in end
        System.out.println(" Shortest distance form " + src + " Destination : "+ Arrays.toString(dist));
        
    }
    public static void main(String[] args) {
        int V = 5, E = 8;
        BellmanFordAlgo g = new BellmanFordAlgo(V, E);

        g.edges[0] = new Edge(0, 1, -1);
        g.edges[1] = new Edge(0, 2, 4);
        g.edges[2] = new Edge(1, 2, 3);
        g.edges[3] = new Edge(1, 3, 2);
        g.edges[4] = new Edge(1, 4, 2);
        g.edges[5] = new Edge(3, 2, 5);
        g.edges[6] = new Edge(3, 1, 1);
        g.edges[7] = new Edge(4, 3, -3);

        g.bellmanFord(0); 
    }
}

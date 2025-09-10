package Graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

// find shortest path Algorithm
// Dijkstra’s Algorithm -> Greedy, works on non-negative weights
// use -> Priority Queue min heap 

public class DijkstraAlgo {
    static class Edge{
        int v, w;
        Edge(int v, int w){
            this.v = v;
            this.w = w;
        }
    }

    int V;
    private LinkedList<Edge> [] adjList;
    
    DijkstraAlgo(int v){
        V = v;
        adjList = new LinkedList[v];

        for(int i=0; i<v; i++){
            adjList[i] = new LinkedList<>();
        }
    }

    // add edge
    void addEdge(int u, int v, int w){
        adjList[u].add(new Edge(v, w));
        adjList[v].add(new Edge(v, w));  // for directed you remove easily this line
    }

    // shortest path method
    // use Dijkstra min heap approch 
    void shortestPath(int src){
        int dist[] = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        // initialize src 0
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{src , 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];

            if (d > dist[u]) {
                continue;
            }

            for(Edge e : adjList[u]){
                if (dist[u] + e.w < dist[e.v]) {
                    dist[e.v] = dist[u] + e.w;
                    
                    // add to compare next 
                    pq.add(new int[]{e.v, dist[e.v]});
                }
            }
        }

        // print sortest distance
        System.out.println(" Shortest distance from src " + src + " to des is : "+ Arrays.toString(dist));
    }

    public static void main(String[] args) {
        
        DijkstraAlgo g = new DijkstraAlgo(5);

        g.addEdge(0, 1, 10);
        g.addEdge(0, 4, 5);
        g.addEdge(1, 2, 1);
        g.addEdge(4, 1, 3);
        g.addEdge(4, 2, 9);
        g.addEdge(4, 3, 2);
        g.addEdge(2, 3, 4);
        g.addEdge(3, 0, 7);

        g.shortestPath(0);  
    }
}

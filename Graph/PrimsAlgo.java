package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// Prims Algorithm
//      Another Greedy MST approach:
//      Start from any node.
//      Use PriorityQueue to always pick the minimum weight edge.
//      Keep adding edges until all vertices are covered.

public class PrimsAlgo {
    static class Edge{
        int des, weight;
         Edge(int d, int w){
            des = d;
            weight = w;
         }
    }

    int V;
    List<Edge>[] adjList;

    PrimsAlgo(int v){
        V = v;
        adjList = new ArrayList[v];
        for(int i=0; i<v; i++){
            adjList[i] = new ArrayList<>();
        }
    }

    // add edge
    void addEdge(int u, int v, int w){
      adjList[u].add(new Edge(v, w));
      adjList[v].add(new Edge(u, w)); // undirected 
    }

    // prim algo main method
    void primMST(){
        boolean inMST[] = new boolean[V];
        int key[] = new int[V];
        int parent[] = new int[V];

        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        parent[0] = -1;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{0, 0});

        while (!pq.isEmpty()) {
           int u = pq.poll()[0];
           inMST[u] = true;
           
           for(Edge e : adjList[u]){
             if (!inMST[e.des] && e.weight < key[e.des]) {
                key[e.des] = e.weight;
                parent[e.des] = u;
                pq.add(new int[]{e.des , key[e.des]});
             }
           }
        }

        int minCost = 0;
        System.out.println(" Edge in MST ");
        for(int i=1; i<V; i++){
            System.out.println(parent[i] + " - " + i+ " : " + key[i]);
            minCost += key[i];
        }

        System.out.println("Minimum cost : "+ minCost);
    }

    public static void main(String[] args) {
        PrimsAlgo g = new PrimsAlgo(5);

        g.addEdge(0, 1, 2);
        g.addEdge(0, 3, 6);
        g.addEdge(1, 2, 3);
        g.addEdge(1, 3, 8);
        g.addEdge(1, 4, 5);
        g.addEdge(2, 4, 7);
        g.addEdge(3, 4, 9);

        g.primMST();  
    }
}

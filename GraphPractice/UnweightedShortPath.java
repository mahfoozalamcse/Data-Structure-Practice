package GraphPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Unweighted Shortest Path (BFS)

// Given unweighted graph with V nodes adj listand source s compute shortest distance in edges from s to every node, unreachable nodes get -1 or INF

// Time O(V + E); Space O(V).

public class UnweightedShortPath {
  public static int[] shortestPath(int V, List<Integer>[] adj, int src) {
    int[] distance = new int[V];
    Arrays.fill(distance, -1);
    Queue<Integer> q = new LinkedList<>();
    distance[src] = 0;
    q.add(src);

    while (!q.isEmpty()) {
      int u = q.poll();
      for (int v : adj[u]) {
        if (distance[v] == -1) {
          distance[v] = distance[u] + 1;
          q.add(v);
        }
      }
    }
    return distance;

  }

  public static void main(String[] args) {
    int V = 6;
    List<Integer>[] adj = new ArrayList[V];

    for (int i = 0; i < V; i++) {
      adj[i] = new ArrayList<>();
    }

    adj[0].add(1);
    adj[1].add(0);
    adj[0].add(2);
    adj[2].add(0);
    adj[1].add(3);
    adj[3].add(1);
    adj[2].add(4);
    adj[4].add(2);
    adj[4].add(5);
    adj[5].add(4);

    int[] d = shortestPath(V, adj, 0);
    System.out.println(" Shortest path : " + Arrays.toString(d)); // e.g. [0,1,1,2,2,3]
  }
}

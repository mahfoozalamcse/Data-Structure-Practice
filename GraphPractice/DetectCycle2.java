package GraphPractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Kahns Algorithm (Topological Order)
public class DetectCycle2 {
    public static boolean isCycle(int V, List<Integer>[] adj) {
        int[] inDegree = new int[V];
        for (int u = 0; u < V; u++) {
            for (int v : adj[u]) {
                inDegree[v]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        int count = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            count++;
            for (int v : adj[u]) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    q.add(v);
                }
            }
        }
        return count != V; // true if cycle exist
    }

    public static void main(String[] args) {
        int V = 3;
        List<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        adj[0].add(1);
        adj[1].add(2);
        adj[2].add(0); // cycle

        System.out.println();
        System.out.println("Is cycle exist : " + isCycle(V, adj)); // true

        List<Integer>[] adj2 = new ArrayList[3];
        for (int i = 0; i < 3; i++) {
            adj2[i] = new ArrayList<>();
        }
        adj2[0].add(1);
        adj2[1].add(2);
        System.out.println("Is cycle exist : " + isCycle(3, adj2)); // false
    }
}

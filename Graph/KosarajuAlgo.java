package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

// Kosarajus Algorithm—Strongly Connected Components(SCCs)
public class KosarajuAlgo {
    private int V;
    private LinkedList<Integer>[] adj;

    public KosarajuAlgo(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList<>();
    }

    public void addEdge(int u, int v) { // directed edge u -> v
        adj[u].add(v);
    }

    // helper fill order
    void fillOrder(int v, boolean visited[], Stack<Integer> st) {
        visited[v] = true;
        for (int neighbors : adj[v]) {
            if (!visited[neighbors]) {
                fillOrder(neighbors, visited, st);
            }
        }
        st.push(v); // finish with v
    }

    // reverse get transpose
    KosarajuAlgo getTranspose() {
        KosarajuAlgo gt = new KosarajuAlgo(V);
        for (int v = 0; v < V; v++) {
            for (int neighbors : adj[v]) {
                gt.addEdge(neighbors, v); // reverse edge
            }
        }
        return gt;
    }

    void dfsUtil(int v, boolean[] visited, List<Integer> comp) {
        visited[v] = true;
        comp.add(v);
        for (int neighbours : adj[v]) {
            if (!visited[neighbours]) {
                dfsUtil(neighbours, visited, comp);
            }
        }
    }

    // main method
    public List<List<Integer>> getSCCs() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        // 1. Fill vertices in stack according to their finishing times
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                fillOrder(i, visited, stack);
            }
        }

        // 2. Create transpose graph
        KosarajuAlgo transposed = getTranspose();

        // 3. Process vertices in order defined by stack
        Arrays.fill(visited, false);
        List<List<Integer>> strongCCList = new ArrayList<>();
        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (!visited[v]) {
                List<Integer> component = new ArrayList<>();
                transposed.dfsUtil(v, visited, component);
                strongCCList.add(component);
            }
        }
        return strongCCList;
    }

    public static void main(String[] args) {
        KosarajuAlgo g = new KosarajuAlgo(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        System.out.println();
        List<List<Integer>> sccs = g.getSCCs();
        System.out.println("Strongly Connected Components: ");
        for (List<Integer> scc : sccs)
            System.out.println(scc);
    }
}

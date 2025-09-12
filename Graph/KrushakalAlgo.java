package Graph;
// Minimum Spanning Trees(MST)

import java.util.Arrays;

//     MST=Subgraph that connects all vertices with minimum total edge weight and no cycles.

// Algorithm ->
// Kruskal’s Algorithm
//    Greedy approach:
//            Sort edges by weight.
//            Pick the smallest edge if it does not form a cycle.
//            Use Disjoint Set Union -> DSU/Union-Find to detect cycles.

public class KrushakalAlgo {
    static class Edge implements Comparable<Edge> {
        int src, des, weight;

        Edge(int s, int d, int w) {
            src = s;
            des = d;
            weight = w;
        }

        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    int V, E;
    Edge[] edges;

    KrushakalAlgo(int v, int e) {
        V = v;
        E = e;
        edges = new Edge[e];
    }

    int find(int parent[], int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent, parent[i]); // path reduce

    }

    // helper kruskal's union method
    void union(int parent[], int rank[], int x, int y) {
        int xRoot = find(parent, x);
        int yRoot = find(parent, y);

        if (rank[xRoot] < rank[yRoot]) {
            parent[xRoot] = yRoot;
        } else if (rank[xRoot] > rank[yRoot]) {
            parent[yRoot] = xRoot;
        } else {
            parent[yRoot] = xRoot;
            rank[xRoot]++;
        }
    }

    // kruskal main method
    void kruskalMST() {
        Arrays.sort(edges);
        Edge[] ans = new Edge[V - 1];
        int e = 0, i = 0;

        int parent[] = new int[V];
        int rank[] = new int[V];

        for (int v = 0; v < V; v++) {
            parent[v] = v;
            rank[v] = 0;
        }

        while (e < V - 1 && i < E) {
            Edge next = edges[i++];

            int x = find(parent, next.src);
            int y = find(parent, next.des);

            if (x != y) {
                ans[e++] = next;
                union(parent, rank, x, y);
            }
        }

        System.out.println(" Edge in kruskal MST : ");
        int minCost = 0;
        for (i = 0; i < e; i++) {
            System.out.println(ans[i].src + " - " + ans[i].des + " : " + ans[i].weight);
            minCost += ans[i].weight;
        }

        System.out.println(" Minimum cost : " + minCost);
    }

    public static void main(String[] args) {
        int V = 4, E = 5;
        KrushakalAlgo g = new KrushakalAlgo(V, E);

        g.edges[0] = new Edge(0, 1, 10);
        g.edges[1] = new Edge(0, 2, 6);
        g.edges[2] = new Edge(0, 3, 5);
        g.edges[3] = new Edge(1, 3, 15);
        g.edges[4] = new Edge(2, 3, 4);

        g.kruskalMST();
    }

}

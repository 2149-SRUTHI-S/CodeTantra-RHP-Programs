// Topological Sorting

import java.util.*;

class Main { // Graph

    private int V;
    private ArrayList < Integer > AL[];
    @SuppressWarnings("unchecked")
    
    Main(int v) {
        V = v;
        AL = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            AL[i] = new ArrayList < > ();
        }
    }

    void insertEdge(int s, int d) {
        AL[s].add(d); // Directed graph
    }

    void topoSort() {
        int inDeg[] = new int[V];
        // Compute the indegree vertex;
        for (int i = 0; i < V; i++) {
            for (int j: AL[i]) {
                inDeg[j]++;

            }
        }

        Queue < Integer > queue = new LinkedList < > ();
        for (int i = 0; i < V; i++) {
            if (inDeg[i] == 0)
                queue.add(i);
        }
        
        int counter = 0;
        ArrayList < Integer > tOrder = new ArrayList < > ();
        while (!queue.isEmpty()) { // u-->v
            int u = queue.poll();
            tOrder.add(u);
            counter++;
            for (int i: AL[u]) {
                inDeg[i] = inDeg[i] - 1;
                if (inDeg[i] == 0) {
                    queue.add(i);
                }
            }
        }
        
        if (counter != V) {
            System.out.print(" Cycle detected, topo not possible");
            return;
        }
        for (int i: tOrder) {
            System.out.print(i + "-->");
        }
    }

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        
        int v = sc.nextInt();
        Main graph = new Main(v);
        int e = sc.nextInt();
        
        for (int i = 0; i < e; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();
            graph.insertEdge(s, d);
        }
        
        sc.close();
        graph.topoSort();
    }
}

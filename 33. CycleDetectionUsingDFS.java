// Cycle detection in directed graphs using DFS--> Recursion Stack(Back edges)

import java.util.*;

class Main { // Graph

    private int V;
    private List < List < Integer >> AL;
    
    Main(int v) {
        V = v;
        AL = new ArrayList(V);
        for (int i = 0; i < V; i++) {
            AL.add(new LinkedList < > ());
        }
    }

    void insertEdge(int s, int d) { // s---> d
        AL.get(s).add(d); // Directed graph
    }

    boolean cycleInDG() {
        boolean VA[] = new boolean[V];
        boolean recStack[] = new boolean[V];
        
        for (int i = 0; i < V; i++) {
            if (dfsHelper(i, VA, recStack)) {
                return true;
            }
        }
        return false;
    }
    
    boolean dfsHelper(int i, boolean VA[], boolean recStack[]) {
        
        if (recStack[i] == true) { // finding back edge
            return true;
        }
        
        if (VA[i] == true) {
            return false;
        }
        
        VA[i] = true;
        recStack[i] = true;
        List < Integer > al = AL.get(i);
        for (Integer c: al) {
            if (dfsHelper(c, VA, recStack) == true) {
                return true; // Back edge found
            }
        }
        recStack[i] = false;
        return false;
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

        if (graph.cycleInDG()) {
            System.out.print("Cycle detected");
        } else {
            System.out.print("Cycle not detected");
        }
        
        sc.close();
    }
}

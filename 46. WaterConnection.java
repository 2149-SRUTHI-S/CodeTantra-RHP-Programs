/*
Water Connection Problem:

Input1:  4 2
        1 2 60
        3 4 50
Output1: 2
        1 2 60
        3 4 50
        
Explanation:
Connected components are: 1->2 and 3->4
Therefore, our answer is 2 followed by 1 2 60 and 3 4 50.

Input2: 9 6
       7 4 98
       5 9 72
       4 6 10
       2 8 22
       9 7 17
       3 1 66
Output2: 3
        2 8 22
        3 1 66
        5 6 10
        
Explanation:
Connected components are 3->1, 5->9->7->4->6 and 2->8. 
Therefore, our answer is 3 followed by 2 8 22, 3 1 66, 5 6 10
*/

class Solution {
    int V, E;
    int outdeg[], indeg[], wt[], ans;
    int dfs(int x) {
        if (outdeg[x] == 0)
            return x;
        if (wt[x] < ans)
            ans = wt[x];
        return dfs(outdeg[x]);
    }
    
    ArrayList < ArrayList < Integer >> solve(int n, int p, ArrayList < Integer > a, ArrayList < Integer > b, ArrayList < Integer > d) {
        this.V = n;
        this.E = p;
        outdeg = new int[V + 1]; // 0x--1----9
        indeg = new int[V + 1];
        wt = new int[V + 1];
        ArrayList < ArrayList < Integer >> result = new ArrayList < > ();
        
        for (int i = 0; i < p; i++) { //p
            int sr = a.get(i);
            int ds = b.get(i);
            int w = d.get(i);
            indeg[ds] = sr;
            outdeg[sr] = ds;
            wt[sr] = w;

        }
        
        for (int j = 1; j <= n; j++) { //n
            // if a pipe/edge is having no ending vertex but having start vertex then run DFS
            if (indeg[j] == 0 && outdeg[j] != 0) {
                ans = Integer.MAX_VALUE;
                int dv = dfs(j);
                ArrayList < Integer > lst = new ArrayList < > ();
                lst.add(j);
                lst.add(dv);
                lst.add(ans);
                result.add(lst);
            }
        }
        return result;
    }
}

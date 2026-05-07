import java.io.*;
import java.util.*;

public class A {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        UnionFind disjointSet = new UnionFind(N);
        
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            
            int currentS = disjointSet.unionNodes(n1, n2);
            pw.println(currentS);
        }
        
        pw.flush();
        pw.close();
    }
}

class UnionFind {
    int[] parent;
    int[] componentS;
    
    public UnionFind(int totalNodes) {
        parent = new int[totalNodes + 1];
        componentS = new int[totalNodes + 1];
        
        for (int i = 1; i <= totalNodes; i++) {
            parent[i] = i;
            componentS[i] = 1;
        }
    }
    
    public int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }
    
    public int unionNodes(int node1, int node2) {
        int r1 = find(node1);
        int r2 = find(node2);
        
        if (r1 == r2) {
            return componentS[r1];
        }
        
        if (componentS[r1] < componentS[r2]) {
            parent[r1] = r2;
            componentS[r2] += componentS[r1];
            return componentS[r2];
        } 
        else {
            parent[r2] = r1;
            componentS[r1] += componentS[r2];
            return componentS[r1];
        }
    }
}
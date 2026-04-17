import java.io.*;
import java.util.*;

public class taskB {
    static int [] visited;
    static ArrayList<Integer> [] adjList;
    static PrintWriter pw;
     public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        if (M > 0) {
            int[] u = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                u[i] = Integer.parseInt(st.nextToken());
            }

            int[] v = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) { 
                v[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < M; i++) {
                adjList[u[i]].add(v[i]);
                adjList[v[i]].add(u[i]);
            }
        }

        visited = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            visited[i] = 0;
        }

        dfs(1);
        
        pw.println();
        pw.flush();
        pw.close();
    }
    static void dfs(int u) {
        visited[u] = 1;
        pw.print(u);
        pw.print(" ");     
        for (int i = 0; i < adjList[u].size(); i++) {
            int v = adjList[u].get(i);
            if (visited[v] == 0) {
                dfs(v);
            }
        }
    }
}

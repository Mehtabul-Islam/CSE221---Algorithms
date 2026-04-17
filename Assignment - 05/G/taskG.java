import java.io.*;
import java.util.*;

public class taskG{
    static boolean check = false;
    static int [] color;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out); 

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
        }
        color = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (color[i] == 0 && !check) {
                dfs(i);
            }
        }

        if (check) {
            pw.println("YES");
        }
        else {
            pw.println("NO");
        }

        pw.flush();
        pw.close();
    }

    static void dfs(int u) {
        color[u] = 1; 
        for (int i = 0; i < adj[u].size(); i++) {
            int v = adj[u].get(i);
            if (color[v] == 1) {
                check = true;
                return;
            }
            if (color[v] == 0) {
                dfs(v);
            }
        }
        color[u] = 2; 
    }
}
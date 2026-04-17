import java.io.*;
import java.util.*;

public class taskE {
    static ArrayList<Integer>[] adj;
    static int[] comp;
    static boolean[] visited;
    static int compId = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        visited = new boolean[N + 1];
        comp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                compId++;
                dfs(i);
            }
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (comp[x] == comp[y]) {
                pw.println("YES");
            } else {
                pw.println("NO");
            }
        }

        pw.flush();
        pw.close();
    }

    static void dfs(int u) {
        visited[u] = true;
        comp[u] = compId;

        for (int v : adj[u]) {
            if (!visited[v]) {
                dfs(v);
            }
        }
    }
}
import java.io.*;
import java.util.*;

public class taskF{
    static ArrayList<Integer>[] adj;
    static int[] size;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        size = new int[N + 1];
        dfs(R, -1);

        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            pw.println(size[x]);
        }
        pw.flush();
        pw.close();
        
    }
    static int dfs(int u, int parent) {
        size[u] = 1;
        for (int i = 0; i < adj[u].size(); i++) {
            int v = adj[u].get(i);
            if (v != parent) {
                size[u] += dfs(v, u);
            }
        }
        return size[u];
    }
}

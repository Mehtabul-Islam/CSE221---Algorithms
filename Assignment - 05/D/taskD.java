import java.io.*;
import java.util.*;

public class taskD {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
        }

        int[] dist1 = new int[N + 1];
        int[] parent1 = new int[N + 1];

        bfs(S, adj, dist1, parent1);

        int[] dist2 = new int[N + 1];
        int[] parent2 = new int[N + 1];

        bfs(K, adj, dist2, parent2);

        if (dist1[K] == -1 || dist2[D] == -1) {
            pw.println(-1);
        } 
        
        else {
            pw.println(dist1[K] + dist2[D]);
            ArrayList<Integer> path1 = new ArrayList<>();
            int node = K;
            while (node != -1) {
                path1.add(node);
                node = parent1[node];
            }
            for (int i = 0; i < path1.size()/2; i++) {
                int temp = path1.get(i);
                path1.set(i, path1.get(path1.size() - 1 - i));
                path1.set(path1.size() - 1 - i, temp);
            }

            ArrayList<Integer> path2 = new ArrayList<>();
            node = D;
            while (node != -1) {
                path2.add(node);
                node = parent2[node];
            }
            for (int i = 0; i < path2.size()/2; i++) {
                int temp = path2.get(i);
                path2.set(i, path2.get(path2.size() - 1 - i));
                path2.set(path2.size() - 1 - i, temp);
            }

            for (int i = 0; i < path1.size(); i++) {
                if (i > 0) pw.print(" ");
                pw.print(path1.get(i));
            }
            for (int i = 1; i < path2.size(); i++) {
                pw.print(" ");
                pw.print(path2.get(i));
            }
            pw.println();
        }

        pw.flush();
        pw.close();
    }

    static void bfs(int src, ArrayList<Integer>[] adj, int[] dist, int[] parent) {
        int n = adj.length - 1;
        for (int i = 0; i <= n; i++) {
            dist[i] = -1;
            parent[i] = -1;
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        dist[src] = 0;
        q.add(src);

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int i = 0; i < adj[u].size(); i++) {
                int v = adj[u].get(i);
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    parent[v] = u;
                    q.add(v);
                }
            }
        }
    }
}

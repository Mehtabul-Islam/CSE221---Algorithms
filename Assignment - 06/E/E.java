import java.io.*;
import java.util.*;

public class E {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int [] dist = new int[N + 1];
        Arrays.fill(dist, -1);

        int [] q = new int[N + 5];
        int head = 0, tail = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < S; i++) {
            int s = Integer.parseInt(st.nextToken());
            if (dist[s] == -1) {
                dist[s] = 0;
                q[tail++] = s;
            }
        }

        while (head < tail) {
            int u = q[head++];

            for (int v : adj.get(u)) {
                if (dist[v] != -1) continue;

                dist[v] = dist[u] + 1;
                q[tail++] = v;
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            int d = Integer.parseInt(st.nextToken());
            pw.print(dist[d] + " ");
        }

        pw.flush();
    }
}

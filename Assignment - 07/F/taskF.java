import java.io.*;
import java.util.*;
public class taskF{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        ArrayList<int[]>[] graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }
        int[][] dist = new int[N + 1][2]; 
        int x = Integer.MAX_VALUE / 4;
        for (int i = 0; i <= N; i++) {
            dist[i][0] = x;
            dist[i][1] = x;
        }
        dist[S][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, S});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0];
            int u = cur[1];
            if (d > dist[u][1]){
                continue;
            }
            for (int[] edge : graph[u]) {
                int v = edge[0];
                int w = edge[1];
                int nd = d + w;
                if (nd < dist[v][0]) {
                    dist[v][1] = dist[v][0];
                    dist[v][0] = nd;
                    pq.offer(new int[]{nd, v});
                } 
                else if (nd > dist[v][0] && nd < dist[v][1]) {
                    dist[v][1] = nd;
                    pq.offer(new int[]{nd, v});
                }
            }
        }
        int ans = dist[D][1];
        if (ans >= x) {
            pw.println(-1);
        } 
        else {
            pw.println(ans);
        }
        pw.flush();
        pw.close();
    }
}
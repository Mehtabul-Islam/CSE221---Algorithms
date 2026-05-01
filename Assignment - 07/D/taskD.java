    import java.io.*;
    import java.util.*;
    public class taskD{
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(System.out);
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int[] weight = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                weight[i] = Integer.parseInt(st.nextToken());
            }
            ArrayList<Integer>[] graph = new ArrayList[N + 1];
            for (int i = 0; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
            }
            int[] dist = new int[N + 1];
            boolean[] visited = new boolean[N + 1];
            for (int i = 0; i <= N; i++) {
                dist[i] = Integer.MAX_VALUE;
            }
            dist[S] = weight[S];
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
            pq.offer(new int[]{S, dist[S]});
            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                int u = cur[0];
                int d = cur[1];
                if (visited[u]){
                    continue;
                } 
                visited[u] = true;
                if (u == D){
                    break;
                }
                for (int v : graph[u]) {
                    if (visited[v]){
                        continue;
                    } 
                    int nd = d + weight[v];
                    if (nd < dist[v]) {
                        dist[v] = nd;
                        pq.offer(new int[]{v, nd});
                    }
                }
            }
        if (dist[D] == Integer.MAX_VALUE) {
            pw.println(-1);
        } 
        else {
            pw.println(dist[D]);
        }
        pw.flush();
        pw.close();
    }
}
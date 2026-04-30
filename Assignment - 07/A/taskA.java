import java.io.*;
import java.util.*;
public class taskA{
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

        st = new StringTokenizer(br.readLine());
        int[] u = new int[M];
        for (int i = 0; i < M; i++) {
            u[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] v = new int[M];
        for (int i = 0; i < M; i++) {
            v[i] = Integer.parseInt(st.nextToken());
        }

        st =new StringTokenizer(br.readLine());
        int[] w = new int[M];
        for (int i = 0; i < M; i++) {
            w[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i < M; i++) {
            graph[u[i]].add(new int[]{v[i], w[i]});
        }

        int[] dist = new int[N + 1];
        int[] parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        dist[S] = 0;
        pq.offer(new int[]{0, S});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u_node = current[0];
            int u_dist = current[1];
            if (u_dist > dist[u_node]){
                continue;
            } 
            for (int[] edge : graph[u_node]) {
                int v_node = edge[0];
                int weight = edge[1];
                if (dist[u_node] + weight < dist[v_node]) {
                    dist[v_node] = dist[u_node] + weight;
                    parent[v_node] = u_node;
                    pq.offer(new int[]{v_node, dist[v_node]});
                }
            }
        }

        if (dist[D] == Integer.MAX_VALUE) {
            pw.println(-1);
        } 
        else {
            pw.println(dist[D]);
            ArrayList<Integer> path = new ArrayList<>();
            int current = D;
            while (current != -1) {
                path.add(current);
                current = parent[current];
            }
            Collections.reverse(path);
            for (int i = 0; i < path.size(); i++) {
                pw.print(path.get(i));
                if (i < path.size() - 1){
                    pw.print(" ");
                }
            }
            pw.println();
        }
        
        pw.flush();
        pw.close();
    }
}

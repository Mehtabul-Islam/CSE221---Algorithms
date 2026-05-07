import java.io.*;
import java.util.*;

public class D {
    static ArrayList<ArrayList<int[]>> graph;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            int[] u = new int[M];
            int[] v = new int[M];
            int[] w = new int[M];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < M; i++) {
                u[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < M; i++) {
                v[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < M; i++) {
                w[i] = Integer.parseInt(st.nextToken());
            }

            graph = new ArrayList<>();

            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {

                graph.get(u[i]).add(new int[]{v[i], w[i]});
                graph.get(v[i]).add(new int[]{u[i], w[i]});
            }

            int low = 0;
            int high = 100000000;
            int ans = 0;

            while (low <= high) {

                int mid = low + (high - low) / 2;

                if (check(S, D, mid, N)) {
                    low = mid + 1;
                }
                else {
                    ans = mid;
                    high = mid - 1;
                }
            }

            pw.println(ans);
        }

        pw.flush();
        pw.close();
    }

    public static boolean check(int S, int D, int K, int N) {

        boolean[] visited = new boolean[N + 1];

        Queue<Integer> q = new LinkedList<>();

        q.offer(S);

        visited[S] = true;

        while (!q.isEmpty()) {

            int u = q.poll();

            if (u == D) {
                return true;
            }

            for (int i = 0; i < graph.get(u).size(); i++) {

                int[] edge = graph.get(u).get(i);

                int v = edge[0];
                int w = edge[1];

                if (w > K && !visited[v]) {

                    visited[v] = true;

                    q.offer(v);
                }
            }
        }

        return false;
    }
}

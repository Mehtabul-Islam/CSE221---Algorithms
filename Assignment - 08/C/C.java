import java.io.*;
import java.util.*;

public class C{

    static ArrayList<ArrayList<int[]>> graph;
    static int[] parent;
    static int[] rank;
    static PrintWriter pw;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[2] - b[2];
            }
        });

        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.offer(new int[]{u, v, w});
        }

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        parent = new int[N + 1];
        rank = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        ArrayList<int[]> extra = new ArrayList<>();
        long count = 0;
        int used = 0;

        while (!pq.isEmpty()) {

            int[] edge = pq.poll();
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if (find(u) != find(v)) {

                uni(u, v);

                graph.get(u).add(new int[]{v, w});
                graph.get(v).add(new int[]{u, w});

                count += w;
                used++;
            }
            else {
                extra.add(edge);
            }
        }

        if (used != N - 1) {

            pw.println(-1);

            pw.flush();
            pw.close();

            return;
        }

        long ans = Long.MAX_VALUE;

        for (int i = 0; i < extra.size(); i++) {

            int[] edge = extra.get(i);

            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            int[] temp = maxEdge(u, v, N);

            int max1 = temp[0];
            int max2 = temp[1];

            long add = Long.MAX_VALUE;

            if (w > max1) {
                add = w - max1;
            }
            else if (w == max1) {

                if (max2 != -1) {
                    add = w - max2;
                }
            }

            if (add > 0 && add != Long.MAX_VALUE) {
                ans = Math.min(ans, add);
            }
        }

        if (ans == Long.MAX_VALUE) {
            pw.println(-1);
        }
        else {
            pw.println(count + ans);
        }

        pw.flush();
        pw.close();
    }

    public static void uni(int x, int y) {

        int rX = find(x);
        int rY = find(y);

        if (rX == rY) {
            return;
        }

        if (rank[rX] < rank[rY]) {

            parent[rX] = rY;
        }
        else if (rank[rX] > rank[rY]) {

            parent[rY] = rX;
        }
        else {

            parent[rY] = rX;
            rank[rX]++;
        }
    }

    public static int find(int x) {

        int root = x;

        while (parent[root] != root) {
            root = parent[root];
        }

        while (x != root) {

            int next = parent[x];
            parent[x] = root;
            x = next;
        }

        return root;
    }

    public static int[] maxEdge(int start, int end, int N) {

        int[] node = new int[N + 1];
        int[] weight = new int[N + 1];

        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();

        q.offer(start);
        visited[start] = true;
        node[start] = -1;

        boolean ok = false;

        while (!q.isEmpty()) {

            int u = q.poll();

            if (u == end) {
                ok = true;
                break;
            }
            for (int i = 0; i < graph.get(u).size(); i++) {

                int[] edge = graph.get(u).get(i);

                int v = edge[0];
                int w = edge[1];

                if (!visited[v]) {

                    visited[v] = true;
                    node[v] = u;
                    weight[v] = w;
                    q.offer(v);
                }
            }
        }

        if (!ok) {
            return new int[]{-1, -1};
        }

        int max1 = -1;
        int max2 = -1;

        int curr = end;

        while (curr != start) {

            int w = weight[curr];
            if (w > max1) {
                max2 = max1;
                max1 = w;
            }
            else if (w > max2) {
                max2 = w;
            }

            curr = node[curr];
        }
        return new int[]{max1, max2};
    }
}
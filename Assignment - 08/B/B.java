import java.io.*;
import java.util.*;

public class B {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] e = new int[M][3];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            e[i][0] = u;
            e[i][1] = v;
            e[i][2] = w;
        }

        Arrays.sort(e, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[2] - b[2];
            }
        });

        Union uf = new Union(N);

        long count = 0;
        int used = 0;
        int idx = 0;

        while (idx < M && used < N - 1) {

            int u = e[idx][0];
            int v = e[idx][1];
            int w = e[idx][2];

            boolean ok = uf.uni(u, v);

            if (ok) {
                count += w;
                used++;
            }

            idx++;
        }

        pw.println(count);

        br.close();
        pw.close();
    }
}

class Union {

    int[] parent;
    int[] rank;

    public Union(int n) {

        parent = new int[n + 1];
        rank = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {

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

    public boolean uni(int x, int y) {

        int rX = find(x);
        int rY = find(y);

        if (rX == rY) {
            return false;
        }

        if (rank[rX] > rank[rY]) {
            parent[rY] = rX;
        }
        else if (rank[rX] < rank[rY]) {
            parent[rX] = rY;
        }
        else {
            parent[rY] = rX;
            rank[rX]++;
        }

        return true;
    }
}
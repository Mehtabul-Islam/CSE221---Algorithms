import java.io.*;
import java.util.*;

public class B {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] color = new int[N + 1];
        Arrays.fill(color, -1);

        ArrayDeque<Integer> q = new ArrayDeque<>();
        int ans = 0;
        boolean check = true;

        for (int i = 1; i <= N; i++) {

            if (color[i] != -1) continue;

            int c1 = 0, c2 = 0;

            q.add(i);
            color[i] = 0;
            c1++;

            while (!q.isEmpty()) {
                int u = q.poll();

                for (int v : adj.get(u)) {

                    if (color[v] == -1) {
                        color[v] = 1 - color[u];

                        if (color[v] == 0) c1++;
                        else c2++;

                        q.add(v);
                    } 
                    else if (color[v] == color[u]) {
                        check = false;
                        break;
                    }
                }

                if (!check) break;
            }

            ans += Math.max(c1, c2);
            if (!check) break;
        }

        pw.println(check ? ans : 0);
        pw.flush();
    }
}

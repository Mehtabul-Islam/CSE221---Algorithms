import java.io.*;
import java.util.*;

public class C {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x1 = Integer.parseInt(st.nextToken()) - 1;
        int y1 = Integer.parseInt(st.nextToken()) - 1;
        int x2 = Integer.parseInt(st.nextToken()) - 1;
        int y2 = Integer.parseInt(st.nextToken()) - 1;

        if (x1 == x2 && y1 == y2) {
            pw.println(0);
            pw.flush();
            return;
        }

        int[] dx = {2, 2, 1, 1, -1, -1, -2, -2};
        int[] dy = {1, -1, 2, -2, 2, -2, 1, -1};

        int total = N * N;
        int[] d = new int[total];
        Arrays.fill(d, -1);

        int[] q = new int[total];
        int x = 0, y = 0;

        int start = x1 * N + y1;
        int target = x2 * N + y2;

        q[y++] = start;
        d[start] = 0;

        while (x < y) {

            int cur = q[x++];
            int cx = cur / N;
            int cy = cur % N;

            for (int k = 0; k < 8; k++) {

                int nx = cx + dx[k];
                int ny = cy + dy[k];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                int next = nx * N + ny;
                if (d[next] != -1) continue;

                d[next] = d[cur] + 1;

                if (next == target) {
                    pw.println(d[next]);
                    pw.flush();
                    return;
                }

                q[y++] = next;
            }
        }

        pw.println(-1);
        pw.flush();
    }
}

import java.io.*;
import java.util.*;
public class F {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        String startStr = st.nextToken();
        String targetStr = st.nextToken();

        int start = Integer.parseInt(startStr);
        int target = Integer.parseInt(targetStr);

        int n = Integer.parseInt(br.readLine());

        boolean[] forbid = new boolean[10000];

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            forbid[x] = true;
        }

        int[] dist = new int[10000];
        Arrays.fill(dist, -1);

        int[] q = new int[10000];
        int head = 0, tail = 0;

        q[tail++] = start;
        dist[start] = 0;

        while (head < tail) {

            int cur = q[head++];

            if (cur == target) {
                pw.println(dist[cur]);
                pw.flush();
                return;
            }

            int a = cur / 1000;
            int b = (cur / 100) % 10;
            int c = (cur / 10) % 10;
            int d = cur % 10;

            int[] digit = {a, b, c, d};

            for (int i = 0; i < 4; i++) {

                int old = digit[i];

                digit[i] = (old + 1) % 10;
                int next = digit[0]*1000 + digit[1]*100 + digit[2]*10 + digit[3];

                if (!forbid[next] && dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    q[tail++] = next;
                }

                digit[i] = (old + 9) % 10;
                next = digit[0]*1000 + digit[1]*100 + digit[2]*10 + digit[3];

                if (!forbid[next] && dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    q[tail++] = next;
                }

                digit[i] = old; 
            }
        }

        pw.println(-1);
        pw.flush();
    }
}

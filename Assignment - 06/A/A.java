import java.io.*;
import java.util.*;

public class A {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        while (T-- > 0) {

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            List<List<Integer>> adj = new ArrayList<>();
            int [] in = new int[N + 1];

            for (int i = 0; i <= N; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());
                adj.get(first).add(second);
                in[second]++;
            }
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                if (in[i] == 0) {
                    queue.add(i);
                }
            }
            ArrayList<Integer> result = new ArrayList<>();

            while (!queue.isEmpty()) {
                int current = queue.poll();
                result.add(current);
                for (int neighbor : adj.get(current)) {
                    in[neighbor]--;
                    if (in[neighbor] == 0) {
                        queue.add(neighbor);
                    }
                }
            }
            if (result.size() != N) {
                pw.println("-1");
            } else {
                for (int i = 0; i < N; i++) {
                    if (i > 0) {
                        pw.print(" ");
                    }
                    pw.print(result.get(i));
                }
                pw.println();
            }

        }
        pw.flush();
        pw.close();
    }
}


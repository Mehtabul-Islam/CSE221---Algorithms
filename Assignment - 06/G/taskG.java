import java.io.*;
import java.util.*;

public class taskG {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String start = st.nextToken();
        String target = st.nextToken();

        String[] words = new String[n];
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
            map.put(words[i], i);
        }

        int s = map.get(start);
        int t = map.get(target);

        // group words by starting letter
        List<List<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i < 26; i++) bucket.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            int c = words[i].charAt(0) - 'A';
            bucket.get(c).add(i);
        }

        boolean[] vis = new boolean[n];
        boolean[] used = new boolean[26]; // to avoid reusing same bucket

        int[] q = new int[n];
        int head = 0, tail = 0;

        q[tail++] = s;
        vis[s] = true;

        while (head < tail) {

            int u = q[head++];

            if (u == t) {
                pw.println("YES");
                pw.flush();
                return;
            }

            char last = words[u].charAt(words[u].length() - 1);
            int idx = last - 'A';

            if (used[idx]) continue;
            used[idx] = true;

            for (int v : bucket.get(idx)) {
                if (!vis[v]) {
                    vis[v] = true;
                    q[tail++] = v;
                }
            }
        }

        pw.println("NO");
        pw.flush();
    }
}
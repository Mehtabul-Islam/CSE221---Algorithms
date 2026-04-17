import java.io.*;
import java.util.*;

public class taskC {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken()); 

        ArrayList<Integer>[] adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        if (M > 0) {
            int [] u = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i <M; i++) {
                u[i] = Integer.parseInt(st.nextToken());
            }

            int [] v = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i<M; i++) {
                v[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < M; i++) {
                adj[u[i]].add(v[i]);
                adj[v[i]].add(u[i]);
            }
        }

        for (int i = 1; i <= N; i++) {
            if (adj[i].size() > 0) {
                int[] temp = new int[adj[i].size()];
                for (int j = 0; j < adj[i].size(); j++) {
                    temp[j] = adj[i].get(j);
                }
                Arrays.sort(temp);
                adj[i].clear();
                for (int j = 0; j < temp.length; j++) {
                    adj[i].add(temp[j]);
                }
            }
        }

        int [] X = new int[N + 1];
        int [] Y = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            X[i] = -1;
            Y[i] = -1;
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        X[S] = 0;
        q.add(S);
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int i = 0; i < adj[curr].size(); i++) {
                int neighbor = adj[curr].get(i);
                if (X[neighbor] == -1) {
                    X[neighbor] = X[curr] + 1;
                    Y[neighbor] = curr;
                    q.add(neighbor);
                }
            }
        }

        if (X[D] == -1) {
            pw.println(-1);
        } 

        else {
            pw.println(X[D]);
            ArrayList<Integer> path = new ArrayList<>();
            int node = D;
            while (node != -1) {
                path.add(node);
                node = Y[node];
            }
            for (int i = 0; i < path.size() / 2; i++) {
                int temp = path.get(i);
                path.set(i, path.get(path.size() - 1 - i));
                path.set(path.size() - 1 - i, temp);
            }
            for (int i = 0; i < path.size(); i++) {
                if (i > 0){
                    pw.print(" ");
                } 
                pw.print(path.get(i));
            }
            pw.println();
        }
        
        pw.flush();
        pw.close();
    }
}

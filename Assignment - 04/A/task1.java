import java.io.*;
import java.util.*;
public class task1{
    public static void insert(int ui, int vi, int wi, int[][]graph){
        graph[ui-1][vi-1] = wi;
    }
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [][] graph = new int[N][N];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            insert(u, v, w, graph);
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                pw.print(graph[i][j] + " ");
            }
            pw.println();
        }
        pw.flush();
        pw.close();
    }
}

import java.io.*;
import java.util.*;

public class task5 {
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int [] u = new int[M];
        for(int i = 0; i < M; i++){
            u[i] = Integer.parseInt(st.nextToken()) - 1;
        }
        
        st = new StringTokenizer(br.readLine());
        int [] v = new int[M];
        for(int i = 0; i < M; i++){
            v[i] = Integer.parseInt(st.nextToken()) - 1;
        }
        int [] diff = new int[N]; 
        for(int i = 0; i < M; i++){
            if(u[i] >= 0 && u[i] < N){
                    diff[u[i]] -= 1;
                }  
                if(v[i] >= 0 && v[i] < N) {
                    diff[v[i]] += 1;
                } 
        }

        for(int i = 0; i < N; i++){
            if(i > 0){
                pw.print(" ");
            }
            pw.print(diff[i]);
        }
        pw.println();
        pw.flush();
        pw.close();
    }
}

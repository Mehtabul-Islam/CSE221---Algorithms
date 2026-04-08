import java.io.*;
import java.util.*;

public class task4 {
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

        int [] deg = new int[N];
        for(int i = 0; i < M; i++){
            deg[u[i]]++;
            deg[v[i]]++;
        }
        int count =  0;
        for(int i = 0; i < N; i++){
            if(deg[i] % 2 != 0){
                count++;
            }
        }
        if(count == 0 || count == 2){
            pw.print("YES");
        }
        else{
            pw.print("NO");
        }
        pw.flush();
        pw.close();
    }
}

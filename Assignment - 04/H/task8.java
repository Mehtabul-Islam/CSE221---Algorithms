import java.io.*;
import java.util.*;

public class task8 {
    public static void main(String[] args)throws Exception{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int vertice = Integer.parseInt(st.nextToken());
        int queries = Integer.parseInt(st.nextToken());
 
 
        boolean[][] check = new boolean[vertice + 1][vertice + 1];
        for (int i = 1; i <= vertice; i++) {
            for (int j = 1; j <= vertice; j++) {
                if (gcd(i, j) == 1) {
                    check[i][j] = true;
                }
            }
        }
        
        for(int i=0; i<queries; i++){
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
 
            int count = 0;
            int answer = -1;
 
            for(int j=1; j<=vertice; j++){
                if(node!=j && check[node][j]){
                    count++;
 
                    if(count==k){
                        answer = j;
                        break;
                    }
                }
 
            }
            pw.println(answer);
        }
        pw.flush();
        pw.close();
    }
        public static int gcd(int a, int b){
            while(b!=0){
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}


import java.io.*;
import java.util.*;
public class taskd {
    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int d = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < d; i++){
            int n = Integer.parseInt(br.readLine());
            int arr[] = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            boolean result = true;
            for(int j = 0; j < n - 1; j++){
                if(arr[j] > arr[j + 1]){
                    result = false;
                    break;
                }
            }
            if(result){
                pw.println("YES");
            } else {
                pw.println("NO");
            }
        }
        pw.flush();
        pw.close();
    }
}

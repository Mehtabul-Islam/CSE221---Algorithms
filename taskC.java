import java.io.*;
import java.util.*;

public class taskC {
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String s1 = br.readLine();
        String [] s2 = s1.split(" ");
        int length = Integer.parseInt(s2[0]);
        int sum = Integer.parseInt(s2[1]);
        
        String s3 = br.readLine();
        String [] s4 = s3.split(" ");
        int [][] n1 = new int[length][2];
        for(int i = 0; i < length; i++){
            n1[i][0] = Integer.parseInt(s4[i]);
            n1[i][1] = i + 1;
        }
        Arrays.sort(n1, (a, b) -> Integer.compare(a[0], b[0]));
        for(int i = 0; i < length - 2; i++){
            int p2 = i + 1;
            int p3 = length - 1;
            while(p2 < p3){
                int total = n1[i][0] + n1[p2][0] + n1[p3][0];
                if(total == sum){
                    pw.println(n1[i][1] + " " + n1[p2][1] + " " + n1[p3][1]);
                    pw.flush();
                    return;
                }
                else if(total < sum){
                    p2++;
                }
                else{
                    p3--;
                }
            } 
        }
        pw.println(-1);
        pw.flush();
        pw.close();
    }
}

import java.io.*;

public class taskH {
    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int a = Integer.parseInt(br.readLine());
        for(int i = 0; i < a; i++){
            String s1 = br.readLine();
            String [] s2 = s1.split(" ");
            int k = Integer.parseInt(s2[0]);
            int x = Integer.parseInt(s2[1]);
            int n = (k - 1) / (x - 1);
            int ans = k + n;
            pw.println(ans);
        }
        pw.flush();
        pw.close();
    }
}

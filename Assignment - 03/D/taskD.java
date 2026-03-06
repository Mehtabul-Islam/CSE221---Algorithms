import java.io.*;
import java.util.StringTokenizer;
 
public class taskD {
    static final int MOD = 1000000007;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = null;
 
        String line = br.readLine();
        if (line == null) return;
        int T = Integer.parseInt(line.trim());
 
        for (int t = 0; t < T; t++) {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            long[][] A = new long[2][2];
            A[0][0] = Long.parseLong(st.nextToken());
            A[0][1] = Long.parseLong(st.nextToken());
            A[1][0] = Long.parseLong(st.nextToken());
            A[1][1] = Long.parseLong(st.nextToken());
 
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            long X = Long.parseLong(st.nextToken());
 
            long[][] res = power(A, X);
 
            pw.println(res[0][0] + " " + res[0][1]);
            pw.println(res[1][0] + " " + res[1][1]);
        }
        pw.flush();
        pw.close();
    }
 
    static long[][] multiply(long[][] a, long[][] b) {
        long[][] res = new long[2][2];
        res[0][0] = (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % MOD;
        res[0][1] = (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % MOD;
        res[1][0] = (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % MOD;
        res[1][1] = (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % MOD;
        return res;
    }
 
    static long[][] power(long[][] base, long exp) {
        long[][] res = new long[][]{{1, 0}, {0, 1}};
        while (exp > 0) {
            if (exp % 2 == 1) {
                res = multiply(res, base);
            }
            base = multiply(base, base);
            exp /= 2;
        }
        return res;
    }
}


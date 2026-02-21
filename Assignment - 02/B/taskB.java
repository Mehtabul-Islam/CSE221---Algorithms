import java.io.*;

public class taskB {
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String s0 = br.readLine();
        String [] xx = s0.split(" ");
        int N = Integer.parseInt(xx[0]);
        int M = Integer.parseInt(xx[1]);
        int K = Integer.parseInt(xx[2]);

        String a1 = br.readLine();
        String [] aa = a1.split(" ");
        int A [] = new int[N];
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(aa[i]);
        }

        String b1 = br.readLine();
        String [] bb = b1.split(" ");
        int B [] = new int[M];
        for(int i = 0; i < M; i++){
            B[i] = Integer.parseInt(bb[i]);
        }
        
        int a = 0;
        int b = M-1;
        int max = Integer.MAX_VALUE;;
        int besti = 0;
        int bestj = 0;
        while(a < N && b >= 0){
            int sum = A[a] + B[b];
            int diff = Math.abs(sum - K);
            if(diff < max){
                max = diff;
                besti = a;
                bestj = b;
            }
            if(sum > K){
                b--;
            }
            else{
                a++;
            }
        }
        pw.println((besti+1) + " " + (bestj+1));
        pw.flush();
        pw.close();
    }
}

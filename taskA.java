import java.io.*;

public class taskA {
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s0 = br.readLine();
        String [] xx = s0.split(" ");
        int length = Integer.parseInt(xx[0]);
        int sum = Integer.parseInt(xx[1]);;


        PrintWriter pw = new PrintWriter(System.out);

        String s1 = br.readLine();
        String [] y = s1.split(" ");
        int x [] = new int[length];

        for(int i = 0; i <= length-1; i++){
            x[i] = Integer.parseInt(y[i]);
        }

        int p1 = 0;
        int p2 = length-1;
        boolean found = false;

        while(p1 < p2){
            if(x[p1] + x[p2] == sum){
                found = true;
                pw.println((p1+1) + " " + (p2+1));
                break;
            }
            if(x[p1] + x[p2] < sum){
                p1++;
            }
            else{
                p2--;
            }
        }
        if(found == false){
            pw.println(-1);
        }
        pw.flush();
        pw.close();
    }
}

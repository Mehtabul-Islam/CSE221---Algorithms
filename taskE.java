import java.io.*;

public class taskE {
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String s1 = br.readLine();
        String [] s2 = s1.split(" ");
        int length = Integer.parseInt(s2[0]);
        int sum = Integer.parseInt(s2[1]);

        String s3 = br.readLine();
        String [] s4 = s3.split(" ");
        int [] arr = new int[length];
        for(int i = 0; i < length; i++){
            arr[i] = Integer.parseInt(s4[i]);
        }
        
        int total = 0;
        int start = 0;
        int max = 0;

        for(int i = 0; i < length; i++){
            total += arr[i];
            while(total > sum){
                total -= arr[start];
                start++;
            }
            max = Math.max(max, i - start + 1);
        }
        pw.println(max);
        pw.flush();
        pw.close();
    }
}

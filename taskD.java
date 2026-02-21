import java.io.*;

public class taskD {
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int N = Integer.parseInt(br.readLine());
        String n1 = br.readLine();
        String [] nn = n1.split(" ");
        int [] num1 = new int [N];
        for(int i = 0; i < N; i++){
            num1[i] = Integer.parseInt(nn[i]);
        }

        int M = Integer.parseInt(br.readLine());
        String m1 = br.readLine();
        String [] mm = m1.split(" ");
        int [] num2 = new int [M];
        for(int i = 0; i < M; i++){
            num2[i] = Integer.parseInt(mm[i]);
        }
        StringBuilder sb = new StringBuilder();
        int a = 0;
        int b = 0;
        while(a < N && b < M){
            if(num1[a] <= num2[b]){
                sb.append(num1[a++]).append(" ");
            }
            else{
                sb.append(num2[b++]).append(" ");
            }  
        }
        while(a < N){
                sb.append(num1[a++]).append(" ");
            }
        while(b < M){
                sb.append(num2[b++]).append(" ");
        } 
        pw.print(sb);
        pw.flush();
        pw.close();    
    }     
}


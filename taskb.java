import java.io.*;
import java.util.regex.*;

public class taskb {
    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int b = Integer.parseInt(br.readLine());
        Pattern pt = Pattern.compile("^calculate (\\d+) (\\W) (\\d+)$");
        for(int i = 0; i < b; i++){
            Matcher mt = pt.matcher(br.readLine());
            if(mt.find()==true){
                double n1 = Double.parseDouble(mt.group(1));
                double n2 = Double.parseDouble(mt.group(3));
                String op = mt.group(2);
                double ans = 0;
                if(op.equals("+")){
                    ans = n1 + n2;
                } else if(op.equals("-")){
                    ans = n1 - n2;
                } else if(op.equals("*")){
                    ans = n1 * n2;
                } else if(op.equals("/")){
                    ans = n1 / n2;
                }
                pw.println(ans);
            }
        }
        pw.flush();
        pw.close();
    }
}
            
        
    


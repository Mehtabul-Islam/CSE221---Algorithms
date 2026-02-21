import java.io.*;

public class taskG {
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        String s1 = br.readLine();
        String [] s2 = s1.split(" ");
        int length = Integer.parseInt(s2[0]);
        int queries = Integer.parseInt(s2[1]);

        String s3 = br.readLine();
        String [] s4 = s3.split(" ");
        int [] arr = new int[length];
        for(int i = 0; i < length; i++){
            arr[i] = Integer.parseInt(s4[i]);
        }

        while(queries-- > 0){
            String query1 = br.readLine();
            String [] query2 = query1.split(" ");
            int x = Integer.parseInt(query2[0]);
            int y = Integer.parseInt(query2[1]);

            int left = 0;
            int right = length;
            while (left < right) {
                int mid = (left + right) / 2;
                if (arr[mid] < x)
                    left = mid + 1;
                else
                    right = mid;
            }
            int leftIndex = left;

            left = 0;
            right = length;
            while (left < right) {
                int mid = (left + right) / 2;
                if (arr[mid] <= y)
                    left = mid + 1;
                else
                    right = mid;
            }
            int rightIndex = left;

            pw.println(rightIndex - leftIndex);
        
        }

        pw.flush();
        pw.close();
    }
}

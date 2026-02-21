import java.io.*;

public class taskF {
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String s1 = br.readLine();
        String [] s2 = s1.split(" ");
        int length = Integer.parseInt(s2[0]);
        int allowed = Integer.parseInt(s2[1]);

        String s3 = br.readLine();
        String [] s4 = s3.split(" ");
        int [] arr = new int[length];
        for(int i = 0; i < length; i++){
            arr[i] = Integer.parseInt(s4[i]);
        }

        int [] freq = new int[length + 1]; 
        int left = 0;
        int distinct = 0;
        int maxLength = 0;

        for (int right = 0; right < length; right++) {
            if (freq[arr[right]] == 0) {
                distinct++;
            }
            freq[arr[right]]++;

            while (distinct > allowed) {
                freq[arr[left]]--;
                if (freq[arr[left]] == 0) {
                    distinct--;
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        pw.println(maxLength);

        pw.flush();
        pw.close();
    }
}

import java.io.*;
import java.util.regex.*;

public class taskh {
    
    // Custom rank for lowercases (0-25) before uppercases (26-51)
    static int getRank(char c) {
        if (c >= 'a' && c <= 'z') return c - 'a';
        return c - 'A' + 26;
    }

    // Custom comparison for special lexicographical order
    static int compareSpecial(String s1, String s2) {
        int len = Math.min(s1.length(), s2.length());
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return getRank(s1.charAt(i)) - getRank(s2.charAt(i));
            }
        }
        return s1.length() - s2.length();
    }

    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        Pattern pt = Pattern.compile("^(\\w+) will depart for (\\w+) at (\\d+):(\\d+)$");
        
        int x = Integer.parseInt(br.readLine().trim());
        
        // Parallel arrays to store our data so we only use Regex ONCE per line
        String [] arr = new String [x];
        String [] names = new String [x];
        int [] times = new int [x];
        
        // Read input and parse immediately
        for(int i=0; i<x; i++){
            arr[i] = br.readLine();
            Matcher matcher = pt.matcher(arr[i]);
            
            if(matcher.find()) {
                names[i] = matcher.group(1);
                int hour = Integer.parseInt(matcher.group(3));
                int min = Integer.parseInt(matcher.group(4));
                times[i] = hour * 60 + min; // Store time in total minutes
            }
        }
        
        // Your exact Bubble Sort logic, but now lightning fast!
        for(int i=0; i<x-1; i++){
            for(int j=0; j<x-1-i; j++){
                
                int lexi = compareSpecial(names[j], names[j+1]);

                // Swap if name is out of order, OR if names are tied but time1 < time2
                if(lexi > 0 || (lexi == 0 && times[j] < times[j+1])){
                    
                    // 1. Swap the original sentences
                    String temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    
                    // 2. Swap the names to keep arrays parallel
                    String tempName = names[j];
                    names[j] = names[j+1];
                    names[j+1] = tempName;
                    
                    // 3. Swap the times to keep arrays parallel
                    int tempTime = times[j];
                    times[j] = times[j+1];
                    times[j+1] = tempTime;
                }
            }
        }
        
        for(int k=0; k<x; k++){
            pw.println(arr[k]);
        }
        pw.flush();
        pw.close();
    }
}
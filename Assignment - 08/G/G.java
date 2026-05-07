import java.io.*;
import java.util.*;

public class G {
    static class Task {
        int x, y;
        Task(int x, int y) { 
            this.x = x; 
            this.y = y; 
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        processTestCase(br, pw);
        
        pw.flush();
        pw.close();
    }

    private static void processTestCase(BufferedReader br, PrintWriter pw) throws IOException {
        int n = Integer.parseInt(br.readLine().trim());
        Task[] tasks = new Task[n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            tasks[i] = new Task(x, y);
        }
        
        Arrays.sort(tasks, Comparator.comparingInt(t -> t.x));
        
        long reward = 0;
        long time = 0;
        
        for (int k = 0; k < tasks.length; k++) {
            Task currentTask = tasks[k]; 
            time += currentTask.x; 
            reward += currentTask.y - time;              
        }
        
        pw.println(reward);
    }
}
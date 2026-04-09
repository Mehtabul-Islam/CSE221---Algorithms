import java.io.*;
import java.util.*;

public class task7 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
 
        int dx[] = {-2, -2, -1, -1, 1, 1, 2, 2};
        int dy[] = {-1, 1, -2, 2, -2, 2, -1, 1};
        boolean[][] hasknight = new boolean[row+1][column+1];
        for(int i = 0; i <  k; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
 
            for(int j = 0; j < 8; j++){
                int movx = x + dx[j];
                int movy = y + dy[j];
 
                if(movx>=1 && movx<=row && movy>=1 && movy<=column){
                   if(hasknight[movx][movy]==true){
                      pw.println("YES");
                      pw.close();
                      return;
                   }
                }
                hasknight[x][y] = true;
            }    
        }
        pw.println("NO");
        pw.flush();
        pw.close();
    }
}

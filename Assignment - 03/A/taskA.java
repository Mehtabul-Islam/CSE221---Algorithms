import java.io.*;
import java.util.*;

public class taskA {
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int length = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int arr [] = new int[length];
        for(int i = 0; i < length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        count = 0;
        int [] ans = MERGE(arr);
        pw.println(count);
        for(int i = 0; i < ans.length; i++){
            pw.print(ans[i] + " ");
        }
        pw.println();
        pw.flush();
        pw.close();
    }
    static long count = 0;
    static int [] MERGE(int [] arr){
        if(arr.length <= 1){
            return arr;
        }
        int mid = arr.length / 2;
        int [] left = new int[mid];
        for(int i = 0; i < mid; i++){
            left[i] = arr[i];
        }
        int [] right = new int[arr.length - mid];
        for(int i = mid; i < arr.length; i++){
            right[i - mid] = arr[i];
        }
        left = MERGE(left);
        right = MERGE(right);
        return merge(left, right);
    }
    static int [] merge(int [] x, int [] y){
        int a = x.length;
        int b = y.length;
        int [] ans = new int [a + b];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < a && j < b){
            if(x[i] <= y[j]){
                ans[k++] = x[i++];
            }
            else{
                ans[k++] = y[j++];
                count += (a - i);
            }
        }
        while(i < a){
            ans[k++] = x[i++];
        }
        while(j < b){
            ans[k++] = y[j++];
        }
        return ans;
    }
}

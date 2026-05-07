import java.io.*;
import java.util.*;

public class E{

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {

            public int compare(int[] a, int[] b) {

                if (a[1] == b[1]) {
                    return a[0] - b[0];
                }

                return a[1] - b[1];
            }
        });

        ArrayList<int[]> ans = new ArrayList<>();

        int last = -1;

        for (int i = 0; i < N; i++) {

            int s = arr[i][0];
            int e = arr[i][1];

            if (s > last) {

                ans.add(new int[]{s, e});

                last = e;
            }
        }

        pw.println(ans.size());

        for (int i = 0; i < ans.size(); i++) {

            int[] temp = ans.get(i);

            pw.println(temp[0] + " " + temp[1]);
        }

        pw.flush();
        pw.close();
    }
}
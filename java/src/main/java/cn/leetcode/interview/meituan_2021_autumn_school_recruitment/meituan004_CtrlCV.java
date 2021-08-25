package cn.leetcode.interview.meituan_2021_autumn_school_recruitment;

import java.io.*;

public class meituan004_CtrlCV {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        String[] data = reader.readLine().split(" ");

        int[] a = new int[200005];
        int[] b = new int[200005];

        for (int i = 0; i < 200005; i++) {
            a[i] = i < n ? Integer.parseInt(data[i]) : -1;
            b[i] = -1;
        }

        int m = Integer.parseInt(reader.readLine());
        for (int i = 0; i < m; i++) {
            String[] row = reader.readLine().split(" ");
            if (row[0].equals("2")){
                writer.write("" + b[Integer.parseInt(row[1]) - 1]);
                writer.newLine();
            }else {
                int l = Integer.parseInt(row[1]);
                System.arraycopy(a, Integer.parseInt(row[2]) - 1, b, Integer.parseInt(row[3]) - 1, l);
            }
        }
        writer.close();
        reader.close();
    }
}

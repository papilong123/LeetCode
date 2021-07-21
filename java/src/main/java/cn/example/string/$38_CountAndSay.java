package cn.example.string;

class $38_CountAndSay {
    public String countAndSay(int n) {
        String res = "1";

        for (int i = 1; i < n; i++) {
            res = next_time(res);
        }
        return res;


    }

    private String next_time(String res) {
        int i = 0;
        int n = res.length();
        String ans = "";
        while (i < n) {
            int count = 1;
            while ((i < n - 1) && (res.charAt(i) == res.charAt(i + 1))) {
                i++;
                count++;
            }
            ans += (count + "" + res.charAt(i));
            i++;

        }
        return ans;
    }
}

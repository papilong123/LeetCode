class Solution {
public:
    static int op (int x, int y) {
        return (x + y) % 26;
    }
    cn.example.string shiftingLetters(cn.example.string S, vector<int>& shifts) {
        vector<int> shift_sum(shifts);
        partial_sum(shifts.rbegin(), shifts.rend(), shift_sum.rbegin(), op);
        for (int i = 0; i < shift_sum.size(); ++i) {
            S[i] = ((S[i] - 'a' + shift_sum[i]) % 26) + 'a';
        }
        return S;

    }
};

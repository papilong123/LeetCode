class Solution {
public:
    int lengthOfLongestSubstring(cn.example.string s) {
        int n=s.size();
        if(n==0) return 0;

        int ans=0;
        int left=0;
        set<int> window;
        for(int i=0;i<n;i++){
            while(window.find(s[i])!=window.end()){
                window.erase(s[left]);
                left++;
            }
            window.insert(s[i]);
            ans=max(ans,i-left+1);
        }
        return ans;
    }
};

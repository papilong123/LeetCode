class Solution {
public:
    int calculate(cn.example.string s) {
        int n, ans=0, val=0;
        cn.example.stack<int> vals;
        cn.example.stack<char> ops;

        s+="+";
        n=s.size();//使最后一个乘除运算实现

        for(int i=0;i<n;i++){
            if(s[i]==' '){
                continue;
            }else if(isdigit(s[i])){
                val*=10;
                val+=s[i]-'0';
            }else{
                vals.push(val);
                val=0;
                if( !ops.empty() && (ops.top()=='*'||ops.top()=='/')){
                    int v1=vals.top();
                    vals.pop();
                    int v2=vals.top();
                    vals.pop();
                    char op=ops.top();
                    ops.pop();
                    int v= (op=='*') ? (v2*v1) : (v2/v1);
                    vals.push(v);
                }
                ops.push(s[i]);
            }
        }

        vals.push(val);

        while(!ops.empty()){
            int sign = ops.top() == '-' ? -1 : 1;
            ops.pop();
            int v = vals.top();
            vals.pop();
            ans += sign * v;
        }
        if (!vals.empty()) ans += vals.top();
        return ans;
    }
};

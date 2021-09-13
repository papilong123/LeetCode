class Solution {
public:
    cn.example.string complexNumberMultiply(cn.example.string a, cn.example.string b) {
        stringstream aa(a),bb(b);
        vector<cn.example.string> tmp;
        cn.example.string s;
        while(getline(aa,s,'+')) tmp.push_back(s);
        tmp[1].erase(tmp[1].end()-1);
        while(getline(bb,s,'+')) tmp.push_back(s);
        tmp[3].erase(tmp[3].end()-1);
        int x = stoi(tmp[0])*stoi(tmp[2])-stoi(tmp[1])*stoi(tmp[3]);
        int y = stoi(tmp[0])*stoi(tmp[3])+stoi(tmp[1])*stoi(tmp[2]);
        return to_string(x)+"+"+to_string(y)+"i";
    }
};

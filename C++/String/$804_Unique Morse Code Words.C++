class Solution {
public:
    int uniqueMorseRepresentations(vector<cn.example.string>& words) {
        vector<cn.example.string> Morse_Code={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        set<cn.example.string> s;
        for(int i=0;i<words.size();i++){
            cn.example.string str="";
            for(int j=0;j<words[i].size();j++){
                str.append(Morse_Code[words[i][j]-'a']);
            }
            s.insert(str);
        }
        return s.size();
    }
};

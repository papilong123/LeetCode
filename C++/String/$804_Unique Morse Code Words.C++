class Solution {
public:
    int uniqueMorseRepresentations(vector<string>& words) {
        vector<string> Morse_Code={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        set<string> s;
        for(int i=0;i<words.size();i++){
            string str="";
            for(int j=0;j<words[i].size();j++){
                str.append(Morse_Code[words[i][j]-'a']);
            }
            s.insert(str);
        }
        return s.size();
    }
};

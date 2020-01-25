class Solution {
public:
    int numUniqueEmails(vector<string>& emails) {
        set<string> res;
        for(int i=0;i<emails.size();i++){
            for(int j=0;j<emails[i].size();j++){
                if(emails[i][j]=='.'){
                    emails[i].erase(j,1);
                    continue;
                }
                if(emails[i][j]=='+'){
                    int count=0;
                    int tmp=j;
                    while(emails[i][j]!='@'){
                        j++;
                        count++;
                    }
                    emails[i].erase(tmp,count);
                    break;
                }
                if(emails[i][j]=='@'){
                    break;
                }
            }
        }
        for(auto str: emails){
            res.insert(str);
        }
        return res.size();
    }
};

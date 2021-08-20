struct term{
    cn.example.string name;
    int time;
    int prize;
    cn.example.string place;
};

class Solution {
public:

    vector<cn.example.string> invalidTransactions(vector<cn.example.string>& transactions) {
        vector<cn.example.string> res;
        vector<term> terms;
        term t;
        for(auto str: transactions){
            int count=0;
            cn.example.string tmp="";
            for(auto c: str){
                if(c==','){
                    if(count==0) t.name=tmp;
                    if(count==1) t.time=stoi(tmp);
                    if(count==2) t.prize=stoi(tmp);
                    count++;
                    tmp="";
                }else{
                    tmp+=c;
                }
            }
            t.place=tmp;
            terms.push_back(t);
        }

        for(int i=0;i<terms.size();i++){
            if(terms[i].prize>=1000){
                res.push_back(transactions[i]);
                continue;
            }
            for (int j = 0;j<terms.size();j++){
                if (i == j) continue;
                if (terms[i].name==terms[j].name && (abs)(terms[i].time-terms[j].time)<=60 && terms[i].place!=terms[j].place){
                    res.push_back(transactions[i]);
                    break;
                }
            }
        }
        return res;
    }
};

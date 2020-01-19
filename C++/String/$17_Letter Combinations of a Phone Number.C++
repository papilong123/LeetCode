class Solution {
public:
    vector<string> letterCombinations(string digits) {
        map<char,string> M={{'2',"abc"},{'3',"def"},{'4',"ghi"},{'5',"jkl"},{'6',"mno"},{'7',"pqrs"},{'8',"tuv"},{'9',"wxyz"}};//映射哈希函数
        vector<string> res;
        int n=digits.size();
        queue<string> q;

        for(int i=0;i<M[digits[0]].size();i++){
            string s;
            s.push_back(M[digits[0]][i]);//char转string
            q.push(s);//string入队
        }


        for(int i=1;i<n;i++){
            int len=q.size();
            while(len--){
                for(int j=0 ; j<M[digits[i]].size() ; j++){
                    string str=q.front();
                    str+=M[digits[i]][j];//队头元素加新元素
                    q.push(str);//进队
                }
                q.pop();//队头出队
            }
        }
        while(!q.empty()){
            res.push_back(q.front());//队头元素存储至res
			q.pop();//队头出队
        }
        return res;
    }
};
/*
方法概述：
利用数据结构中队列的“先进先出”的知识，采用实时更新队列的内容实现遍历。
步骤说明：
1.建立一个map哈希表；
2.新建一个队列；
3.将第一个字符串所对应的码表逐步进入到队列中；
4.出队操作，存储当前出队的string；
5.将此string与后一个字符串所对应的码表中每一个值相加并逐步进入到队列中；
6.最终队列中存储的即为所有情况的string  */

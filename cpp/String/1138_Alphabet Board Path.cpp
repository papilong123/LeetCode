#include <vector>
#include <string>

using namespace std;


class Solution {

/*因为最后一行只有一个字母 z，当前字符为 z 的时候，不能从字母 z 的右边到达，只能从上边到达。所以U在R前
而上一个字符为字母 z 的时候，我们不能从字母 z 的右边出发，只能从字母 z 的上边出发。所以L在D前
所以我们需要优化一个答案生成顺序，优先生成左 L 上 U，即可避免移动出 alphabet board 的非法路径。*/

public:
    string alphabetBoardPath(string target) {
        string res;
        int x=0,y=0,x1,y1;
        for(int i=0;i<target.size();i++){
            y1=(target[i]-'a')/5;
            x1=(target[i]-'a')%5;
            res+=string(max(0,y-y1),'U')+string(max(0,x1-x),'R')+string(max(0,x-x1),'L')+string(max(0,y1-y),'D')+"!";
            x=x1;
            y=y1;
        }
        return res;
    }
};

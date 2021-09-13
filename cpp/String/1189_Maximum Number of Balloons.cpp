#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    int maxNumberOfBalloons(string text) {
       int a[5]={0};
       for(int i=0;i<text.size();i++){
           switch(text[i]){
               case 'a':a[0]++;break;
               case 'b':a[1]++;break;
               case 'l':a[2]++;break;
               case 'n':a[3]++;break;
               case 'o':a[4]++;break;
               default:break;
           }
       }
       a[2]/=2;
       a[4]/=2;
       int tmp=a[0];
       for(int i=1;i<5;i++){
           if(a[i]<tmp) tmp=a[i];
       }
       return tmp;
    }
};

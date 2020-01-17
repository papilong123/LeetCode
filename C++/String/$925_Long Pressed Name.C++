class Solution {
public:
    bool isLongPressedName(string name, string typed) {
        int s=0,d=0,i=0,j=0,len1=0,len2=0;
        while(i<name.size() && j<typed.size()){
            if(name[i]!=typed[j]){
                return false;
            }
            while(i<name.size() && name[s]==name[i]) i++;
            while(j<typed.size() && typed[d]==typed[j]) j++;

            len1=i-s;
            len2=j-d;
            if(len1>len2){
                return false;
            }
            s=i;
            d=j;
        }
        len1=name.size()-i;
        len2=typed.size()-j;
        if(len1>len2){
            return false;
        }
        return true;
    }
};

//the speed is kind low

class Solution {
public:
    string defangIPaddr(string address) {
        string::size_type i=0;
        while((i=address.find_first_of('.',i))!=string::npos){
            address.replace(i,1,"[.]");
            i+=3;
        }
        return address;
    }
};

class Solution {
public:
    cn.example.string defangIPaddr(cn.example.string address) {
        cn.example.string::size_type i=0;
        while((i=address.find_first_of('.',i))!=cn.example.string::npos){
            address.replace(i,1,"[.]");
            i+=3;
        }
        return address;
    }
};

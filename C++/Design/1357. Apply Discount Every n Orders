class Cashier {
public:
    int index=0;
    int n;
    int discount;
    unordered_map<int,int> m;

    Cashier(int n, int discount, vector<int>& products, vector<int>& prices) {
        this->n=n;
        this->discount=discount;

        for(int i=0;i<products.size();i++){
            m[products[i]]=prices[i];
        }
    }
    
    double getBill(vector<int> product, vector<int> amount) {
        index++;
        double res=0;
        for(int i=0;i<product.size();i++){
            res+=m[product[i]]*amount[i];
        }
        if(index%n==0) res-=(discount * res) / 100;
        return res;
    }
};

/**
 * Your Cashier object will be instantiated and called as such:
 * Cashier* obj = new Cashier(n, discount, products, prices);
 * double param_1 = obj->getBill(product,amount);
 */

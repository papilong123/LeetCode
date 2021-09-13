#include <vector>
#include <string>
#include <cmath>

using namespace std;

class Solution {
public:
    double angleClock(int hour, int minutes) {

        double angel_1 = hour==12?minutes*1.0/2:hour*30+minutes*1.0/2;
        double angel_2 = minutes*1.0*6;

        return min(abs(angel_1-angel_2),360-abs(angel_1-angel_2));
    }
};

//纯数学
// x时y分的夹角为：5.5y-30x , 当夹角大于180度的时候，用360减一下就行了
double angleClock(int hour, int minutes) {
    double a = abs(5.5 * minutes - 30 * hour);
    if(a > 180) {
        return 360 - a;
    }
    return a;
}

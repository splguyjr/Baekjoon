#include <iostream>
using namespace std;

int d[1001] = {1,1};

int main() {
    int a;
    cin >> a;
    
    for (int i=2; i <= a; ++i) {
        d[i] = (d[i-1]+ d[i-2])%10007;
    }
    
    cout << ((d[a])%10007);
}
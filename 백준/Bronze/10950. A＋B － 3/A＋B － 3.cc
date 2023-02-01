#include <iostream>

using namespace std;

int main() {
    int T;
    cin>>T;
    while(T>0) {
        int a,b;
        cin >> a>>b;
        cout << a+b<<endl;
        T = T-1;
    }
}
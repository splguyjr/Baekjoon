#include <iostream>

using namespace std;

int main() {
    int a,b;
    cout.fixed;
    cout.precision(10);
    cin >> a >>b;
    cout << double(a)/double(b);
    
}
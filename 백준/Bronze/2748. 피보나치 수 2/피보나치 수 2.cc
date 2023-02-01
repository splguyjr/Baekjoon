#include <iostream>
using namespace std;

int main() {
int n;
cin >> n;
long long int a[n+1]={0,1};

for(int i=2; i<=n; i++) {
a[i] = a[i-1] + a[i-2];
}
cout << a[n];

}
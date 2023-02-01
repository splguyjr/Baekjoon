#include <iostream>

using namespace std;

int ans0 = 0;
int ans1 = 0;
int dp0[41] = { 1,0 };
int dp1[41] = { 0,1 };


void fibonacci(int n) {
    for (int i = 2; i <= n; i++) { 
        dp0[i] = dp0[i - 1] + dp0[i - 2]; 
        dp1[i] = dp1[i - 1] + dp1[i - 2];
    }

}


int main() {
    int t,temp;
    cin >> t;
    while (t--) {
        cin >> temp;
        fibonacci(temp);
        cout << dp0[temp] << " " << dp1[temp] << '\n';
       
    }


	return 0;
}
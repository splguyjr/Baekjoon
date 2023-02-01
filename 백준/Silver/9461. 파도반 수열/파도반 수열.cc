#include <iostream>

using namespace std;

int n;
long long dp[101]={0,1,1,1,2,2};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int T;
    cin >> T;
    
    for(int j=0; j<T; j++) {
        cin >> n;
        if(n <6) cout << dp[n]<<endl;
     else {
    for (int i = 6; i <= n; i++) {
        dp[i] = dp[i-1] +dp[i-5];
}
    cout << dp[n] <<endl;
        }
        }
}
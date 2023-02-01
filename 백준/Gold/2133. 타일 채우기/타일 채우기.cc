#include <iostream>
using namespace std;

int main() {



int n;
cin >> n;
    int dp[31] = {1,0,3};
    for(int i = 4; i<=n; i = i+2) {
        dp[i] = dp[i-2] * dp[2];
        
 for(int j = i-4; j>=0; j = j-2) {
        dp[i] += dp[j] * 2;//예외모형에 대한 부분
    }
    	
    }
   
    cout <<dp[n];
}

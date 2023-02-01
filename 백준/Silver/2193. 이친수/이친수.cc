#include <iostream>

using namespace std;

int main() {
	int n;
	cin >> n;
	long int dp[91] = {0,1,1,2};
	for(int i = 4; i <= n; i++) {
		dp[i] = dp[i-1] + dp[i-2];
	}
	cout << dp[n];
	
	return 0;
}
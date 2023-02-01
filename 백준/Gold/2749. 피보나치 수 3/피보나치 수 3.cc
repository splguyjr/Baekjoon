#include <iostream>

using namespace std;

unsigned long long n;
int m = 1000000;
int dp[1500001];
int idx;

int main() {

	cin >> n;
	dp[0] = 0;
	dp[1] = 1;

	if (n > 1500000) {
		for (int i = 2; i <= 1500000; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2])%m;
		}
		
		idx = n % 1500000;
	}

	else {
		for (int i = 2; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % m;
		}
		idx = n;
	}
	
	cout << dp[idx];


	return 0;
}
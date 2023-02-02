#include <iostream>

using namespace std;

int dp[1000001];
int n;
int ans;

int main() {
	cin >> n;
	
	int temp;
	for (int i =1; i<=n; i++) {
		cin >> temp;
		dp[temp] = dp[temp - 1] + 1;
		
		ans = max(ans, dp[temp]);
	}

	cout << n - ans;

	return 0;
}
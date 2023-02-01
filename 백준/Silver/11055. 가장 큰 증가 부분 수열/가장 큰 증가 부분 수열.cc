#include <iostream>

using namespace std;

int a[1001];
int dp[1001];
int n, k;
int ans;

int main() {
	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> a[i];
	}

	for (int i = 1; i <= n; i++) {
		dp[i] = a[i];
		for (int j = 1; j < i; j++) {
			if (a[i] > a[j]) {
				dp[i] = max(dp[i], dp[j] + a[i]);
			}
			
		}
		ans = max(ans, dp[i]);
	}

	
	cout << ans;
	return 0;
}
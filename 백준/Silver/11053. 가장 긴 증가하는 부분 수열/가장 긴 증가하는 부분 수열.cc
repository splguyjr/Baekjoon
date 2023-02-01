#include <iostream>
#include <algorithm>
using namespace std;

int n;
int a[1001];
int dp[1001];
int ans = 0;

int main() {
	cin >> n;

	for (int i = 1; i <= n; i++) {
		cin >> a[i];
	}
	
	for (int i = 1; i <= n; i++) {
		dp[i] = 1;
		for (int j = 1; j < i; j++) {
			if (a[i] > a[j]) {
				dp[i] = max(dp[i], dp[j] + 1);
			}
		}
		ans = max(dp[i], ans);
	}

	cout << ans;

	return 0;
}
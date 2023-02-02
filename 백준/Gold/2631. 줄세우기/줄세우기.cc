#include <iostream>

using namespace std;

int arr[1000001];
int dp[1000001];
int n;
int ans;
int main() {
	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> arr[i];
		dp[i] = 1;
	}

	for (int i = 2; i <= n; i++) {
		for (int j = 1; j < i; j++) {
			if (arr[i] > arr[j]) {
				dp[i] = max(dp[i], dp[j] + 1);
			}
		}
		ans = max(ans, dp[i]);
	}

	cout << n - ans;

	return 0;
}
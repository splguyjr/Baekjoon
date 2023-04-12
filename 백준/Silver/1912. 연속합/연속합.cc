#include <iostream>

using namespace std;

int n;
int arr[100001];
int dp[100001];
int ans = -1000;

int main() {
	cin >> n;

	if (n == 1) {
		cin >> arr[1];
		cout << arr[1];
		return 0;
	}

	for (int i = 1; i <= n; i++) {
		cin >> arr[i];
	}

	for (int i = 1; i <= n; i++) {
		dp[i] = max(dp[i - 1] + arr[i], arr[i]);
		ans = max(dp[i], ans);
	}

	cout << ans;


	return 0;
}
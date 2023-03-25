#include <iostream>
#include <algorithm>

using namespace std;

int n;
int dp[10001];
int arr[10001];

int main() {
	cin >> n;

	for (int i = 1; i <= n; i++) {
		cin >> arr[i];
	}

	dp[0] = 0;
	dp[1] = arr[1];
	dp[2] = arr[1] + arr[2];

	for (int i = 3; i <= n; i++) {
		int a = dp[i - 3] + arr[i - 1] + arr[i];
		int b = dp[i - 2] + arr[i];
		int c = dp[i - 1];

		dp[i] = max({ a,b,c });
	}

	cout << dp[n];

}
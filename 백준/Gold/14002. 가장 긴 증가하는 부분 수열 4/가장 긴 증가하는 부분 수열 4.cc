#include <iostream>
#include <algorithm>
#include <stack>

using namespace std;

int n;
int dp[1003];
int arr[1003];
int record[1003];
int ans = 0;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n;

	
	for (int i = 1; i <= n; i++) {
		cin >> arr[i];
	}

	if (n == 1) {
		cout << 1 << '\n';
		cout << arr[1];
		return 0;
	}

	int mx_idx = 1;

	for (int i = 1; i <= n; i++) {
		dp[i] = 1;
		for (int j = 1; j < i; j++) {
			if (arr[j] < arr[i]) {
				if (dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
					record[i] = j;
				}
			}
			if (ans < dp[i]) {
			ans = max(ans, dp[i]);
			mx_idx = i;
			}
		}
	}

	cout << ans << '\n';
	stack<int> s;

	for (int i = 0; i < ans; i++) {
		s.push(arr[mx_idx]);
		mx_idx = record[mx_idx];
	}

	while (!s.empty()) {
		cout << s.top() << " ";
		s.pop();
	}


	return 0;
}
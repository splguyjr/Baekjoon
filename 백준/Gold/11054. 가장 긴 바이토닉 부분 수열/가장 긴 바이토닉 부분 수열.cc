#include <iostream>
#include <algorithm>

using namespace std;

int a[1001];
int up[1001];
int down[1001];
int dp[1001];
int n;
int ans = 1;

int main() {
	cin >> n;

	for (int i = 1; i <= n; i++) {
		cin >> a[i];
	}

	for (int i = 1; i <= n; i++) {
		up[i] = 1;
		for (int j = 1; j <= i; j++) {
			if (a[i] > a[j]) {
				up[i] = max(up[j] + 1, up[i]);
			}
		}
		

	}

	for (int i = n; i >=1 ; i--) {
		down[i] = 1;
		for (int k = n; k >= i; k--) {
			if (a[i] > a[k]) {
				down[i] = max(down[k] + 1, down[i]);
			}
		}
	}

	for (int i = 1; i <= n; i++) {
		ans = max(ans, up[i] + down[i] - 1);
	}

	cout << ans;
	return 0;
}

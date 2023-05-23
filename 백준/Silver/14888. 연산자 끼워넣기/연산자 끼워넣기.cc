#include <iostream>

using namespace std;

int n;
int arr[11];
int a, b, c, d;
int ans1 = -1e9;
int ans2 = 1e9;

void dfs(int a,int b, int c, int d,int idx, int sum) {
	if (idx == n) {
		ans1 = max(ans1, sum);
		ans2 = min(ans2, sum);
		return;
	}
	
	if (a > 0) {
		dfs(a - 1, b, c, d, idx + 1, sum + arr[idx]);
	}

	if (b > 0) {
		dfs(a, b - 1, c, d, idx + 1, sum - arr[idx]);
	}

	if (c > 0) {
		dfs(a, b, c - 1, d, idx + 1, sum * arr[idx]);
	}

	if (d > 0) {
		dfs(a, b, c, d - 1, idx + 1, sum / arr[idx]);
	}
}

int main() {
	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}

	cin >> a >> b >> c >> d;

	dfs(a, b, c, d, 1, arr[0]);

	cout << ans1 << '\n' << ans2;

	return 0;
}
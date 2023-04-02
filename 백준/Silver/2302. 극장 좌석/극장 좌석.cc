#include <iostream>
#include <vector>

using namespace std;

int n, m;
vector<int> vip;
int dp[41] = { 1,1 };
int ans = 1;

int main() {
	cin >> n >> m;

	for (int i = 2; i <= n; i++) {
		dp[i] = dp[i - 1] + dp[i - 2];
	}

	int tmp;
	vip.push_back(0);
	for (int i = 0; i < m; i++) {
		cin >> tmp;
		vip.push_back(tmp);
	}
	vip.push_back(n + 1);

	for (int i = 1; i < vip.size(); i++) {
		int len = vip[i] - vip[i - 1] -1;
		ans *= dp[len];
	}

	cout << ans;

	return 0;
}
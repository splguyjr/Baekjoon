#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;

int n, m;
int open_order[21];
int dp[21][21][21];

int dfs(int cnt, int op1, int op2) {
	if (cnt > m) return 0;

	int& res = dp[cnt][op1][op2];
	if (res != -1) return res;

	res = min(abs(open_order[cnt] - op1) + dfs(cnt + 1, open_order[cnt], op2),
		abs(open_order[cnt] - op2) + dfs(cnt + 1, op1, open_order[cnt]));

	return res;
}


int main() {
	cin >> n;

	int o1, o2;
	cin >> o1 >> o2;

	cin >> m;

	for (int i = 1; i <= m; i++) {
		cin >> open_order[i];
	}

	memset(dp, -1, sizeof(dp));
	cout << dfs(1, o1, o2);

	
	return 0;
}
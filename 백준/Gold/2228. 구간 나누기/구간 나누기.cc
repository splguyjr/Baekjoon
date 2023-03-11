#include <iostream>
#include <algorithm>
#include <cstring>

#define INF 32768000
using namespace std;

int n, m;
int arr[101];
int dp[101][51];
int sum[101][101];

int dfs(int a, int b) {
	if (b == m) return 0;
	if (a >= n) return -INF;
	int& ret = dp[a][b];
	if (ret) return ret;
	
	ret = dfs(a + 1, b);
	for (int i = a; i < n; i++) {
		ret = max(ret, sum[a][i] + dfs(i + 2, b + 1));
	}
	return ret;
}

int main() {
	cin >> n >> m;

	//memset(dp, -1, sizeof(dp));

	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}

	for (int i = 0; i < n; i++) {
		int x = 0;
		for (int j = i; j < n; j++) {
			x += arr[j];
			sum[i][j] = x;
		}
	}

	cout << dfs(0, 0);

	



	return 0;
}
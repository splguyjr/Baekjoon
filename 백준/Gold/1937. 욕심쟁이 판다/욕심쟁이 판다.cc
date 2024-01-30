#include <iostream>
#include <algorithm>

using namespace std;

int n;
int dx[4] = { -1,0,0,1 };
int dy[4] = { 0,1,-1,0 };
int forest[501][501];
int dp[501][501];
int ans;

int dfs(int x, int y) {
	if (dp[x][y]) return dp[x][y];
	dp[x][y] = 1;

	
	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];

		if (nx < 0 || ny < 0 || nx >= n || ny >= n)
			continue;
		
		if(forest[nx][ny] > forest[x][y]) {
			dp[x][y] = max(dp[x][y], dfs(nx, ny) + 1);
		}
		
	}

	return dp[x][y];
}



int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> forest[i][j];
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			ans = max(ans, dfs(i, j));
		}
	}

	cout << ans;

	return 0;
}
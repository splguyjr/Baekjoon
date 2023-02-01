#include <iostream>
#include <algorithm>
using namespace std;

int m, n;

int height[505][505];
int dp[505][505];
int dx[] = { 0, 0, 1, -1 };
int dy[] = { 1, -1, 0, 0 };

int dfs(int x, int y) {
	if (x == m - 1 && y == n - 1) return 1;
	if (dp[x][y] != -1) return dp[x][y];

	dp[x][y] = 0;

	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
 		int ny = y + dy[i];
		if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
			if (height[nx][ny] < height[x][y])
				dp[x][y] += dfs(nx, ny);
		}
	}

	return dp[x][y];
}


int main() {
	cin >> m >> n;

	for (int i = 0; i < m; i++)
		for (int j = 0; j < n; j++) {
			cin >> height[i][j];
			dp[i][j] = -1;
		}

	dfs(0, 0);
	cout << dp[0][0] << endl;



	return 0;
}
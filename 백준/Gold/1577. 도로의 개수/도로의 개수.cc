#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;

int n, m, k;
int dy[2] = { 1,0 }, dx[2] = { 0,1 };
long long dp[101][101];
int map[101][101][2];

long long dfs(int y, int x) {
	if (y == n && x == m) return 1;
	long long& ret = dp[y][x];
	if (ret != -1) return ret;
	ret = 0;
	for (int i = 0; i < 2; i++) {
		if (!map[y][x][i]) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny <= n && nx <= m) {
				ret += dfs(ny, nx);
			}
		}
	}
	return ret;
}


int main() {

	cin >> n >> m >> k;

	int x1, y1, x2, y2;

	while (k--) {
		cin >> x1 >> y1 >> x2 >> y2;
		if (x1 > x2)  swap(x1, x2);
		else if (y1 > y2) swap(y1, y2);
		if (x1 < x2) {
			map[x1][y1][0] = 1;
		}
		else {
			map[x1][y1][1] = 1;
		}
	}

	memset(dp, -1, sizeof(dp));
	cout << dfs(0, 0);

	return 0;
}

//https://leesh111112.tistory.com/126 참고
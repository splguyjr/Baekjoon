#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

int map[1001][1001];
int dx[4] = { -1, 1, 0, 0 };
int dy[4] = { 0, 0, 1, -1 };
int m, n;
int ans = -1;
queue<pair<int, int>> q;

void bfs() {
	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] == 0) {
				q.push({ nx, ny });
				map[nx][ny] = map[x][y] + 1;
			}
		}
	}
}

int main() {
	cin >> m >> n;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> map[i][j];
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (map[i][j] == 1) q.push({ i,j });
		}
	}

	bfs();

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (map[i][j] == 0) {
				cout << -1;
				return 0;
			}
			else {
				ans = max(ans, map[i][j]);
			}
		}
	}
	
	cout << ans - 1;

	return 0;
}
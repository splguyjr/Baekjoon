#include <iostream>
#include <queue>
#include <cstring>

using namespace std;

int n;
bool visited[101][101];
int dx[4] = { -1,0,0,1 };
int dy[4] = { 0,1,-1,0 };
char arr[101][101];
int ans = 0;
int ansr = 0;

void bfs(int a, int b) {
	queue<pair<int, int>> q;
	q.push({ a,b });
	visited[a][b] = true;

	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

			if (!visited[nx][ny]) {
				if (arr[x][y] == arr[nx][ny]) {
					visited[nx][ny] = true;
					q.push({ nx,ny });
				}
			}
		}
	}
}

int main() {
	cin >> n;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> arr[i][j];
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (!visited[i][j]) {
				bfs(i, j);
				ans++;
			}
		}
	}

	memset(visited, 0, sizeof(visited));

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (arr[i][j] == 'G') {
				arr[i][j] = 'R';
			}
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (!visited[i][j]) {
				bfs(i, j);
				ansr++;
			}
		}
	}
	cout << ans << ' '<< ansr;

	return 0;
}
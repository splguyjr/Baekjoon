#include <iostream>
#include <vector>
#include <queue>

using namespace std;

bool visited[101][101];
char map[101][101];
int check[101][101];

int n, m;
pair<int, int> d[4] = { {1,0},{0,1},{-1,0},{0,-1} };
int mn = 10001;
queue<pair<int, int>> q;

void bfs() {
	
	while(!q.empty()) {

		int x = q.front().first;
		int y = q.front().second;
		visited[x][y] = true;
		q.pop();
	for (int i = 0; i < 4; i++) {
		int nx = x + d[i].first;
		int ny = y + d[i].second;
		if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

		if (map[nx][ny] == '1' && !visited[nx][ny]) {
			q.push({ nx, ny });
			visited[nx][ny] = true;
			check[nx][ny] = check[x][y] + 1;
		}
	}

	}
}

int main() {
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> map[i];
	}

	q.push({ 0,0 });
	bfs();
	cout << check[n - 1][m - 1]+1;

	return 0;
}
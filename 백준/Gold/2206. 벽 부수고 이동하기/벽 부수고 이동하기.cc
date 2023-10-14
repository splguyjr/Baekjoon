#include <iostream>
#include <vector>
#include <queue>


using namespace std;

int dx[4] = { -1,0,0,1 };
int dy[4] = { 0,1,-1,0 };
int map[1001][1001][2];
int n, m;
queue<pair<pair<int, int>, int>> q;

int bfs() {
	
	while(!q.empty()) {

		int broken = q.front().second;
		int x = q.front().first.first;
		int y = q.front().first.second;

		q.pop();
		
		if (x == n - 1 && y == m - 1) {
			return map[n - 1][m - 1][broken] + 1;
		}
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

			if (map[nx][ny][0] == 1) {
				if (!broken) {//아직 깬적이 없으면
					q.push({ {nx, ny}, 1 });
					map[nx][ny][broken + 1] = map[x][y][broken] + 1;
				}
			}

			else if (map[nx][ny][0] == 0) {				
				//이미 깼는데 이미 방문한경우 이미 최단거리값이 저장되어있으므로 continue
				if (broken == 1 && map[nx][ny][broken]) continue;
				//깬적이 없거나, 깼지만 처음 방문하는 경우에는 이전위치까지 이동거리 +1
				map[nx][ny][broken] = map[x][y][broken] + 1;
				q.push({ {nx,ny}, broken });
			}

			//이미 방문한 map[nx][ny][0]의 경우 값이 2이상이므로 걸러짐
		}
	}

	return -1;
}

int main() {
	cin >> n >> m;
	
	char temp;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> temp;
			map[i][j][0] = temp - '0';
		}
	}

	q.push({ { 0,0 }, 0 });

	cout << bfs();

	return 0;
}
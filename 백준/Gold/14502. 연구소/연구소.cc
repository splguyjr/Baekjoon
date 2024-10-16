#include <iostream>
#include <queue>
#include <cstring>

using namespace std;

int n, m;
int map[9][9];
int map2[9][9];
bool visited[9][9] = { false };
int dx[4] = { -1, 0, 0, 1 };
int dy[4] = { 0, -1, 1, 0 };
int cnt = 3, ans = 0;

void insert() {
	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> map[i][j];
		}
	}
}

void bfs() {
	//map2에 원본 map 내용 복사, 바이러스가 퍼지면서 수정된 배열 복구
	//memcpy(map2, map, sizeof(map));
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			map2[i][j] = map[i][j];
		}
	}

	queue<pair<int, int>> q;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (map2[i][j] == 2) {
				q.push({ i, j });

				while (!q.empty()) {
					int x = q.front().first;
					int y = q.front().second;
					q.pop();

					for (int i = 0; i < 4; i++) {
						int nx = x + dx[i];
						int ny = y + dy[i];

						if(nx >=0 && ny >=00 && nx < n && ny < m) {
							if (map2[nx][ny] == 0) {
								q.push({ nx, ny });
								map2[nx][ny] = 2;
							}
						}
					}
				}

			}
		}
	}

	int temp = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (map2[i][j] == 0) {
				temp++;
			}
		}
	}

	if (temp > ans)
		ans = temp;
}

void search() {
	if (cnt == 0)
		return bfs();

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (map[i][j] == 0) {
				cnt--;
				map[i][j] = 1;
				search();
				map[i][j] = 0;
				cnt++;
			}
		}
	}

}

int main() {
	
	insert();
	search();

	cout << ans;

	return 0;
}
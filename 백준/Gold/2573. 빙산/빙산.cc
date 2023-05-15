#include <iostream>
#include <queue>
#include <cstring>

using namespace std;

int dx[4] = { -1,0,0,1 };
int dy[4] = { 0,1,-1,0 };
int n, m;
int arr[301][301];
int temp[301][301];
bool visited[301][301];



void melt() {
	memset(temp, 0, sizeof(temp));

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (arr[i][j] == 0) continue;
			int cnt = 0;
			for (int k = 0; k < 4; k++) {
				int nx = i + dx[k];
				int ny = j + dy[k];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
				if (arr[nx][ny] == 0) {
					cnt++;
				}
			}
			int tmp = arr[i][j] - cnt;
			if (tmp > 0) temp[i][j] = tmp;
			//tmp가 0이하인 경우 temp[i][j]값은 0
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			arr[i][j] = temp[i][j];
		}
	}
}

void bfs_check(int a, int b) {
	queue<pair<int, int>> q;
	q.push({ a,b });

	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
			
			if (arr[nx][ny] != 0 && !visited[nx][ny]) {
				q.push({ nx,ny });
				visited[nx][ny] = true;
			}
		}
	}
}


int main() {
	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> arr[i][j];
		}
	}

	int year = 0;

	while (1) {
		int ice_num = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && arr[i][j] != 0) {
					bfs_check(i, j);
					ice_num++;
				}
			}
		}

		if (ice_num >= 2) {
			cout << year;
			break;
		}

		else if (ice_num == 0) {
			cout << 0;
			break;
		}

		//아니면 한 덩어리이므로 1년의 시간이 또 흐름
		year++;
		melt();
		memset(visited, false, sizeof(visited));

	}

	return 0;
}
#include <iostream>
#include <vector>
#include <queue>
#include <cmath>

using namespace std;


bool visited[101][101];
char map[101][101];

int n, m;
int total_w = 0;
int total_b = 0;
int dx[] = { -1, 0, 0, 1 };
int dy[] = { 0, -1, 1, 0 };


int check = 0;

int bfs_w(pair<int, int> p) {
	queue<pair<int, int>> q;
	int count_w = 0;
	q.push(p);


	count_w++;
	visited[p.first][p.second] = true;


	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		for (int i = 0; i < 4; ++i) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (map[nx][ny] == 'W' && !visited[nx][ny] && nx >= 0 && ny >= 0 && nx < m && ny < n) {

				visited[nx][ny] = true;
				q.push({ nx, ny });
				count_w++;
	

			}

		}



	}
	//cout << pow(count_w, 2) << endl;
	return pow(count_w, 2);
}

int bfs_b(pair<int, int> p) {
	queue<pair<int, int>> q;
	int count_b = 0;

	q.push(p);


	count_b++;
	visited[p.first][p.second] = true;

	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		for (int i = 0; i < 4; ++i) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (map[nx][ny] == 'B' && !visited[nx][ny]  && nx >= 0 && ny >= 0 && nx < m && ny < n) {
				visited[nx][ny] = true;
				q.push({ nx, ny });
				count_b++;
			}

		}


	}
	//	cout << pow(count_b, 2) << endl;
	return pow(count_b, 2);
}

int main() {
	cin >> n >> m;

	char t;
	for (int i = 0; i < m; ++i) {
		for (int j = 0; j < n; ++j) {
			cin >> map[i][j];
		}
	}

	for (int i = 0; i < m; ++i) {
		for (int j = 0; j < n; ++j) {
			if (!visited[i][j]) {
				if (map[i][j] == 'W') {
					total_w += bfs_w({ i,j });
				
				}
				else {
					total_b += bfs_b({ i,j });
				
				}
			}
		}
	}

	cout << total_w << ' ' << total_b;
	return 0;

}
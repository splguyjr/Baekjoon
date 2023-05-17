#include <iostream>
#include <queue>
#include <string>
#include <cstring>


using namespace std;

int n, m;
int dx[4] = { -1,0,0,1 };
int dy[4] = { 0,1,-1,0 };

string arr[1001];

int fire[1001][1001];
int escape[1001][1001];

queue<pair<int, int>> q1;
queue<pair<int, int>> q2;

void bfs1() {

	while (!q1.empty()) {
		int x = q1.front().first;
		int y = q1.front().second;
		q1.pop();

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
			if (fire[nx][ny] >= 0 || arr[nx][ny] == '#') continue;
			fire[nx][ny] = fire[x][y] + 1;
			q1.push({ nx,ny });
			
		}
	}
}

void bfs2() {

	while (!q2.empty()) {
		int x = q2.front().first;
		int y = q2.front().second;
		q2.pop();

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
				cout << escape[x][y] + 1;
				return;
			}
			if (escape[nx][ny] >= 0 || arr[nx][ny] == '#') continue;
			if (fire[nx][ny] != -1 && fire[nx][ny] <= escape[x][y] + 1) continue;//불과 겹치지 않게 하는 조건
			escape[nx][ny] = escape[x][y] + 1;
			q2.push({ nx,ny });

		}
	}
	cout << "IMPOSSIBLE";
}


int main() {
	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}

	memset(fire, -1, sizeof(fire));
	memset(escape, -1, sizeof(escape));

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (arr[i][j] == 'F') {
				q1.push({ i,j });
				fire[i][j] = 0;
			}
			if (arr[i][j] == 'J') {
				q2.push({ i,j });
				escape[i][j] = 0;
			}
		}
	}

	bfs1();
	bfs2();


	return 0;
}

//https://velog.io/@rhkswls98/%EB%B0%B1%EC%A4%80-4179-C-%EB%B6%88 참고
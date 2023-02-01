#include <iostream>
#include <queue>
#include <vector>
#include <cstring>
#include <tuple>

#define MAX 50

using namespace std;

int n, m, ans;
int graph[MAX][MAX];
bool visited[MAX][MAX];
vector<pair<int, int>> v;

int dx[] = { -1, -1, -1, 0, 0 ,1,1 ,1 };
int dy[] = { -1, 0, 1, -1, 1, -1, 0 , 1 };

int bfs(int a, int b) {
	queue<tuple<int, int, int>> q;
	q.push({ a,b,0 });
	visited[a][b] = true;

	while (!q.empty()) {
		int x = get<0>(q.front());
		int y = get<1>(q.front());
		int cnt = get<2>(q.front());
		q.pop();

		if (graph[x][y] == 1) { return cnt; }

		for (int i = 0; i < 8; ++i) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
				if (!visited[nx][ny]) {
					visited[nx][ny] = true;
					q.push({ nx,ny,cnt + 1 });
				}
			}
		}

	}
}


int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	cin >> n >> m;

	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < m; ++j) {
			cin >> graph[i][j];
			
			if (graph[i][j] == 0) {
				v.push_back({ i,j });
			}
		
		}
	}

	for (int i = 0; i < v.size(); ++i) {
		memset(visited, false, sizeof(visited));
		int x = v[i].first;
		int y = v[i].second;

		int temp = bfs(x, y);
		if (temp > ans) ans = temp;
		
	}


	cout << ans;


	return 0;
}
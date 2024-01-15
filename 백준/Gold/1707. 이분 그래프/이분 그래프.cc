#include <iostream>
#include <queue>
#include <cstring>

using namespace std;

int k, v, e;
vector<int> graph[20001];//연결된 간선 정보를 저장하는 벡터
int visited[20001];//1이면 red, 2이면 blue

void bfs(int idx) {
	queue<int> q;
	q.push(idx);
	visited[idx] = 1;//시작점을 red로

	while (!q.empty()) {
		int x = q.front();
		q.pop();

		for (int i = 0; i < graph[x].size(); i++) {
			int nx = graph[x][i];

			if(!visited[nx]) {
				if (visited[x] == 1) {
					visited[nx] = 2;
				}

				else if (visited[x] == 2) {
					visited[nx] = 1;
				}

				q.push(nx);
			}
		}
	}
}

bool check() {
	for (int i = 1; i <= v; i++) {
		for (int j = 0; j < graph[i].size(); j++) {
			if (visited[i] == visited[graph[i][j]])
				return false;
		}
	}
	return true;
}

int main() {
	cin >> k;
	while (k--) {
		cin >> v >> e;
		int a, b;

		while (e--) {
			cin >> a >> b;
			graph[a].push_back(b);
			graph[b].push_back(a);
		}

		for (int i = 1; i <= v; i++) {
			if (!visited[i])
				bfs(i);
		}

		if (check()) 
			cout << "YES" << '\n';
		else 
			cout << "NO" << '\n';

		memset(graph, 0, sizeof(graph));
		memset(visited, 0, sizeof(visited));
	}

	return 0;
}
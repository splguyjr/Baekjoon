#include <iostream>
#include <vector>

using namespace std;

int n, m, u, v;
int graph[1001][1001];
int visited[1001];
int cnt = 0;

void dfs(int x) {
	visited[x] = 1;

	for (int i = 1; i <= n; i++) {
		if (graph[x][i] == 1 && !visited[i]) {
			dfs(i);
		}
	}
	
	return;
}

int main() {
	cin >> n >> m;

	while (m--) {
		cin >> u >> v;
		graph[u][v] = 1;
		graph[v][u] = 1;
	}

	for (int i = 1; i <= n; i++) {
		if (visited[i] == 0)
		{
			cnt++;
			dfs(i);
			
		}
	}

	cout << cnt;


	return 0;
}
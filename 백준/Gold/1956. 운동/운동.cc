#include <iostream>
#include <algorithm>

#define INF 987654321

using namespace std;

int graph[401][401];
int v, e;

void floyd() {
	for (int k = 1; k <= v; k++) {
		for (int i = 1; i <= v; i++) {
			for (int j = 1; j <= v; j++) {
				graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j]);
			}
		}
	}
}

int main() {
	ios::sync_with_stdio();
	cin.tie(0);

	cin >> v >> e;
	
	for (int i = 1; i <= v; i++) {
		for (int j = 1; j <= v; j++) {
			graph[i][j] = INF;
		}
	}

	int a, b, c;
	for (int i = 0; i < e; i++) {
		cin >> a >> b >> c;
		graph[a][b] = c;
	}

	floyd();

	int ans = INF;
	
	for (int i = 1; i <= v; i++) {
		if (graph[i][i] != INF) {
			ans = min(ans, graph[i][i]);
		}
	}

	if (ans == INF) cout << -1;
	else cout << ans;

	return 0;
}
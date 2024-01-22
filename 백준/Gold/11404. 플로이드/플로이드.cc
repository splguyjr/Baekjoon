#include <iostream>
#include <algorithm>

using namespace std;

const int INF = 10000001;
int n, m, start, dest;
int graph[101][101];

void floyd() {
	for (int k = 1; k <= n; k++) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
					graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j]);
			}
		}
	}
}

int main() {
	cin >> n >> m;

	for (int i = 1; i <= n; ++i) {
		for (int j = 1; j <= n; ++j) {
			graph[i][j] = (i == j ? 0 : INF);
		}
	}
	int temp;;
	for (int i = 0; i < m; ++i) {
		cin >> start >> dest;
		cin >> temp;
		graph[start][dest] = min(temp, graph[start][dest]);
	}

	floyd();

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			if (graph[i][j] == INF) { cout << 0 << ' '; 
			continue;
			}
			cout << graph[i][j] << ' ';
		}
		cout << '\n';
	}

	return 0;
}
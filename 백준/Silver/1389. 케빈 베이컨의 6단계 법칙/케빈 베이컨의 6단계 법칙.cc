#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
#include <algorithm>

using namespace std;

const int INF = 987654321;
int n, m;
int dist[101][101];
int a, b;


int main() {
	cin >> n >> m;

	for (int i = 0; i < m; i++) {
		cin >> a >> b;
		dist[a][b] = 1;
		dist[b][a] = 1;
	}

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			if (i != j && !dist[i][j]) dist[i][j] = INF;
		}
	}

	for (int k = 1; k <= n; k++) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]);
			}
		}
	}

	int check = INF;
	int ans = 0;

	for (int i = 1; i <= n; i++) {
		int temp = 0;
		for (int j = 1; j <= n; j++) {
			temp += dist[i][j];
		}
		if (temp < check) {
			check = temp;
			ans = i;
		}
	}

	cout << ans;

	return 0;
}
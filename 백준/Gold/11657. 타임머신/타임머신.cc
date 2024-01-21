#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n, m;
vector<pair<int, int>> graph[501];
long long INF = 1e18;
long long dist[501];
bool minuscycle = false;

void bellmanFord(int n) {
	fill(dist + 1, dist + n + 1, INF);//1번부터 n번 정점까지의 거리 INF로 초기화
	dist[1] = 0;//1번 노드를 출발점으로 설정

	for (int i = 0; i < n; i++) {//마지막은 음의 사이클을 판단하기 위함
		for (int j = 1; j <= n; j++) {
			for(auto &x : graph[j]) {
				int next = x.first;
				int cost = x.second;

				if (dist[j] != INF && dist[next] > dist[j] + cost) {
					dist[next] = dist[j] + cost;

					if (i == n-1) {//n번째 사이클에서도 dist에 변화가 일어난다는 것은 음의 사이클이 존재한다는 뜻
						minuscycle = true;
						return;
					}
				}
			}
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n >> m;

	int a, b, c;
	for (int i = 0; i < m; i++) {
		cin >> a >> b >> c;

		graph[a].push_back({ b,c });
	}

	bellmanFord(n);

	if (minuscycle) cout << -1;

	else {
		for (int i = 2; i <= n; i++) {
			if (dist[i] == INF) {
				cout << -1 << '\n';
			}
			else cout << dist[i] << '\n';
		}
	}

	return 0;
}
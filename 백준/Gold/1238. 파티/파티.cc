#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

#define INF 987654321

using namespace std;

int n, m, x;
int st, ed, t;

int dist[2][1001];
vector<pair<int, int>> v[2][1001];


void dijkstra(int dir, int start) {
	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
	dist[dir][start] = 0;
	pq.push({ 0, start });

	while (!pq.empty()) {
		int cur = pq.top().second;
		int cost = pq.top().first;
		pq.pop();

		if (dist[dir][cur] < cost) continue;

		for (int i = 0; i < v[dir][cur].size(); i++) {
			int next = v[dir][cur][i].first;
			int cur_to_next = v[dir][cur][i].second;
			if (dist[dir][next] > cost + cur_to_next) {
				dist[dir][next] = cost + cur_to_next;
				pq.push({ dist[dir][next], next });
			}
		}
	}


}


int main() {
	cin >> n >> m >> x;

	for (int i = 0; i < m; i++) {
		cin >> st >> ed >> t;
		v[0][st].push_back({ ed,t });
		v[1][ed].push_back({ st,t });
	}

	for (int i = 0; i <= n; i++) {
		dist[0][i] = INF;
		dist[1][i] = INF;
	}

	dijkstra(0, x);
	dijkstra(1, x);

	int ans = -1;

	for (int i = 1; i <= n; i++) {
		ans = max(ans, dist[0][i] + dist[1][i]);
	}

	cout << ans;




	return 0;
}
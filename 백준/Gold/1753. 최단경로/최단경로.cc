#include <iostream>
#include <vector>
#include <queue>
#include <cstring>

#define INF 987654321

using namespace std;

int v, e, k;
int x, y, d;

vector<pair<int, int>> vec[20001];
priority_queue<pair<int, int>> pq;
int dist[20001];

void dijstra(int x) {
	dist[x] = 0;

	pq.push({ 0, x });

	while (!pq.empty()) {
		int cur = pq.top().second;
		int start_cur_dist = -pq.top().first;

		pq.pop();

		if (dist[cur] < start_cur_dist) continue;

		for (int i = 0; i < vec[cur].size(); i++) {
			int next = vec[cur][i].second;
			int start_next_dist = vec[cur][i].first + start_cur_dist;
			if(dist[next]>start_next_dist) {
				dist[next] = start_next_dist;
				pq.push({ -start_next_dist, next });
			}
		}
	}
}

int main() {
	cin >> v >> e;
	cin >> k;


	for (int i = 1; i < v + 1; ++i) {
		dist[i] = INF;
	}

	for (int i = 0; i < e; i++) {
		cin >> x >> y >> d;
		vec[x].push_back({ d,y });
	}

	dijstra(k);

	for (int i = 1; i <= v; i++) {
		if (dist[i] == INF) {
			cout << "INF" << '\n';
			continue;
		}
		cout << dist[i] << '\n';
	}


	return 0;
}
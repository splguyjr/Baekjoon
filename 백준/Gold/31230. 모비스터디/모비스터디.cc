#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

#define INF 2e16

typedef long long ll;

using namespace std;

int n, m, a, b;
vector<pair<int,ll>> v[200001];
priority_queue<pair<ll, int>, vector<pair<ll, int>>, greater<pair<ll, int>>> pq;
ll dist[200001];
ll dist2[200001];

void dijstra(int x) {
	fill(dist + 1, dist + n + 1, INF);
	dist[x] = 0;

	pq.push({ 0,x });

	while (!pq.empty()) {
		ll st_cur_dist = pq.top().first;
		int cur = pq.top().second;

		pq.pop();

		if (dist[cur] < st_cur_dist) continue;

		for (auto e : v[cur]) {
			int next = e.first;
			ll start_next_dist = e.second + st_cur_dist;

			if (dist[next] > start_next_dist) {
				dist[next] = start_next_dist;
				pq.push({ start_next_dist, next });
			}
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n >> m >> a >> b;

	int x, y, dis;
	for (int i = 0; i < m; i++) {
		cin >> x >> y >> dis;
		v[x].push_back({ y,dis });
		v[y].push_back({ x,dis });
	}

	dijstra(a);

	for (int i = 1; i <= n; i++) {
		dist2[i] = dist[i];
	}

	dijstra(b);

	vector<int> ans;

	for (int i = 1; i <= n; i++){
		if (dist2[i] + dist[i] == dist[a]) {//b->a로 가는 거리와 a->i + b->i가 같은지 확인
			ans.push_back(i);
		}
	}

	sort(ans.begin(), ans.end());

	cout << ans.size() << '\n';

	for (auto x : ans) {
		cout << x << " ";
	}

	return 0;
}
#include <iostream>
#include <queue>
#include <algorithm>



using namespace std;

int t;
int np, nl, nd;//교차로, 도로, 도착지 수
int st, g, h;//시작점, 거쳐야 하는 두 점
vector<pair<int, int>> graph[2001];
int dist_st[2001];//출발점으로부터의 거리를 담는 배열
int dist_g[2001];
int dist_h[2001];
int INF = 10000000;

void initialize() {
	for (int i = 0; i < 2001; i++) {
		graph[i].clear();
		dist_st[i] = INF;
		dist_g[i] = INF;
		dist_h[i] = INF;
	}
}

void dijk(int x, int dist[2001]) {
	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
	pq.push({ 0, x });
	dist[x] = 0;

	while (!pq.empty()) {

		int cost = pq.top().first;
		int cur = pq.top().second;
		pq.pop();

		for (auto i : graph[cur]) {
			int next = i.first;
			int ncost = i.second;

			if (dist[next] > cost + ncost) {
				dist[next] = cost + ncost;
				pq.push({ dist[next], next});
			}
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> t;

	while (t--) {
		initialize();
		cin >> np >> nl >> nd;
		cin >> st >> g >> h;

		int a, b, d;

		for (int i = 0; i < nl; i++) {
			cin >> a >> b >> d;

			graph[a].push_back({ b, d });
			graph[b].push_back({ a,d });

		}


		int dest;
		vector<int> v;//오름차순으로 정렬하기 위한 벡터


		for (int i = 0; i < nd; i++) {
			cin >> dest;

			dijk(st, dist_st);
			int st_g = dist_st[g];
			int st_h = dist_st[h];
			int st_dest = dist_st[dest];
			
			dijk(g, dist_g);
			int g_h = dist_g[h];
			int g_dest = dist_g[dest];
			
			dijk(h, dist_h);
			int h_dest = dist_h[dest];

			if (st_dest == st_g + g_h + h_dest) v.push_back(dest);
			else if (st_dest == st_h + g_h + g_dest) v.push_back(dest);
		}
		
		sort(v.begin(), v.end());

		for (auto x : v) {
			cout << x << " ";
		}
		cout << '\n';
 
	}

	return 0;
}
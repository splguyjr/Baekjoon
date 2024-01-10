#include <iostream>
#include <vector>
#include <cstring>
#include <queue>

using namespace std;

int n, e;
int a, b, c;
int v1, v2;
int INF = 1600001;
int dist[801]; //정점을 하나씩 추가해가며 1번 정점으로부터 각 정점까지의 최소거리를 업데이트
vector<pair<int, int>> v[801]; // 정점간의 거리 정보를 담기 위한 이중 벡터

void dijk(int idx) {
	for (int i = 1; i <= n; i++) {
		dist[i] = INF;
	}
	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
	pq.push({ 0, idx });
	dist[idx] = 0;

	while (!pq.empty()) {
		int distance = pq.top().first;
		int x = pq.top().second;
		pq.pop();
		
	if (dist[x] < distance) 
		continue;

		for (auto a : v[x]) {
			int nx = a.first;
			int ndist = distance + a.second;

			if (dist[nx] > ndist) {//여태까지 저장된 nx정점까지의 최단거리보다 nx정점을 통해 가는 것이 더 짧은 경우
				pq.push({ ndist, nx });
				dist[nx] = ndist;
			}
		}
	}
}

int main() {
	cin >> n >> e;

	for (int i = 0; i < e; i++) {
		cin >> a >> b >> c;
		v[a].push_back({ b,c });
		v[b].push_back({ a,c });
	}

	cin >> v1 >> v2;

	dijk(1);
	int st_v1 = dist[v1];
	int st_v2 = dist[v2];

	dijk(v1);
	int v1_n = dist[n];
	int v1_v2 = dist[v2];

	dijk(v2);
	int v2_n = dist[n];

	int ans = min(st_v1 + v1_v2 + v2_n, st_v2 + v1_v2 + v1_n);

	if (ans >= INF)
		cout << -1;
	else
		cout << ans;


	return 0;
}
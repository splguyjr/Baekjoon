#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

#define INF 1e9

using namespace std;

int v, e, k;
int x, y, d;

vector<pair<int, int>> vec[20001];
priority_queue<pair<int, int>, vector<pair<int,int>>, greater<pair<int, int>>> pq;
int dist[20001];//최단거리 정보를 담는 배열

void dijstra(int x) {
	dist[x] = 0;//시작점이므로 거리 0

	pq.push({ 0, x });//시작점 우선순위큐에 push

	while (!pq.empty()) {
		int start_cur_dist = pq.top().first;
		int cur = pq.top().second;
		
		pq.pop();

		if (dist[cur] < start_cur_dist) continue;//앞서 최단거리가 갱신되는 상황이라 push하였지만, 큐내에서 우선순위에 밀려 다른 정점을 통해 이미 최단거리가 갱신된 상황을 최적화

		for (int i = 0; i < vec[cur].size(); i++) {
			int next = vec[cur][i].first;//현재 정점 cur과 연결된 정점 인덱스
			int start_next_dist = start_cur_dist + vec[cur][i].second;//시작점으로부터 현재 방문한 정점 cur까지의 거리 + cur과 연결된 정점까지의 거리

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

	cin >> v >> e;
	cin >> k;


	for (int i = 0; i < e; i++) {
		cin >> x >> y >> d;
		vec[x].push_back({ y,d });
	}

	fill(dist + 1, dist + v + 1, INF);//초기 거리 모두 INF로 초기화

	dijstra(k);

	for (int i = 1; i <= v; i++) {
		if (dist[i] == INF) {//다익스트라 알고리즘을 돌리고도 INF인 정점의 경우 시작점에서 절대로 방문할 수 없는 정점이므로 INF출력
			cout << "INF" << '\n';
			continue;
		}
		cout << dist[i] << '\n';
	}


	return 0;
}
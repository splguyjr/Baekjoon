#include <iostream>
#include <queue>
#include <vector>
#define INF 987654321

using namespace std;

int n, m;
int x, y, cost;
vector<pair<int, int>> v[1001];

int main() {
	cin >> n >> m;


	for(int i =0; i<m; i++) {
		cin >> x >> y >> cost;
		v[x].push_back({ y,cost });
	}

	cin >> x >> y;

	vector<int> dist(n + 1, INF);
	priority_queue<pair<int, int>> pq;

	dist[x] = 0;
	pq.push({ 0,x });
	//우선순위큐는 오름차순으로 정렬되므로 cost가 제일 작은 것이 top에 위치하도록 곱하기 -1
	while (!pq.empty()) {
		int cost = pq.top().first * -1;
		int here = pq.top().second;
		pq.pop();
		if (dist[here] < cost) continue; //이미 저장된 가중치가 더 작다면 스킵
		
		for (int i = 0; i < v[here].size(); i++){
			int next = cost + v[here][i].second;
			int dest = v[here][i].first;

			if (dist[dest] > next) {
				dist[dest] = next;
				pq.push({ next * -1, dest });
			}

		}
	}
		 
	cout << dist[y];

	return 0;
}
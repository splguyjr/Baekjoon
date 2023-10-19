#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector<int>tube[1001];//각 하이퍼튜브에 소속된 역들을 담음
vector<int> station[100001];//각 역이 소속된 하이퍼튜브 번호들을 담음
queue<int> q;//역 번호
int visited[100001];
int visited_loop[1001];
int d[100001];//몇번횟수로 방문했는지
int n, k, m;

void bfs() {

	//다음역은 그 역이 소속된 하이퍼튜브들을 먼저 탐색하고 각각에 대해 소속된 역들을 탐색
	while (!q.empty()) {
		int x = q.front();
		
		q.pop();

		for (int i = 0; i < station[x].size(); i++) {
			int hyper = station[x][i];//해당 역이 속하는 하이퍼튜브 인덱스
			if (visited_loop[hyper]) continue;
			visited_loop[hyper] = 1;
			for (int j = 0; j < tube[hyper].size(); j++) {
				if (!visited[tube[hyper][j]]) {
					q.push(tube[hyper][j]);
					visited[tube[hyper][j]] = 1;

					if (d[tube[hyper][j]]) continue;
					d[tube[hyper][j]] = d[x] + 1;
				}
			}
		}
	}
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    
	cin >> n >> k >> m;

	for (int i = 1; i <= m; i++) {
		for (int j = 1; j <= k; j++) {
			int tmp;
			cin >> tmp;
			tube[i].push_back(tmp);
			station[tmp].push_back(i);			
		}
	}

	q.push(1);
	d[1] = 1;
	bfs();
	if (!d[n]) cout << -1;
	else cout << d[n];

	
	return 0;
}
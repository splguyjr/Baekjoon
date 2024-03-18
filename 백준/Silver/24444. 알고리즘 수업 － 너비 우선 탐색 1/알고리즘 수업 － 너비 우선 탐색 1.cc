#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

int n, m, r;
int visited[100001];
vector<int> v[100001];

queue<int> q;

void bfs() {
	int cnt = 1;

	while (!q.empty()) {
		int x = q.front();
		q.pop();

		for (auto e : v[x]) {
			if (!visited[e]) {
				visited[e] = ++cnt;
				q.push(e);
			}
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n >> m >> r;

	int a, b;

	for (int i = 1; i <= m; i++) {
		cin >> a >> b;
		v[a].push_back(b);
		v[b].push_back(a);
	}

	
	for (int i = 1; i <= n; i++) {
		sort(v[i].begin(), v[i].end());
	}
	

	q.push(r);
	visited[r] = 1;

	bfs();

	for (int i = 1; i <= n; i++) {
		cout << visited[i] << '\n';
	}

	return 0;
}
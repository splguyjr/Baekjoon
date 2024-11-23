#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int n, w, u, v;
vector<int> tree[500001];
int visited[500001];
queue<int> q;

void input() {

	cin >> n >> w;

	for (int i = 0; i < n-1; i++) {
		cin >> u >> v;
		tree[u].push_back(v);
		tree[v].push_back(u);
	}
}

void bfs() {
	q.push(1);

	while (!q.empty()) {
		int x = q.front();
		visited[x] = 1;
		q.pop();

		for (int i = 0; i < tree[x].size(); i++) {
			int nx = tree[x][i];
			if (!visited[nx]) {
				q.push(nx);
				visited[x]++;
			}
		}
	}
}

int count_child() {
	int cnt = 0;

	for (int i = 1; i <= n; i++) {
		if (visited[i] == 1) {
			cnt++;
		}
	}

	return cnt;
}

int main() {

	input();
	bfs();
	int child = count_child();
	double ans = (double)w / child;

	cout << fixed;
	cout.precision(6);
	cout << ans;

	return 0;
}
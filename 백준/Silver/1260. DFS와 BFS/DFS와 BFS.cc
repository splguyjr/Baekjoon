#include <iostream>
#include <queue>
#include <stack>
#include <algorithm>

using namespace std;

vector<vector<int>> graph(1001);
bool visited[2][1001];
int n, m, v;

queue<int> q;
stack<int> s;

void dfs(int v) {
	s.push(v);

	while(!s.empty()) {

	v = s.top();
	s.pop();

	if (visited[0][v]) continue;

	visited[0][v] = true;
	cout << v << ' ';

	for (auto i = graph[v].rbegin(); i != graph[v].rend(); ++i) {
		if (!visited[0][*i]) {
			s.push(*i);
		}
	}

	}
}

void bfs(int v) {
	q.push(v);

	while (!q.empty()) {
		v = q.front();
		q.pop();

		if (visited[1][v]) continue;
		
		visited[1][v] = true;
		cout << v << ' ';

		for (auto i = graph[v].begin(); i != graph[v].end(); ++i) {
			if (!visited[1][*i])
				q.push(*i);
		}
	}
}

int main() {
	cin >> n >> m >> v;

	int a, b;
	while (m--) {
		cin >> a >> b;
		graph[a].push_back(b);
		graph[b].push_back(a);
	}

	for (int i = 0; i < graph.size(); ++i)
		sort(graph[i].begin(), graph[i].end());
	dfs(v);
	cout << endl;
	bfs(v);
	return 0;

	
}
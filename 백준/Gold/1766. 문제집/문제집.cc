#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int n, m;
vector<int> v[32001];
int s[32001];


void topologicalSort() {
	priority_queue<int,vector<int>, greater<int>> pq;

	for (int i = 1; i <= n; i++) {
		if (s[i] == 0) pq.push(i);
	}

	while (!pq.empty()) {
		int x = pq.top();
		pq.pop();

		cout << x << " ";
	
		for (int i = 0; i < v[x].size(); i++) {
			s[v[x][i]]--;
			if (s[v[x][i]] == 0) pq.push(v[x][i]);

		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n >> m;

	int a, b;

	for (int i = 0; i < m; i++) {
		cin >> a >> b;
		v[a].push_back(b);
		s[b]++;
	}

	topologicalSort();

	



	return 0;
}
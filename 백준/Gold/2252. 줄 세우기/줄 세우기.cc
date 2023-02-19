#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int n, m;

int group_size[32001];
vector<int> v[100001];

void topologicalSort() {
	queue<int> q;
	for (int i = 1; i <= n; i++) {
		if (group_size[i] == 0) q.push(i);
	}

	while (!q.empty()) {
		int x = q.front();
		cout << x << " ";
		q.pop();

		for (int i = 0; i < v[x].size(); i++) {
			group_size[v[x][i]]--;
			if (group_size[v[x][i]] == 0) q.push(v[x][i]);
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
		group_size[b]++;
	}

	topologicalSort();



	return 0;
}
#include <iostream>
#include <vector>

using namespace std;

int n;
int parent[100001];
vector<int> v[100001];

void dfs(int x) {
	for (int i = 0; i < v[x].size(); i++) {
		int p = v[x][i];
		if (parent[p] == 0) {
			parent[p] = x;
			dfs(p);
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n;

	int a, b;
	for (int i = 0; i < n-1; i++) {
		cin >> a >> b;
		v[a].push_back(b);
		v[b].push_back(a);
	}

	dfs(1);

	for (int i = 2; i <= n; i++) {
		cout << parent[i] << '\n';
	}
	


	return 0;
}
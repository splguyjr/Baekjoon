#include <iostream>
#include <vector>

using namespace std;

int n, m;
bool visited[101];
vector<int> v[101];
int ans = 0;

void dfs(int idx) {
	visited[idx] = true;
	for (int i = 0; i < v[idx].size(); i++) {
		if (!visited[v[idx][i]]) {
			ans++;
			dfs(v[idx][i]);
		}
	}
}


int main() {
	cin >> n >> m;

	
	int x, y;

	for (int i = 0; i < m; i++) {
		cin >> x >> y;
		v[x].push_back(y);
		v[y].push_back(x);
	}

	dfs(1);

	cout << ans;



	return 0;
}
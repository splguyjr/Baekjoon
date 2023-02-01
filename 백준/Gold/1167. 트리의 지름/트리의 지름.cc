#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<pair<int, int>> tree[100001];
int visited[100001];
int n, st, ed, dist;
int ans;
int far;

void dfs(int x, int total) {
	visited[x] = 1;
	if (ans < total) {
		ans = total;
		far = x;
	}
	for (int i = 0; i < tree[x].size(); i++) {
		int y = tree[x][i].first;//도착정점
		int z = tree[x][i].second + total;//도착정점까지의거리
		if (!visited[y]) {
			visited[y] = 1;
			dfs(y, z);
			visited[y] = 0;
		}
	}
	visited[x] = 0;

}


int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cin >> n;
	
	for (int i = 0; i < n; i++) {
		cin >> st;
		while(true) {
		cin >> ed;
		if (ed == -1) break;
		cin >> dist;
		tree[st].push_back({ed, dist});
		}
	}

	dfs(1, 0);
	ans = 0;
	dfs(far, 0);
	

	cout << ans;


	return 0;
}
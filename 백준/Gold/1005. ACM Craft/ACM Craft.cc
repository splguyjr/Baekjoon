#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <cstring>
using namespace std;

int t, n, k;

int build_time[1001];

vector<int> adj[1001];
int indeg[1001];
int result[1001];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> t;

	while (t--) {
		memset(adj, 0, sizeof(adj));
		memset(indeg, 0, sizeof(indeg));
		memset(result, 0, sizeof(result));

		cin >> n >> k;

		
		for (int i = 1; i <= n; i++) {
			cin >> build_time[i];
		}

		

		for (int i = 0; i < k; i++) {
			int x, y;
			cin >> x >> y;
			adj[x].push_back(y);
			indeg[y]++;
		}

		int target;
		cin >> target;

		queue<int> q;

		for (int i = 1; i <= n; i++) {
			if (indeg[i] == 0) {
				q.push(i);

				result[i] = build_time[i];
			}
		}

		
		while (!q.empty()) {
			int cur = q.front();
			q.pop();

			for (int i = 0; i < adj[cur].size(); i++) {
				int next = adj[cur][i];
				indeg[next]--;
				result[next] = max(result[next], result[cur] + build_time[next]);

				if (indeg[next] == 0) {
					q.push(next);
				}
			}
		}

		cout << result[target] << '\n';
	}

	return 0;
}
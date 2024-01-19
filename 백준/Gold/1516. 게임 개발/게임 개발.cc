#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

int n;
vector<int> v[501];
queue<int> q;
int indegree[501];
int t[501];
int total_time[501];


void top_sort() {

	while (!q.empty()) {
		int x = q.front();
		q.pop();
		for (auto i : v[x]) {
			indegree[i]--;

			total_time[i] = max(total_time[i], total_time[x] + t[i]);
			if (indegree[i] == 0) {
				q.push(i);
			}
		}
		
	}

}


int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n;

	int x;

	for (int i = 1; i <= n; i++) {
		cin >> t[i];
		while (1) {
			cin >> x;
			if (x == -1) break;
			v[x].push_back(i);
			indegree[i]++;
		}
	}

	for (int i = 1; i <= n; i++) {
		if (indegree[i] == 0) {
			q.push(i);
			total_time[i] = t[i];
		}
	}

	top_sort();

	for (int i = 1; i <= n; i++) {
		cout << total_time[i] << '\n';
	}

	return 0;
}
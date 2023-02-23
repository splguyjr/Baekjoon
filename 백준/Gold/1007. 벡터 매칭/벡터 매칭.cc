#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>

using namespace std;

int t, n;
bool visited[21];
pair<int, int> a;
pair<int, int> b;
vector<pair<int, int>> v;
double min_len;

void dfs(int cnt, int idx) {
	a = { 0,0 };
	b = { 0,0 };
	double len;
	if (cnt == 0) {
		for (int i = 0; i < n; i++) {
			if (visited[i]) {
				a.first += v[i].first;
				a.second += v[i].second;
			}
			else {
				b.first += v[i].first;
				b.second += v[i].second;
			}
		}
		len = sqrt(pow(b.first - a.first, 2) + pow(b.second - a.second, 2));
		if (min_len > len) min_len = len;
		return;
	}
	else {
		for (int i = idx; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(cnt - 1, i);
				visited[i] = false;
			}
		}
	}
	return;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> t;

	while (t--) {
		cin >> n;
		v.resize(n);
		int x, y;
	
		for (int i = 0; i < n; i++) {
			cin >> x >> y;
			v[i] = { x,y };
		}

		min_len = 10000000;

		dfs(n / 2, 0);
		cout << fixed;
		cout.precision(7);
		cout << min_len << '\n';

	}

	return 0;
}
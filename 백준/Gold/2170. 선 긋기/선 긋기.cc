#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

const int INF = 1e9 + 1;

int n;
int x, y;
int l = -INF;
int r = -INF;

vector<pair<int, int>> v;
int total = 0;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> x >> y;
		v.push_back({ x,y });
	}
	sort(v.begin(), v.end());

	for (int i = 0; i < n; i++) {
		if (r < v[i].first) {
			total += r - l;
			l = v[i].first;
			r = v[i].second;
		}

		else r = max(r, v[i].second);
	}

	total += r - l;
	cout << total;
	


	return 0;
}
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n;
int x, y;
vector<pair<int, int>> v;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n;

	while (n--) {
		cin >> x >> y;
		v.push_back({ x,y });
	}

	sort(v.begin(), v.end());

	for (int i = 0; i < v.size(); i++) {
		cout << v[i].first << " " << v[i].second << '\n';
	}

	return 0;
}
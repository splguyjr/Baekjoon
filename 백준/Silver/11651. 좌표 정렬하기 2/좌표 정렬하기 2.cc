#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int n;
vector<pair<int, int>> v;

bool compare(const pair<int, int>& x,const pair<int, int>& y) {
	if (x.second < y.second)
		return true;
	else if (x.second > y.second)
		return false;
	else
		return x.first < y.first;
}

int main() {
	cin >> n;

	int x, y;
	for (int i = 0; i < n; i++) {
		cin >> x >> y;
		v.push_back({ x, y });
	}

	sort(v.begin(), v.end(), compare);

	for (const auto& x : v) {
		cout << x.first << " " << x.second << '\n';
	}

	return 0;
}
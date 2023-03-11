#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n;
vector<pair<int, int>> v;
int cnt = 1;

int main() {
	cin >> n;
	int x, y;
	for (int i = 0; i < n; i++) {
		cin >> x >> y;
		v.push_back({ y,x });
	}

	sort(v.begin(), v.end());

	int a = v[0].first;
	int b = v[0].second;

	for (int i = 1; i < n; i++) {
		if (a <= v[i].second) {
			cnt++;
			a = v[i].first;
		}

	}
		 
	cout << cnt;
	return 0;
}
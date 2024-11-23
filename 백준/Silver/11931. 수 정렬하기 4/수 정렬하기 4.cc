#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int n;
vector<int> v;

bool compare(int a, int b) {
	return a >= b;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n;

	int x;

	for (int i = 0; i < n; i++) {
		cin >> x;
		v.push_back(x);
	}

	sort(v.begin(), v.end(), compare);

	for (auto x : v) {
		cout << x << '\n';
	}
	
	/*sort(v.begin(), v.end(), greater<int>());

	for (auto x : v) {
		cout << x << '\n';
	}*/


	return 0;
}
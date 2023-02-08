#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> arr, seq;
int n;
int ans = 1;

void solve() {

	seq.emplace_back(arr[0]);
	for (int i = 1; i < n; i++) {
		if (seq.back() >= arr[i]) {
			int p = lower_bound(seq.begin(), seq.end(), arr[i]) -seq.begin();
			seq[p] = arr[i];
		}
		else {
			seq.emplace_back(arr[i]);
			ans++;
		}

	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n;

	arr.resize(n);

	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}

	solve();

	cout << ans;


	return 0;
}
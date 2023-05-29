#include <iostream>
#include <algorithm>

using namespace std;

int n, m;
int arr[100001];
int ans = 2000000000;

int main() {
	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}

	sort(arr, arr + n);

	int st = 0, ed = 0;

	while (st < n && ed < n) {
		int temp = arr[ed] - arr[st];
		if (temp < m) {
			ed++;
		}
		else {
			ans = min(ans, temp);
			st++;
		}
	}

	cout << ans;

	return 0;
}
#include <iostream>
#include <algorithm>

using namespace std;

int arr[100001];
int sum_arr[100001];
int n, k;
int ans = -1e9;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n >> k;

	for (int i = 1; i <= n; i++) {
		cin >> arr[i];
		sum_arr[i] += sum_arr[i - 1] + arr[i];
	}

	for (int i = 1; i <= n - k + 1; i++) {
		ans = max(ans, sum_arr[i + k-1] - sum_arr[i-1]);
	}
	
	cout << ans;

	return 0;
}
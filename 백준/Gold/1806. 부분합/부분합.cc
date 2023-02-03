#include <iostream>
#include <algorithm>

using namespace std;

int n, s;
int arr[100001];
int sum = 0;
int p1 = 0, p2 = 0;
int ans = 100001;

int main() {
	cin >> n >> s;

	for (int i = 0; i < n; i++) cin >> arr[i];

	while (p1 <= p2 && p2 <= n) {
		if (sum < s) {
			sum += arr[p2++];
		}

		else {
			ans = min(ans, p2 - p1);
			sum -= arr[p1++];
		}
		
	}

	if (ans == 100001) {
		cout << 0;
		return 0;
	}
	cout << ans;

	return 0;
}
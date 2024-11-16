#include <iostream>

using namespace std;

int t, n;
int arr[1000001];

int main() {
	cin >> t;

	int cnt = 1;
	while (t--) {
		cin >> n;
		long long profit = 0;
		for (int i = 0; i < n; i++) {
			cin >> arr[i];
		}
		int last = arr[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			if (arr[i] <= last) {
				profit += last - arr[i];
			}
			else {
				last = arr[i];
			}
		}

		cout << "#" << cnt << ' ' << profit << '\n';
		cnt++;
	}

	return 0;
}
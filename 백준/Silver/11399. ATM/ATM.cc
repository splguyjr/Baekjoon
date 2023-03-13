#include <iostream>
#include <algorithm>

using namespace std;

int n;
int arr[1001];
int ans = 0;
int main() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}

	sort(arr, arr + n);

	for (int i = 0; i < n; i++) {
		for (int j = 0; j <= i; j++) {
			ans += arr[j];
		}
	}

	cout << ans;

	return 0;
}
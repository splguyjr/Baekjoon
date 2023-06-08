#include <iostream>

using namespace std;

int n, m;
int t;
int a, b, c, d;
int arr[301][301];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n >> m;

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			cin >> arr[i][j];
		}
	}

	cin >> t;

	while (t--) {
		int ans = 0;

		cin >> a >> b >> c >> d;

		for (int i = a; i <= c; i++) {
			for (int j = b; j <= d; j++) {
				ans += arr[i][j];
			}
		}

		cout << ans << '\n';
	}
	return 0;
}
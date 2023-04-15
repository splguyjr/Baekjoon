#include <iostream>

using namespace std;

int t, n, m;


int main() {
	cin >> t;

	

	while (t--) {
		int ans = 1;
		cin >> n >> m;
		if (n > m / 2) {
			n = m - n;
		}

		for (int i = 1; i <= n; i++) {
			ans *= m;
			ans /= i;
			m--;
		}

		cout<< ans << '\n';
	}

	return 0;
}
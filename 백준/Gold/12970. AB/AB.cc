#include <iostream>

using namespace std;

int n, k;

int main() {
	cin >> n >> k;

	if (k > (n / 2 + n % 2) * (n / 2)) {
		cout << -1;
		return 0;
	}

	else if (k == 0) {
		for (int i = 0; i < n / 2; i++) {
			cout << "B";
		}
		for (int i = n/2; i < n; i++) {
			cout << "A";
		}
	}

	else {
		int sum = 0;
		int count_a = 0;
		for (int i = 0; i < n; i++) {
			if (sum != k && sum + n - i -count_a- 1 <= k) {
				sum += n - i - 1;
				sum -= count_a++;
				cout << "A";
			}
			else
				cout << "B";
		}
	}

	return 0;
}
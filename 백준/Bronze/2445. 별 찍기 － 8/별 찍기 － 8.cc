#include <iostream>
#include <cmath>

using namespace std;

int main() {
	int n;
	cin >> n;

	for (int i = 1; i <= 2 * n - 1; i++) {
		for (int k = (2 * n - 1 - 2* abs(n - i)) / 2; k >= 0; k--) {
			cout << "*";
		}

		for (int j = 0; j < abs(n - i); j++) {
			cout << "  ";
		}

		for (int k = (2 * n - 1 -2* abs(n - i)) / 2; k >= 0; k--) {
			cout << "*";
		}

		cout << '\n';
	}


	return 0;
}
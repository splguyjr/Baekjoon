#include <iostream>

using namespace std;

int main() {
	int n;
	cin >> n;
	for (int i = n; i > 0; i--) {
		for (int k = 0; k < (2 * n - 2 * i) / 2; k++) {
			cout << " ";
		}
		for (int j = 2*i-1; j > 0; j--) {

			cout << "*";
		}

		cout << '\n';
	}


	return 0;
}
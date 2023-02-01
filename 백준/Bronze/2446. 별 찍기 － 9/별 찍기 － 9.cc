#include <iostream>
#include <cmath>

using namespace std;

int main() {
	int n;
	cin >> n;

	for (int i = 1; i <= 2 * n - 1; i++) {
		for (int k = 0; k < (2 * n - 2 * abs(n - i) - 2)/2; k++) {
			cout << " ";
		}

		for (int j = 0; j < 2 * abs(n - i) + 1; j++)
		{
			cout << "*";
		}
		cout << '\n';
	}


	return 0;
}
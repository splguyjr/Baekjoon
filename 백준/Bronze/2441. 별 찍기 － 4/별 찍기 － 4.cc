#include <iostream>

using namespace std;

int main() {
	int n;
	cin >> n;
	int x = n;

	while (n--) {
		for (int i = x-n; i >1 ; i--) {
			cout << " ";
		}
		for (int i = 0; i <= n; i++) {
			cout << "*";
		}
		cout << '\n';
	}

	return 0;
}
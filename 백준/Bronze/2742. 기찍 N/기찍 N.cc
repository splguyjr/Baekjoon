#include <iostream>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	int n;
	cin >> n;

	while (n) {
		cout << n << '\n';
		n--;
	}

	return 0;
}